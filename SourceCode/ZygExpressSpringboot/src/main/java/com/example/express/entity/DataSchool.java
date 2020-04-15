package com.example.express.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 高校数据表
 * </p>
 *
 * @author guozhiying
 * @since 2020-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DataSchool对象", description="高校数据表")
public class DataSchool implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;

    @ApiModelProperty(value = "学校名称")
    private String name;

    @ApiModelProperty(value = "省份ID")
    private Integer provinceId;

    @ApiModelProperty(value = "学校级别")
    private String level;

    @ApiModelProperty(value = "学校网址")
    private String website;

    @ApiModelProperty(value = "学校简称")
    private String abbreviation;


}
