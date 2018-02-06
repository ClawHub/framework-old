package com.clawhub.auth.entity;

import javax.persistence.*;

@Table(name = "t_sys_permission")
public class SysPermission {
    /**
     * id
     */
    @Id
    private String id;

    /**
     * 创建人id
     */
    @Column(name = "create_operator_id")
    private String createOperatorId;

    /**
     * 创建人姓名
     */
    @Column(name = "create_operator_name")
    private String createOperatorName;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Long createTime;

    /**
     * 更新人id
     */
    @Column(name = "update_operator_id")
    private String updateOperatorId;

    /**
     * 更新人姓名
     */
    @Column(name = "update_operator_name")
    private String updateOperatorName;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Long updateTime;

    /**
     * 0-未删除,1-已删除
     */
    @Column(name = "is_delete")
    private String isDelete;

    /**
     * 备注
     */
    private String remark;

    /**
     * 权限ID
     */
    @Column(name = "permission_id")
    private String permissionId;

    /**
     * 权限名称
     */
    @Column(name = "permission_name")
    private String permissionName;

    /**
     * 资源类型，[menu|button]
     */
    @Column(name = "resource_type")
    private String resourceType;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
     */
    private String permission;

    /**
     * 父编号
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 父编号列表
     */
    @Column(name = "parent_ids")
    private String parentIds;

    /**
     * 0-未锁定,1-已锁定
     */
    private String state;

    /**
     * 获取id
     *
     * @return id - id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取创建人id
     *
     * @return create_operator_id - 创建人id
     */
    public String getCreateOperatorId() {
        return createOperatorId;
    }

    /**
     * 设置创建人id
     *
     * @param createOperatorId 创建人id
     */
    public void setCreateOperatorId(String createOperatorId) {
        this.createOperatorId = createOperatorId;
    }

    /**
     * 获取创建人姓名
     *
     * @return create_operator_name - 创建人姓名
     */
    public String getCreateOperatorName() {
        return createOperatorName;
    }

    /**
     * 设置创建人姓名
     *
     * @param createOperatorName 创建人姓名
     */
    public void setCreateOperatorName(String createOperatorName) {
        this.createOperatorName = createOperatorName;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新人id
     *
     * @return update_operator_id - 更新人id
     */
    public String getUpdateOperatorId() {
        return updateOperatorId;
    }

    /**
     * 设置更新人id
     *
     * @param updateOperatorId 更新人id
     */
    public void setUpdateOperatorId(String updateOperatorId) {
        this.updateOperatorId = updateOperatorId;
    }

    /**
     * 获取更新人姓名
     *
     * @return update_operator_name - 更新人姓名
     */
    public String getUpdateOperatorName() {
        return updateOperatorName;
    }

    /**
     * 设置更新人姓名
     *
     * @param updateOperatorName 更新人姓名
     */
    public void setUpdateOperatorName(String updateOperatorName) {
        this.updateOperatorName = updateOperatorName;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取0-未删除,1-已删除
     *
     * @return is_delete - 0-未删除,1-已删除
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置0-未删除,1-已删除
     *
     * @param isDelete 0-未删除,1-已删除
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取权限ID
     *
     * @return permission_id - 权限ID
     */
    public String getPermissionId() {
        return permissionId;
    }

    /**
     * 设置权限ID
     *
     * @param permissionId 权限ID
     */
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * 获取权限名称
     *
     * @return permission_name - 权限名称
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * 设置权限名称
     *
     * @param permissionName 权限名称
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    /**
     * 获取资源类型，[menu|button]
     *
     * @return resource_type - 资源类型，[menu|button]
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     * 设置资源类型，[menu|button]
     *
     * @param resourceType 资源类型，[menu|button]
     */
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    /**
     * 获取资源路径
     *
     * @return url - 资源路径
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置资源路径
     *
     * @param url 资源路径
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
     *
     * @return permission - 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 设置权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
     *
     * @param permission 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * 获取父编号
     *
     * @return parent_id - 父编号
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父编号
     *
     * @param parentId 父编号
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取父编号列表
     *
     * @return parent_ids - 父编号列表
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * 设置父编号列表
     *
     * @param parentIds 父编号列表
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    /**
     * 获取0-未锁定,1-已锁定
     *
     * @return state - 0-未锁定,1-已锁定
     */
    public String getState() {
        return state;
    }

    /**
     * 设置0-未锁定,1-已锁定
     *
     * @param state 0-未锁定,1-已锁定
     */
    public void setState(String state) {
        this.state = state;
    }
}