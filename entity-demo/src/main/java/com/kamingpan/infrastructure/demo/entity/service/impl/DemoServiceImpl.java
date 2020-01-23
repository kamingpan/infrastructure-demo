package com.kamingpan.infrastructure.demo.entity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kamingpan.infrastructure.core.base.enumeration.DataStatusEnum;
import com.kamingpan.infrastructure.core.base.service.BaseServiceImpl;
import com.kamingpan.infrastructure.core.exception.DataNotExistException;
import com.kamingpan.infrastructure.core.exception.ValidateException;
import com.kamingpan.infrastructure.core.log.OperateLog;
import com.kamingpan.infrastructure.core.response.Pager;
import com.kamingpan.infrastructure.core.util.ChangeDetails;
import com.kamingpan.infrastructure.demo.entity.constant.DemoConstant;
import com.kamingpan.infrastructure.demo.entity.dao.DemoDao;
import com.kamingpan.infrastructure.demo.entity.model.dto.DemoDTO;
import com.kamingpan.infrastructure.demo.entity.model.entity.Demo;
import com.kamingpan.infrastructure.demo.entity.model.vo.DemoVO;
import com.kamingpan.infrastructure.demo.entity.service.DemoService;
import com.kamingpan.infrastructure.entity.constant.AdminOperateLogConstant;
import com.kamingpan.infrastructure.entity.model.entity.AdminOperateLog;
import com.kamingpan.infrastructure.util.sql.SqlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 示例 服务实现类
 *
 * @author kamingpan
 * @since 2019-04-09
 */
@Slf4j
@Service
@Transactional(readOnly = true)
public class DemoServiceImpl extends BaseServiceImpl<Demo, DemoDao> implements DemoService {

    /**
     * 新增示例.
     *
     * @param demo            示例
     * @param adminOperateLog 操作日志
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @OperateLog(type = AdminOperateLogConstant.Type.INSERT)
    public void insert(Demo demo, AdminOperateLog adminOperateLog) {
        if (0 < this.countByName(null, demo.getName())) {
            throw new ValidateException("该名称已存在");
        }

        super.insert(demo);

        // 记录操作日志信息
        adminOperateLog.setBelong("Demo");
        adminOperateLog.setBelongId(demo.getId());
        adminOperateLog.setContent(ChangeDetails.getByCreate(demo, DemoConstant.getFieldMap()));
    }

    /**
     * 修改示例
     *
     * @param demo            示例
     * @param adminOperateLog 操作日志
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @OperateLog(type = AdminOperateLogConstant.Type.UPDATE)
    public void update(Demo demo, AdminOperateLog adminOperateLog) {
        if (0 < this.countByName(demo.getId(), demo.getName())) {
            throw new ValidateException("该名称已存在");
        }

        Demo before = super.getById(demo.getId());
        if (null == before) {
            throw new DataNotExistException();
        }
        super.updateById(demo);

        // 记录操作日志信息
        adminOperateLog.setBelong("Demo");
        adminOperateLog.setBelongId(demo.getId());
        adminOperateLog.setContent(ChangeDetails.getByUpdate(before, demo, DemoConstant.getFieldMap()));
    }

    /**
     * 示例删除
     *
     * @param id              示例主键
     * @param adminOperateLog 操作日志
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @OperateLog(type = AdminOperateLogConstant.Type.DELETE)
    public void delete(String id, AdminOperateLog adminOperateLog) {
        // 判断示例是否存在
        if (0 >= this.countById(id)) {
            throw new DataNotExistException();
        }

        // 删除所有示例
        super.baseMapper.deleteById(id);

        // 记录操作日志信息
        adminOperateLog.setBelong("Demo");
        adminOperateLog.setBelongId(id);
    }

    /**
     * 示例批量删除
     *
     * @param ids 示例主键列表
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByIds(List<String> ids) {
        for (String id : ids) {
            if (null != id && !id.isEmpty()) {
                this.delete(id, new AdminOperateLog());
            }
        }
    }

    /**
     * 启用示例
     *
     * @param id              主键
     * @param adminOperateLog 操作日志
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @OperateLog(type = AdminOperateLogConstant.Type.ENABLE)
    public void updateStatusToEnableById(String id, AdminOperateLog adminOperateLog) {
        if (0 >= super.baseMapper.countById(id)) {
            throw new DataNotExistException();
        }

        Demo demo = new Demo();
        demo.setId(id);
        demo.setStatus(DemoConstant.Status.ENABLE);
        demo.preUpdate();
        super.baseMapper.updateById(demo);

        // 记录操作日志信息
        adminOperateLog.setBelong("Demo");
        adminOperateLog.setBelongId(id);
    }

    /**
     * 禁用示例
     *
     * @param id              主键
     * @param adminOperateLog 操作日志
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @OperateLog(type = AdminOperateLogConstant.Type.DISABLE)
    public void updateStatusToDisableById(String id, AdminOperateLog adminOperateLog) {
        if (0 >= super.baseMapper.countById(id)) {
            throw new DataNotExistException();
        }

        Demo demo = new Demo();
        demo.setId(id);
        demo.setStatus(DemoConstant.Status.DISABLE);
        demo.preUpdate();
        super.baseMapper.updateById(demo);

        // 记录操作日志信息
        adminOperateLog.setBelong("Demo");
        adminOperateLog.setBelongId(id);
    }

    /**
     * 根据示例查询示例信息
     *
     * @param demo  示例dto
     * @param pager 分页
     * @return 示例vo列表
     */
    @Override
    public List<DemoVO> listByDemo(DemoDTO demo, Pager pager) {
        demo.setName(SqlUtil.like(demo.getName()));
        demo.setPhone(SqlUtil.like(demo.getPhone()));

        if (null == pager) {
            return super.baseMapper.listByDemo(demo, DataStatusEnum.NOT_DELETED.getValue());
        }

        Page page = PageHelper.startPage(pager.getPageNum(), pager.getPageSize());
        if (null != pager.getOrderBy() && !pager.getOrderBy().isEmpty()) {
            page.setOrderBy(pager.getOrderBy());
        }

        List<DemoVO> demos = super.baseMapper.listByDemo(demo, DataStatusEnum.NOT_DELETED.getValue());
        // 设置数据总数
        pager.setTotal(page.getTotal());

        return demos;
    }

    /**
     * 根据主键查询示例详情
     *
     * @param id 主键
     * @return 示例vo
     */
    @Override
    public DemoVO getDemoById(String id) {
        return super.baseMapper.getDemoById(id, DataStatusEnum.NOT_DELETED.getValue());
    }

    /**
     * 根据名称查询示例数量
     *
     * @param id   示例主键
     * @param name 名称
     * @return 示例数量
     */
    @Override
    public int countByName(String id, String name) {
        if (null == name || name.isEmpty()) {
            return 0;
        }

        QueryWrapper<Demo> queryWrapper = new QueryWrapper<Demo>();
        queryWrapper.eq("name", name);
        if (null != id && !id.isEmpty()) {
            queryWrapper.and(function -> function.ne("id", id));
        }

        return this.baseMapper.selectCount(queryWrapper);
    }

}
