-- ----------------------------
-- Table structure for demo
-- ----------------------------
-- DROP TABLE IF EXISTS `demo`;
CREATE TABLE IF NOT EXISTS `demo` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `phone` varchar(16) DEFAULT NULL COMMENT '手机号码',
  `picture` varchar(32) DEFAULT NULL COMMENT '图片',
  `hobby` varchar(64) DEFAULT NULL COMMENT '爱好',
  `email` varchar(64) DEFAULT NULL COMMENT '电子邮箱',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `attachment` varchar(512) DEFAULT NULL COMMENT '附件',
  `introduction` text DEFAULT NULL COMMENT '介绍',
  `remark` varchar(128) DEFAULT '' COMMENT '备注',
  `creator_id` varchar(32) DEFAULT NULL COMMENT '创建人主键',
  `creator` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(3) DEFAULT NULL COMMENT '创建时间',
  `updater_id` varchar(32) DEFAULT NULL COMMENT '修改人主键',
  `updater` varchar(32) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(3) DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否已删除（0：未删除，1：已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='示例';


-- 数据字典
INSERT INTO `system_data_dictionary`(`id`, `label`, `value`, `type`, `clazz`, `variable`, `sort`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES ('01001', '运动', '1', '整型（int）', 'Demo', 'hobby', 1, '示例 - 运动', NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_data_dictionary`(`id`, `label`, `value`, `type`, `clazz`, `variable`, `sort`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES ('01002', '看书', '2', '整型（int）', 'Demo', 'hobby', 2, '示例 - 看书', NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_data_dictionary`(`id`, `label`, `value`, `type`, `clazz`, `variable`, `sort`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES ('01003', '代码', '3', '整型（int）', 'Demo', 'hobby', 3, '示例 - 代码', NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_data_dictionary`(`id`, `label`, `value`, `type`, `clazz`, `variable`, `sort`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES ('01011', '正常', '0', '整型（int）', 'Demo', 'status', 1, '示例 - 正常', NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_data_dictionary`(`id`, `label`, `value`, `type`, `clazz`, `variable`, `sort`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES ('01012', '禁用', '1', '整型（int）', 'Demo', 'status', 2, '示例 - 禁用', NULL, NULL, NULL, NULL, 0);

-- 模块
INSERT INTO `system_module`(`id`, `name`, `icon`, `type`, `route`, `sort`, `superior`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES ('101', '示例', 'fa-star', 'load', '/demo/list', 90, '0', 0, '示例', NULL, NULL, NULL, NULL, 0);

-- 权限
INSERT INTO `system_permission`(`id`, `name`, `module_id`, `superior`, `icon`, `authentication`, `sort`, `method`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES ('201', '示例列表', '201', '0', 'fa-list', 'demo:list', 1, 'get', 0, '示例列表', NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission`(`id`, `name`, `module_id`, `superior`, `icon`, `authentication`, `sort`, `method`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES ('202', '示例详情', '201', '201', 'fa-info-circle', 'demo:info', 2, 'get', 0, '示例详情', NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission`(`id`, `name`, `module_id`, `superior`, `icon`, `authentication`, `sort`, `method`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES ('203', '示例新增', '201', '201', 'fa-plus', 'demo:insert', 3, 'post', 0, '示例新增', NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission`(`id`, `name`, `module_id`, `superior`, `icon`, `authentication`, `sort`, `method`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES ('204', '示例修改', '201', '202', 'fa-edit', 'demo:update', 4, 'put', 0, '示例修改', NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission`(`id`, `name`, `module_id`, `superior`, `icon`, `authentication`, `sort`, `method`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES ('205', '示例删除', '201', '201', 'fa-trash', 'demo:delete', 5, 'delete', 0, '示例删除', NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission`(`id`, `name`, `module_id`, `superior`, `icon`, `authentication`, `sort`, `method`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES ('206', '示例启用', '201', '201', 'fa-check-circle-o', 'demo:enable', 6, 'patch', 0, '示例启用', NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission`(`id`, `name`, `module_id`, `superior`, `icon`, `authentication`, `sort`, `method`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES ('207', '示例禁用', '201', '201', 'fa-ban', 'demo:disable', 7, 'patch', 0, '示例禁用', NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission`(`id`, `name`, `module_id`, `superior`, `icon`, `authentication`, `sort`, `method`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES ('208', '示例导出', '201', '201', 'fa-file-excel-o', 'demo:export', 8, 'get', 0, '示例导出', NULL, NULL, NULL, NULL, 0);
