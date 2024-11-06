package com.xuecheng.content.api;

/**
 * @Classname CourseOpenController
 * @Description TODO
 * @Date 2024/9/13 15:30
 * @Created by cwl
 */

import com.xuecheng.content.model.dto.CourseBaseInfoDto;
import com.xuecheng.content.model.dto.CoursePreviewDto;
import com.xuecheng.content.service.CoursePublishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "课程公开查询接口",tags = "课程公开查询接口")
@RestController
@RequestMapping("/open")
public class CourseOpenController {
    @Resource
    private CoursePublishService coursePublishService;



    @ApiOperation("获取课程信息接口")
    @GetMapping("course/whole/{courseId}")
    public CoursePreviewDto getPreviewInfo(@PathVariable("courseId") Long courseId){
        //获取课程预览消息
        CoursePreviewDto coursePreviewDto = coursePublishService.getCoursePreview(courseId);
        return coursePreviewDto;

    }


}
