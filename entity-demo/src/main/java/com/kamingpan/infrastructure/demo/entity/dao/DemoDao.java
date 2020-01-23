package com.kamingpan.infrastructure.demo.entity.dao;

import com.kamingpan.infrastructure.core.base.dao.BaseDao;
import com.kamingpan.infrastructure.demo.entity.model.dto.DemoDTO;
import com.kamingpan.infrastructure.demo.entity.model.entity.Demo;
import com.kamingpan.infrastructure.demo.entity.model.vo.DemoVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 示例 Mapper 接口
 *
 * @author kamingpan
 * @since 2019-04-09
 */
@Repository
public interface DemoDao extends BaseDao<Demo> {

    /**
     * 根据示例查询示例信息
     *
     * @param demo    示例dto
     * @param deleted 数据状态
     * @return 示例vo列表
     */
    List<DemoVO> listByDemo(@Param("demo") DemoDTO demo, @Param("deleted") Integer deleted);

    /**
     * 根据主键查询示例详情
     *
     * @param id      主键
     * @param deleted 数据状态
     * @return 示例vo
     */
    DemoVO getDemoById(@Param("id") String id, @Param("deleted") Integer deleted);

}
