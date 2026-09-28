package com.irv.media.api;

import com.irv.base.exception.IRVException;
import com.irv.base.model.RestResponse;
import com.irv.media.mapper.MediaFilesMapper;
import com.irv.media.model.po.MediaFiles;
import com.irv.media.service.MediaFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "媒资文件管理接口",tags = "媒资文件管理接口")
 @RestController
 //@RequestMapping("/open")
public class MediaOpenController {

  @Autowired
  MediaFileService mediaFileService;

    @ApiOperation("预览文件")
    @GetMapping("/preview/{mediaId}")
    public RestResponse<String> getPlayUrlByMediaId(@PathVariable String mediaId){

        MediaFiles mediaFiles = mediaFileService.getFileById(mediaId);
        if(mediaFiles == null || StringUtils.isEmpty(mediaFiles.getUrl())){
            IRVException.cast("视频还没有转码处理");
        }
        return RestResponse.success(mediaFiles.getUrl());

    }

    @Autowired
    MediaFilesMapper mediaFilesMapper;

    @ApiOperation("删除文件")
    @DeleteMapping ("/{mediaId}")
    public RestResponse<String> DeleteByMediaId(@PathVariable String mediaId){
        mediaFilesMapper.deleteById(mediaId);
        return RestResponse.success("要删除的文件:" + mediaId + "已被删除");

    }


}
