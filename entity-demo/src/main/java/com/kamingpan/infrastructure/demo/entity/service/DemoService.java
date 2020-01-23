package com.kamingpan.infrastructure.demo.entity.service;

import com.kamingpan.infrastructure.core.base.service.BaseService;
import com.kamingpan.infrastructure.core.response.Pager;
import com.kamingpan.infrastructure.demo.entity.model.dto.DemoDTO;
import com.kamingpan.infrastructure.demo.entity.model.entity.Demo;
import com.kamingpan.infrastructure.demo.entity.model.vo.DemoVO;
import com.kamingpan.infrastructure.entity.model.entity.AdminOperateLog;

import java.util.List;

/**
 * 示例 服务类
 *
 * @author kamingpan
 * @since 2019-04-09
 */
public interface DemoService extends BaseService<Demo> {

    /**
     * 新增示例.
     *
     * @param demo            示例
     * @param adminOperateLog 操作日志
     */
    void insert(Demo demo, AdminOperateLog adminOperateLog);

    /**
     * 修改示例
     *
     * @param demo            示例
     * @param adminOperateLog 操作日志
     */
    void update(Demo demo, AdminOperateLog adminOperateLog);

    /**
     * 示例删除
     *
     * @param id              示例主键
     * @param adminOperateLog 操作日志
     */
    void delete(String id, AdminOperateLog adminOperateLog);

    /**
     * 示例批量删除
     *
     * @param ids 示例主键列表
     */
    void deleteByIds(List<String> ids);

    /**
     * 启用示例
     *
     * @param id              主键
     * @param adminOperateLog 操作日志
     */
    void updateStatusToEnableById(String id, AdminOperateLog adminOperateLog);

    /**
     * 禁用示例
     *
     * @param id              主键
     * @param adminOperateLog 操作日志
     */
    void updateStatusToDisableById(String id, AdminOperateLog adminOperateLog);

    /**
     * 根据示例查询示例信息
     *
     * @param demo  示例dto
     * @param pager 分页
     * @return 示例vo列表
     */
    List<DemoVO> listByDemo(DemoDTO demo, Pager pager);

    /**
     * 根据主键查询示例详情
     *
     * @param id 主键
     * @return 示例vo
     */
    DemoVO getDemoById(String id);

    /**
     * 根据名称查询示例数量
     *
     * @param id   示例主键
     * @param name 名称
     * @return 示例数量
     */
    int countByName(String id, String name);

}
