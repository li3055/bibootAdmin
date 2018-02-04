-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    VALUES ('1', '', 'modules/user/goodrunresult.html', NULL, '1', 'fa fa-file-code-o', '6');

-- 按钮父菜单ID
SET @parentId = @@identity;

-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '查看', NULL, 'user:goodrunresult:list,user:goodrunresult:info', '2', NULL, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '新增', NULL, 'user:goodrunresult:save', '2', NULL, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '修改', NULL, 'user:goodrunresult:update', '2', NULL, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '删除', NULL, 'user:goodrunresult:delete', '2', NULL, '6';
