package com.kamingpan.infrastructure.demo.entity.model.entity;

import com.kamingpan.infrastructure.core.base.model.entity.BaseEntity;

/**
 * 示例
 *
 * @author kamingpan
 * @since 2019-04-09
 */
public class Demo extends BaseEntity<Demo> {

    /**
     * 名称
     */
    private String name;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 图片
     */
    private String picture;

    /**
     * 爱好
     */
    private String hobby;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 附件
     */
    private String attachment;

    /**
     * 介绍
     */
    private String introduction;

    /**
     * 备注
     */
    private String remark;

    public Demo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Demo {" +
        "name=" + name +
        ", phone=" + phone +
        ", picture=" + picture +
        ", hobby=" + hobby +
        ", email=" + email +
        ", status=" + status +
        ", attachment=" + attachment +
        ", introduction=" + introduction +
        ", remark=" + remark +
        "}";
    }

}
