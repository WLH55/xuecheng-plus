package com.xuecheng.content.service;

import com.xuecheng.content.model.dto.BindTeachplanMediaDto;
import com.xuecheng.content.model.dto.SaveTeachplanDto;
import com.xuecheng.content.model.dto.TeachplanDto;
import com.xuecheng.content.model.po.TeachplanMedia;

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

    /**
     *
     * 删除课程计划
     * @param teachplanId
     */

    void deleteTeachplan(Long teachplanId);

    /**
     * 排序课程计划
     * @param moveType
     * @param teachplanId
     */

    void orderByTeachplan(String moveType, Long teachplanId);

    /**
     * 课程计划绑定媒介信息
     * @param bindTeachplanMediaDto
     * @return
     */
    TeachplanMedia associationMedia(BindTeachplanMediaDto bindTeachplanMediaDto);

    /**
     * 解绑媒介和课程计划
     * @param teachplanId
     * @param mediaId
     */
    void unboundMedia(String teachplanId, String mediaId);
}