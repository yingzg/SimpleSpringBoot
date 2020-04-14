package com.example.express.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单评价表
 * </p>
 *
 * @author guozhiying
 * @since 2020-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OrderEvaluate对象", description="订单评价表")
public class OrderEvaluate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    @TableId(type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "评论是否开启（1：开启；0：关闭）")
    private Boolean hasOpen;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "用户评分")
    private BigDecimal userScore;

    @ApiModelProperty(value = "用户评价")
    private String userEvaluate;

    @ApiModelProperty(value = "用户评价时间")
    private LocalDateTime userDate;

    @ApiModelProperty(value = "配送员ID")
    private String courierId;

    @ApiModelProperty(value = "配送员评分")
    private BigDecimal courierScore;

    @ApiModelProperty(value = "配送员评价")
    private String courierEvaluate;

    private Integer version;

    @ApiModelProperty(value = "配送员评价时间")
    private LocalDateTime courierDate;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateDate;


}
