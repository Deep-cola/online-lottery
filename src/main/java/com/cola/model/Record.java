package com.cola.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 中奖记录表
 */
@Getter
@Setter
@ToString
public class Record {
    
    private Integer id;

    /**
     * 中奖人员 id
     */
    private Integer memberId;

    /**
     * 中奖奖项 id
     */
    private Integer awardId;

    /**
     * 创建时间
     */
    private Date createTime;
}