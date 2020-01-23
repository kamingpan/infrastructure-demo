package com.kamingpan.infrastructure.demo.entity.model.dto;

import com.kamingpan.infrastructure.core.base.constant.FinalConstant;
import com.kamingpan.infrastructure.demo.entity.group.DemoGroup;
import com.kamingpan.infrastructure.demo.entity.model.entity.Demo;
import com.kamingpan.infrastructure.util.conversion.JsonConversion;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 示例 dto
 *
 * @author kamingpan
 * @since 2019-04-09
 */
@Data
public class DemoDTO {

    /**
     * 主键
     */
    private String id;

    /**
     * 名称
     */
    @NotEmpty(message = "名称不能为空", groups = {DemoGroup.Insert.class, DemoGroup.Update.class})
    private String name;

    /**
     * 手机号码
     */
    @NotEmpty(message = "手机号码不能为空", groups = {DemoGroup.Insert.class, DemoGroup.Update.class})
    private String phone;

    /**
     * 图片
     */
    private String picture;

    /**
     * 爱好
     */
    @NotEmpty(message = "爱好不能为空", groups = {DemoGroup.Insert.class, DemoGroup.Update.class})
    private List<String> hobbies;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 状态
     */
    @NotNull(message = "状态不能为空", groups = {DemoGroup.Insert.class, DemoGroup.Update.class})
    private Integer status;

    /**
     * 附件
     */
    private List<String> attachment;

    /**
     * 介绍
     */
    private String introduction;

    /**
     * 备注
     */
    private String remark;

    public Demo toDemo() {
        Demo demo = new Demo();

        // 赋值
        demo.setId(this.getId());
        demo.setName(this.getName());
        demo.setPhone(this.getPhone());
        demo.setPicture(this.getPicture());
        demo.setHobby((null == this.getHobbies() || this.getHobbies().isEmpty()) ?
                FinalConstant.Strings.EMPTY_ARRAY : JsonConversion.convertToJsonWithoutException(this.getHobbies()));
        demo.setEmail(this.getEmail());
        demo.setStatus(this.getStatus());
        demo.setAttachment((null == this.getAttachment() || this.getAttachment().isEmpty()) ?
                FinalConstant.Strings.EMPTY_ARRAY : JsonConversion.convertToJsonWithoutException(this.getAttachment()));
        demo.setIntroduction(this.getIntroduction());
        demo.setRemark(this.getRemark());

        return demo;
    }

}
