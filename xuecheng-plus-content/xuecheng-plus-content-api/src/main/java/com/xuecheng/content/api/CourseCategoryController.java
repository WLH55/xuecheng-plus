package com.xuecheng.content.api;

import com.xuecheng.content.model.dto.CourseCategoryTreeDto;
import com.xuecheng.content.service.CourseCategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname CourseCategoryController
 * @Description TODO
 * @Date 2024/8/23 15:33
 * @Created by cwl
 */
@Slf4j
@RestController
public class CourseCategoryController {
    @Autowired
    private CourseCategoryService courseCategoryService;


    @GetMapping("/course-category/tree-nodes")
    @ApiOperation(value = "查询课程分类")
    public List<CourseCategoryTreeDto> queryTreeNodes(){
        List<CourseCategoryTreeDto> courseCategoryTreeDtos = courseCategoryService.queryTreeNodes("1");
        return courseCategoryTreeDtos;
    }


}
