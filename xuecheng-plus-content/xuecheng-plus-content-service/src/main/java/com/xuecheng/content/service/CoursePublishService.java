package com.xuecheng.content.service;

import com.xuecheng.content.model.dto.CourseBaseInfoDto;
import com.xuecheng.content.model.dto.CoursePreviewDto;

/**
 * @Classname CoursePublishService
 * @Description TODO
 * @Date 2024/9/12 21:50
 * @Created by cwl
 */
public interface CoursePublishService {
    CoursePreviewDto getCoursePreview(Long courseId);
}
