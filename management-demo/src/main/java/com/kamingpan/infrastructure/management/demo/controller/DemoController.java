package com.kamingpan.infrastructure.management.demo.controller;

import com.kamingpan.infrastructure.core.base.controller.BaseController;
import com.kamingpan.infrastructure.core.exception.ValidateException;
import com.kamingpan.infrastructure.core.response.Pager;
import com.kamingpan.infrastructure.core.response.ResponseData;
import com.kamingpan.infrastructure.core.response.ResponseStatus;
import com.kamingpan.infrastructure.demo.entity.constant.DemoConstant;
import com.kamingpan.infrastructure.demo.entity.group.DemoGroup;
import com.kamingpan.infrastructure.demo.entity.model.dto.DemoDTO;
import com.kamingpan.infrastructure.demo.entity.model.entity.Demo;
import com.kamingpan.infrastructure.demo.entity.model.vo.DemoVO;
import com.kamingpan.infrastructure.demo.entity.service.DemoService;
import com.kamingpan.infrastructure.entity.constant.AdminConstant;
import com.kamingpan.infrastructure.entity.model.entity.AdminOperateLog;
import com.kamingpan.infrastructure.entity.service.DataDictionaryService;
import com.kamingpan.infrastructure.entity.service.UploadFileService;
import com.kamingpan.infrastructure.util.conversion.JsonConversion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 示例 controller
 *
 * @author kamingpan
 * @since 2019-04-09
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController extends BaseController {

    @Autowired
    private DemoService demoService;

    @Autowired
    private UploadFileService uploadFileService;

    @Autowired
    private DataDictionaryService dataDictionaryService;

    /**
     * 示例查询
     *
     * @param demo  示例dto
     * @param pager 分页
     * @return 响应数据
     */
    @GetMapping("")
    @PreAuthorize(DemoConstant.Authentication.LIST)
    public ResponseData list(@ModelAttribute DemoDTO demo, @ModelAttribute Pager pager) {
        log.debug("查询示例列表...");

        List<DemoVO> demos = this.demoService.listByDemo(demo, pager);
        return ResponseData.buildPagination(demos, pager);
    }

    /**
     * 示例详情
     *
     * @param id 示例主键
     * @return 响应数据
     */
    @GetMapping("/{id}")
    @SuppressWarnings("unchecked")
    @PreAuthorize(DemoConstant.Authentication.INFO)
    public ResponseData info(@PathVariable("id") final String id) {
        log.debug("查询示例“{}”详情...", id);

        DemoVO demo = this.demoService.getDemoById(id);
        if (null == demo) {
            return ResponseData.build(ResponseStatus.DATA_IS_NOT_EXIST);
        }

        // 查询爱好列表
        demo.setHobbies(this.dataDictionaryService.listLabelByClazzAndVariable(
                JsonConversion.convertToObjectWithoutException(demo.getHobby(), List.class),
                "Demo", "hobby"));

        // 查询附件列表
        demo.setAttachments(this.uploadFileService.listUploadFileVOByIds(
                JsonConversion.convertToObjectWithoutException(demo.getAttachment(), List.class)));
        return ResponseData.build(demo);
    }

    /**
     * 示例新增
     *
     * @param demo 示例
     * @return 响应数据
     */
    @PostMapping("")
    @PreAuthorize(DemoConstant.Authentication.INSERT)
    public ResponseData insert(@ModelAttribute @Validated(DemoGroup.Insert.class) DemoDTO demo) {
        log.debug("新增示例“{}”...", demo.getName());

        this.demoService.insert(demo.toDemo(), new AdminOperateLog());
        return ResponseData.success();
    }

    /**
     * 示例修改
     *
     * @param id      示例主键
     * @param demoDTO 示例
     * @return 响应数据
     */
    @PutMapping("/{id}")
    @PreAuthorize(DemoConstant.Authentication.UPDATE)
    public ResponseData update(@PathVariable("id") String id,
                               @ModelAttribute @Validated(DemoGroup.Update.class) DemoDTO demoDTO) {
        log.debug("更新示例“{}”...", demoDTO.getName());

        Demo demo = demoDTO.toDemo();
        demo.setId(id);
        this.demoService.update(demo, new AdminOperateLog());
        return ResponseData.success();
    }

    /**
     * 示例删除
     *
     * @param id 示例主键
     * @return 响应数据
     */
    @DeleteMapping("/{id}")
    @PreAuthorize(DemoConstant.Authentication.DELETE)
    public ResponseData delete(@PathVariable("id") String id) {
        log.debug("删除示例“{}”...", id);

        this.demoService.delete(id, new AdminOperateLog());
        return ResponseData.success();
    }

    /**
     * 示例批量删除
     *
     * @param ids 示例主键列表
     * @return 响应数据
     */
    @DeleteMapping("")
    @PreAuthorize(AdminConstant.Authentication.DELETE)
    public ResponseData deleteByIds(@RequestParam("ids") List<String> ids) {
        log.debug("删除示例“{}”...", ids);
        if (null == ids || ids.isEmpty()) {
            throw new ValidateException();
        }

        this.demoService.deleteByIds(ids);
        return ResponseData.success();
    }

    /**
     * 启用示例
     *
     * @param id 主键
     * @return 响应数据
     */
    @PatchMapping("/{id}/enable")
    @PreAuthorize(AdminConstant.Authentication.ENABLE)
    public ResponseData enable(@PathVariable("id") String id) {
        log.debug("启用示例“{}”...", id);

        this.demoService.updateStatusToEnableById(id, new AdminOperateLog());
        return ResponseData.success();
    }

    /**
     * 禁用示例
     *
     * @param id 主键
     * @return 响应数据
     */
    @PatchMapping("/{id}/disable")
    @PreAuthorize(AdminConstant.Authentication.DISABLE)
    public ResponseData disable(@PathVariable("id") String id) {
        log.debug("禁用示例“{}”...", id);

        this.demoService.updateStatusToDisableById(id, new AdminOperateLog());
        return ResponseData.success();
    }

    /**
     * 判断名称是否存在
     *
     * @param name 名称
     * @return 响应数据
     */
    @GetMapping("/name-exist")
    public ResponseData nameExist(@RequestParam(value = "id", required = false) final String id,
                                  @RequestParam("name") final String name) {
        log.debug("查询示例“{}”是否存在...", name);

        int count = this.demoService.countByName(id, name);
        Map<String, Boolean> result = new HashMap<String, Boolean>();
        result.put("result", count > 0);
        return ResponseData.build(result);
    }

}
