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
 * 订单支付表
 * </p>
 *
 * @author guozhiying
 * @since 2020-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OrderPayment对象", description="订单支付表")
public class OrderPayment implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "订单ID")
    private String orderId;

    @ApiModelProperty(value = "支付状态")
    private Integer status;

    @ApiModelProperty(value = "支付方式")
    private Integer type;

    @ApiModelProperty(value = "付款金额")
    private BigDecimal payment;

    @ApiModelProperty(value = "支付流水号")
    private String paymentId;

    @ApiModelProperty(value = "收款方")
    private String seller;

    @ApiModelProperty(value = "备注")
    private String remark;

    private Integer version;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;


}
