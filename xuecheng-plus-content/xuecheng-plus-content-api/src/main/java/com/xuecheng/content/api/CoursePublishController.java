package com.xuecheng.content.api;

import com.xuecheng.content.model.dto.CourseBaseInfoDto;
import com.xuecheng.content.model.dto.CoursePreviewDto;
import com.xuecheng.content.service.CoursePublishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Classname CoursePublishController
 * @Description 课程发布，预览
 * @Date 2024/9/12 21:24
 * @Created by cwl
 */
@Api(value = "课程预览发布接口",tags = "课程预览发布接口")
@RestController
public class CoursePublishController {
    @Autowired
    private CoursePublishService coursePublishService;


    @GetMapping("/coursepreview/{courseId}")
    public ModelAndView preview(@PathVariable("courseId") Long courseId){
        ModelAndView modelAndView = new ModelAndView();
        CoursePreviewDto coursePreviewDto = coursePublishService.getCoursePreview(courseId);
        modelAndView.addObject("model",coursePreviewDto);
        modelAndView.setViewName("course_template");
        return modelAndView;

    }

    @PostMapping("/courseaudit/commit/{courseId}")
    public void commitAudit(@PathVariable("courseId") Long courseId){
        Long companyId = 1232141425L;
        coursePublishService.commitAudit(companyId,courseId);

    }

    @ApiOperation("课程发布")
    @PostMapping("/coursepublish/{courseId}")
    public void coursePublish(@PathVariable("courseId") Long courseId){

    }


}
