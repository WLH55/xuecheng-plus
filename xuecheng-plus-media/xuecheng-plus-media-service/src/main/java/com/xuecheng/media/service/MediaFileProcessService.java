package com.xuecheng.media.service;

import com.xuecheng.media.model.po.MediaProcess;

import java.util.List;

/**
 * @Classname MediaFileProcessService
 * @Description TODO
 * @Date 2024/9/8 16:44
 * @Created by cwl
 */
public interface MediaFileProcessService {

    List<MediaProcess> getMediaProcessList(int shardIndex,int shardTotal,int count);

    boolean startTask(long id);

    void saveProcessFinishStatus(Long taskId,String status,String fileId,String url,String errorMsg);
}
