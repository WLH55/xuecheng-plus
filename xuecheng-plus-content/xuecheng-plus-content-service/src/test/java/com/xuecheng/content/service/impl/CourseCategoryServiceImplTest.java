package com.xuecheng.content.service.impl;

import com.xuecheng.content.model.dto.CourseCategoryTreeDto;
import com.xuecheng.content.service.CourseCategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Classname CourseCategoryServiceImplTest
 * @Description TODO
 * @Date 2024/8/23 17:38
 * @Created by cwl
 */
@SpringBootTest
class CourseCategoryServiceImplTest {
    @Autowired
    CourseCategoryService courseCategoryService;

    @Test
    void queryTreeNodes() {
        List<CourseCategoryTreeDto> categoryTreeDtos = courseCategoryService.queryTreeNodes("1");
        System.out.println(categoryTreeDtos);

    }
}