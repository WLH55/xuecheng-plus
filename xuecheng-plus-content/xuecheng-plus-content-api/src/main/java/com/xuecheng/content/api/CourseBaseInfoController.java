package com.xuecheng.content.api;

import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.model.dto.AddCourseDto;
import com.xuecheng.content.model.dto.CourseBaseInfoDto;
import com.xuecheng.content.model.dto.QueryCourseParamsDto;
import com.xuecheng.content.model.po.CourseBase;
import com.xuecheng.content.service.CourseBaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname CourseBaseInfoController
 * @Description 课程信息编辑接口
 * @Date 2024/8/20 22:25
 * @Created by cwl
 */
@Api(tags = "内容管理模块")
@RestController
public class CourseBaseInfoController {
    @Resource
    private CourseBaseInfoService courseBaseInfoService;

    @PostMapping("/course/list")
    @ApiOperation(value = "查询课程列表")
    public PageResult<CourseBase> list(PageParams pageParams, @RequestBody QueryCourseParamsDto queryCourseParams){
        PageResult<CourseBase> pageResult = courseBaseInfoService.queryCourseBaseList(pageParams,queryCourseParams);
        return pageResult;

    }

    @ApiOperation("新增课程基础信息")
    @PostMapping("/course")
    public CourseBaseInfoDto createCourseBase(@RequestBody AddCourseDto addCourseDto){
        //机构id，由于认证系统没有上线暂时硬编码
        Long companyId = 1232141425L;
        CourseBaseInfoDto courseBaseInfoDto =  courseBaseInfoService.createCourseBase(companyId,addCourseDto);
        return courseBaseInfoDto;
    }

}