package com.xuecheng.media.service;

import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.base.model.RestResponse;
import com.xuecheng.media.model.dto.QueryMediaParamsDto;
import com.xuecheng.media.model.dto.UploadFileParamsDto;
import com.xuecheng.media.model.dto.UploadFileResultDto;
import com.xuecheng.media.model.po.MediaFiles;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.File;
import java.util.List;

/**
 * @description 媒资文件管理业务类
 * @author Mr.M
 * @date 2022/9/10 8:55
 * @version 1.0
 */
public interface MediaFileService {

 /**
  * @description 媒资文件查询方法
  * @param pageParams 分页参数
  * @param queryMediaParamsDto 查询条件
  * @return com.xuecheng.base.model.PageResult<com.xuecheng.media.model.po.MediaFiles>
  * @author Mr.M
  * @date 2022/9/10 8:57
 */
  PageResult<MediaFiles> queryMediaFiels(Long companyId,PageParams pageParams, QueryMediaParamsDto queryMediaParamsDto);

 /**
  * 上传文件
  * @param companyId 机构id
  * @param uploadFileParamsDto 上传文件信息
  * @param localFilePath 文件磁盘路径
  * @return 文件信息
  */
  UploadFileResultDto uploadFile(Long companyId, UploadFileParamsDto uploadFileParamsDto, String localFilePath);



  MediaFiles addMediaFilesToDb(Long companyId,String fileMd5,UploadFileParamsDto uploadFileParamsDto,String bucket,String objectName);

 /**
  * 检查文件是否存在
  * @param fileMd5
  * @return
  */
 RestResponse<Boolean> checkFile(String fileMd5);

 /**
  * 检测分块是否存在
  * @param fileMd5
  * @param chunkIndex
  * @return
  */
  RestResponse<Boolean> checkChunk(String fileMd5, int chunkIndex);

 /**
  * 上传文件接口
  * @param fileMd5
  * @param chunk
  * @param
  * @return
  */

  RestResponse uploadChunk(String fileMd5,int chunk,String localPath);

  File downloadFileFromMinIO(String bucket, String objectName);
 boolean addMediaFilesToMinIO(String localFilePath, String mimeType, String bucket, String objectName);

 void addWaitingTask(MediaFiles mediaFiles);
 /**
  * 合并文件
  * @param companyId
  * @param fileMd5
  * @param chunkTotal
  * @param uploadFileParamsDto
  * @return
  */
  RestResponse mergechunks(Long companyId,String fileMd5,int chunkTotal,UploadFileParamsDto uploadFileParamsDto);
}
