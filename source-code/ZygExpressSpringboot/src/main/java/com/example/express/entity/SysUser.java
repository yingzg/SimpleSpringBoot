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
 * 用户表
 * </p>
 *
 * @author guozhiying
 * @since 2020-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysUser对象", description="用户表")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.UUID)
    private String id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "角色ID")
    private Integer roleId;

    @ApiModelProperty(value = "人脸唯一标识")
    private String faceToken;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @ApiModelProperty(value = "身份证号")
    private String idCard;

    @ApiModelProperty(value = "学生证号")
    private String studentIdCard;

    @ApiModelProperty(value = "手机号")
    private String tel;

    @ApiModelProperty(value = "所属学校")
    private String schoolId;

    @ApiModelProperty(value = "三方登陆类型（0：未绑定三方登陆）")
    private Integer thirdLoginType;

    @ApiModelProperty(value = "三方登陆ID")
    private String thirdLoginId;

    @ApiModelProperty(value = "是否启用（0：禁用；1：启用）")
    private Integer hasEnable;

    private Integer version;

    @ApiModelProperty(value = "解冻时间")
    private LocalDateTime lockDate;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;


}
