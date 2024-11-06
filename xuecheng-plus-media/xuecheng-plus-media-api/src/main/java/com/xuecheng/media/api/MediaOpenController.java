package com.xuecheng.media.api;

import com.xuecheng.base.exception.XueChengPlusException;
import com.xuecheng.base.model.RestResponse;
import com.xuecheng.media.model.po.MediaFiles;
import com.xuecheng.media.service.MediaFileService;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.Path;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname MediaOpenController
 * @Description TODO
 * @Date 2024/9/13 15:38
 * @Created by cwl
 */
@RestController
@Api(value = "媒资文件管理接口",tags = "媒资文件管理接口")
@RequestMapping("open")
public class MediaOpenController {

    @Resource
    private MediaFileService mediaFileService;

    @GetMapping("/preview/{mediaId}")
    public RestResponse<String> getPlayUrlByMediaId(@PathVariable String mediaId){
        MediaFiles mediaFiles = mediaFileService.getFileById(mediaId);
        if(mediaFiles == null || StringUtils.isEmpty(mediaFiles.getUrl())){
            XueChengPlusException.cast("该视频还没有转码处理");
        }
        return RestResponse.success(mediaFiles.getUrl());

    }

}
