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
 * 快递公司数据表
 * </p>
 *
 * @author guozhiying
 * @since 2020-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DataCompany对象", description="快递公司数据表")
public class DataCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;

    @ApiModelProperty(value = "快递公司名")
    private String name;

    @ApiModelProperty(value = "快递公司代号")
    private String code;


}
