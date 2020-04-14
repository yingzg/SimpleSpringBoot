package com.example.express.entity;

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
 * 订单信息表
 * </p>
 *
 * @author guozhiying
 * @since 2020-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OrderInfo对象", description="订单信息表")
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "快递单号")
    private String odd;

    @ApiModelProperty(value = "快递公司")
    private Integer company;

    @ApiModelProperty(value = "收件人")
    private String recName;

    @ApiModelProperty(value = "收件短信")
    private String recTel;

    @ApiModelProperty(value = "收货地址")
    private String recAddress;

    @ApiModelProperty(value = "快递寄达地址")
    private String address;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "配送员ID")
    private String courierId;

    @ApiModelProperty(value = "订单状态")
    private Integer status;

    @ApiModelProperty(value = "配送员备注")
    private String courierRemark;

    private Integer hasDelete;

    @ApiModelProperty(value = "删除原因")
    private Integer deleteType;

    private Integer version;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;


}
