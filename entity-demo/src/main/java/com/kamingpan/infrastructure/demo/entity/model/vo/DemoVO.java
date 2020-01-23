package com.kamingpan.infrastructure.demo.entity.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.kamingpan.infrastructure.entity.model.vo.UploadFileVO;

import java.util.Date;
import java.util.List;

/**
 * 示例 vo
 *
 * @author kamingpan
 * @since 2019-04-09
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemoVO {

    /**
     * 主键
     */
    private String id;

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
     * 图片链接
     */
    private String pictureUrl;

    /**
     * 爱好
     */
    private String hobby;

    /**
     * 爱好列表
     */
    private List<String> hobbies;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 状态标签
     */
    private String statusLabel;

    /**
     * 附件
     */
    private String attachment;

    /**
     * 附件列表
     */
    private List<UploadFileVO> attachments;

    /**
     * 介绍
     */
    private String introduction;

    /**
     * 备注
     */
    private String remark;

    /**
     * 最后修改人
     */
    private String updater;

    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    public DemoVO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
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

    public String getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(String statusLabel) {
        this.statusLabel = statusLabel;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public List<UploadFileVO> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<UploadFileVO> attachments) {
        this.attachments = attachments;
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

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
