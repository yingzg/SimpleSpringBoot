package com.example.express.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 登录持久化表
 * </p>
 *
 * @author guozhiying
 * @since 2020-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="PersistentLogins对象", description="登录持久化表")
public class PersistentLogins implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String series;

    private String token;

    private LocalDateTime lastUsed;


}
