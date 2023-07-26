package com.gsl.video.core.video.dto;

import com.gsl.video.core.videoUrl.dto.VideoUrlAddDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Video AddDTO类
 *
 * @author system
 * @date 2023-05-07 19:59:19
 */
@Data
@ApiModel(value = "Video AddDTO类")
public class VideoAddDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "busiType", value = "业务类型")
    private String busiType;

    @ApiModelProperty(name = "careerLine", value = "事业线key值")
    private String careerLine;

    @ApiModelProperty(name = "title", value = "视频主题")
    private String title;

    @ApiModelProperty(name = "videoDesc", value = "视频描述")
    private String videoDesc;

    @ApiModelProperty(name = "coverUrl", value = "封面图片地址")
    private String coverUrl;

    @ApiModelProperty(name = "urlList",value = "视频播放地址")
    private List<VideoUrlAddDTO> urlList;

    @ApiModelProperty(name = "labelList",value = "标签")
    private List<String> labelList;

}
