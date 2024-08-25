package com.xuecheng.content.service.impl;

import com.xuecheng.content.mapper.CourseCategoryMapper;
import com.xuecheng.content.model.dto.CourseCategoryTreeDto;
import com.xuecheng.content.service.CourseCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mr.M
 * @version 1.0
 * @description TODO
 * @date 2023/2/12 14:49
 */
@Slf4j
@Service
public class CourseCategoryServiceImpl implements CourseCategoryService {
    @Autowired
    private CourseCategoryMapper courseCategoryMapper;


    @Override
    public List<CourseCategoryTreeDto> queryTreeNodes(String treeId) {
        List<CourseCategoryTreeDto> queryTreeNodes = courseCategoryMapper.selectTreeNodes(treeId);
        //将list转为map，以备使用，排除根节点
        Map<String,CourseCategoryTreeDto> mapTemp = queryTreeNodes.stream().filter(item -> !treeId.equals(item.getId()))
                .collect(Collectors.toMap(key -> key.getId(),value -> value,(key1,key2)->key2));
        //最终返回的list
        List<CourseCategoryTreeDto> categoryTreeDtos = new ArrayList<>();
        //依次遍历每个元素，排除根节点
        queryTreeNodes.stream().filter(item -> !treeId.equals(item.getId())).forEach(item ->{
            if(item.getParentid().equals(treeId)){
                categoryTreeDtos.add(item);

            }
            //找到当前节点的父节点
            CourseCategoryTreeDto courseCategoryTreeDto = mapTemp.get(item.getParentid());
            if(courseCategoryTreeDto != null){
                if(courseCategoryTreeDto.getChildrenTreeNodes() == null){
                    courseCategoryTreeDto.setChildrenTreeNodes(new ArrayList<CourseCategoryTreeDto>());
                }
                //开始往把子节点放进子节点集合里面
                courseCategoryTreeDto.getChildrenTreeNodes().add(item);
            }

            });
        return categoryTreeDtos;

    }
}
