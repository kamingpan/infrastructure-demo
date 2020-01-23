package com.kamingpan.infrastructure.demo.entity.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 示例常量
 *
 * @author kamingpan
 * @since 2019-04-09
 */
public class DemoConstant {

    private static Map<String, String> fieldMap;

    /**
     * 字段解析
     *
     * @return 字段解析
     */
    public static Map<String, String> getFieldMap() {
        if (null != DemoConstant.fieldMap) {
            return DemoConstant.fieldMap;
        }

        DemoConstant.fieldMap = new HashMap<String, String>();
        DemoConstant.fieldMap.put("name", "名称");
        DemoConstant.fieldMap.put("phone", "手机号码");
        DemoConstant.fieldMap.put("picture", "图片");
        DemoConstant.fieldMap.put("hobby", "爱好");
        DemoConstant.fieldMap.put("email", "电子邮箱");
        DemoConstant.fieldMap.put("status", "状态");
        DemoConstant.fieldMap.put("attachment", "附件");
        DemoConstant.fieldMap.put("introduction", "介绍");
        DemoConstant.fieldMap.put("remark", "备注");
        return DemoConstant.fieldMap;
    }

    /**
     * 状态
     */
    public static final class Status {
        /**
         * 正常
         */
        public static final Integer ENABLE = 0;

        /**
         * 禁用
         */
        public static final Integer DISABLE = 1;
    }

    /**
     * 权限字符串
     */
    public static final class Authentication {
        /**
         * 列表
         */
        public static final String LIST = "hasPermission('', '" + "demo:list" + "')";
        /**
         * 详情
         */
        public static final String INFO = "hasPermission('', '" + "demo:info" + "')";
        /**
         * 新增
         */
        public static final String INSERT = "hasPermission('', '" + "demo:insert" + "')";
        /**
         * 修改
         */
        public static final String UPDATE = "hasPermission('', '" + "demo:update" + "')";
        /**
         * 删除
         */
        public static final String DELETE = "hasPermission('', '" + "demo:delete" + "')";
        /**
         * 启用
         */
        public static final String ENABLE = "hasPermission('', '" + "demo:enable" + "')";
        /**
         * 禁用
         */
        public static final String DISABLE = "hasPermission('', '" + "demo:disable" + "')";
    }

}
