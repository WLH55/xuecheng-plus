package com.xuecheng.content.service.impl;

import com.alibaba.fastjson.JSON;
import com.xuecheng.base.constant.AuditStatus;
import com.xuecheng.base.constant.CourseAuditStatus;
import com.xuecheng.base.exception.XueChengPlusException;
import com.xuecheng.content.mapper.CourseBaseMapper;
import com.xuecheng.content.mapper.CourseMarketMapper;
import com.xuecheng.content.mapper.CoursePublishPreMapper;
import com.xuecheng.content.model.dto.CourseBaseInfoDto;
import com.xuecheng.content.model.dto.CoursePreviewDto;
import com.xuecheng.content.model.dto.TeachplanDto;
import com.xuecheng.content.model.po.CourseBase;
import com.xuecheng.content.model.po.CourseMarket;
import com.xuecheng.content.model.po.CoursePublishPre;
import com.xuecheng.content.model.po.Teachplan;
import com.xuecheng.content.service.CourseBaseInfoService;
import com.xuecheng.content.service.CoursePublishService;
import com.xuecheng.content.service.TeachplanService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Classname CoursePublishServiceImpl
 * @Description TODO
 * @Date 2024/9/12 21:52
 * @Created by cwl
 */
@Service
@Slf4j
public class CoursePublishServiceImpl implements CoursePublishService {
    @Autowired
    private CourseBaseInfoService courseBaseInfoService;

    @Autowired
    private TeachplanService teachplanService;

    @Autowired
    private CourseBaseMapper courseBaseMapper;

    @Autowired
    private CourseMarketMapper courseMarketMapper;

    @Autowired
    private CoursePublishPreMapper coursePublishPreMapper;

    @Override
    public CoursePreviewDto getCoursePreview(Long courseId) {
        //课程基本信息、营销信息
        CourseBaseInfoDto courseBaseInfo = courseBaseInfoService.getCourseBaseInfo(courseId);

        //课程计划信息
        List<TeachplanDto> teachplanTree= teachplanService.findTeachplanTree(courseId);

        CoursePreviewDto coursePreviewDto = new CoursePreviewDto();
        coursePreviewDto.setCourseBase(courseBaseInfo);
        coursePreviewDto.setTeachplans(teachplanTree);
        return coursePreviewDto;
    }

    /**
     * 提交审核
     * @param commpanyId
     * @param courseId
     */
    @Override
    public void commitAudit(Long commpanyId, Long courseId) {
        //约束效验
        CourseBase courseBase = courseBaseMapper.selectById(courseId);
        //课程审核状态，已提交状态不可以提交审核
        String auditStatus = courseBase.getAuditStatus();
        if(CourseAuditStatus.SUBMITTED.getCode().equals(auditStatus)){
            XueChengPlusException.cast("课程当前为待审核状态，请等待审核完成再提交！");
        }
        //本机构只允许提交本机构的课程
        if(!courseBase.getCompanyId().equals(commpanyId)){
            XueChengPlusException.cast("不允许提交其他机构的课程");
        }
        //效验课程图片是否填写
        if(StringUtils.isEmpty(courseBase.getPic())){
            XueChengPlusException.cast("请上传课程图片");
        }
        //添加到预发布记录
        CoursePublishPre coursePublishPre = new CoursePublishPre();
        //课程信息加部分营销信息
        CourseBaseInfoDto courseBaseInfoDto = courseBaseInfoService.getCourseBaseInfo(courseId);
        BeanUtils.copyProperties(courseBaseInfoDto,coursePublishPre);
        //课程营销信息
        CourseMarket courseMarket = courseMarketMapper.selectById(courseId);
        //转为JSON
        String courseMarketJson = JSON.toJSONString(courseMarket);
        //将课程营销信息json数据放入课程预发布表
        coursePublishPre.setMarket(courseMarketJson);

        //查询课程计划信息
        List<TeachplanDto> teachplanDtos = teachplanService.findTeachplanTree(courseId);
        if(teachplanDtos.size() <= 0){
            XueChengPlusException.cast("提交失败，还没有添加课程计划");
        }
        //转json
        String teachplanTreeJson = JSON.toJSONString(teachplanDtos);

        coursePublishPre.setTeachplan(teachplanTreeJson);
        //设置预发布记录状态，已提交
        coursePublishPre.setStatus(CourseAuditStatus.SUBMITTED.getCode());

        //教学机构id
        coursePublishPre.setCompanyId(commpanyId);
        //提交时间
        coursePublishPre.setCreateDate(LocalDateTime.now());
        //插入预发布表
        CoursePublishPre coursePublishPreUpdate = coursePublishPreMapper.selectById(courseId);
        if(coursePublishPreUpdate == null){
            //插入
            coursePublishPreMapper.insert(coursePublishPre);

        }else{
            coursePublishPreMapper.updateById(coursePublishPre);
        }
        //更新课程基本表的审核状态
        courseBase.setStatus(CourseAuditStatus.SUBMITTED.getCode());
        courseBaseMapper.updateById(courseBase);
    }
}
