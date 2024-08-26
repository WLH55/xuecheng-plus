package com.xuecheng.content.service;

import com.xuecheng.content.model.dto.SaveTeachplanDto;
import com.xuecheng.content.model.dto.TeachplanDto;

import java.util.List;

/**
 * @Classname TeachplanService
 * @Description TODO
 * @Date 2024/8/26 22:56
 * @Created by cwl
 */
public interface TeachplanService {

    /**
     * @description 查询课程计划树型结构
     * @param courseId  课程id
     * @return List<TeachplanDto>
     * @author Mr.M
     * @date 2022/9/9 11:13
     */
     List<TeachplanDto> findTeachplanTree(long courseId);

    /**
     * @description 只在课程计划
     * @param teachplanDto  课程计划信息
     * @return void
     * @author Mr.M
     * @date 2022/9/9 13:39
     */
     void saveTeachplan(SaveTeachplanDto teachplanDto);

}