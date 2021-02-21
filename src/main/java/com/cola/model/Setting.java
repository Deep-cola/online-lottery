package com.cola.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * 抽奖设置
 */
@Getter
@Setter
@ToString
public class Setting {
    
    private Integer id;

    /**
     * 用户 id
     */
    private Integer userId;

    /**
     * 每次抽奖人数
     */
    private Integer batchNumber;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 新增属性 user
     */
    private User user;

    /**
     * 新增属性 awards 列表
     */
    private List<Award> awards;

    /**
     * 新增属性 member 列表
     */
    private List<Member> members;
}