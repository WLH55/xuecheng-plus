package com.xuecheng.content.service;

import com.xuecheng.content.model.dto.CourseCategoryTreeDto;

import java.util.List;

/**
 * @author Mr.M
 * @version 1.0
 * @description TODO
 * @date 2023/2/12 14:49
 */
public interface CourseCategoryService {
    List<CourseCategoryTreeDto> queryTreeNodes(String treeId);

}
