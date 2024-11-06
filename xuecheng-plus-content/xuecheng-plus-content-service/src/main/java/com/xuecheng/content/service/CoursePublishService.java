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
    /**
     * 获取课程预览信息
     * @param courseId
     * @return
     */
    CoursePreviewDto getCoursePreview(Long courseId);

    /**
     *
     * 提交审核
     * @param commpanyId
     * @param courseId
     */

    void commitAudit(Long commpanyId,Long courseId);

    /**
     * 课程发布
     * @param commpanyId
     * @param courseId
     */

    void publishCourse(Long commpanyId,Long courseId);
}
