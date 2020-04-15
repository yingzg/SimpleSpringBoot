package com.example.express.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class UserEvaluate {

    @TableId(type = IdType.INPUT)
    private String userId;
    /**
     * 用户评分
     */
    private BigDecimal score;
    /**
     * 评分基数
     */
    private Integer count;

    @Version
    private Integer version;

    @TableField(fill = FieldFill.UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateDate;
}
