package com.cola.service;

import com.cola.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Deepcola
 * @time: 2021/2/2 12:09
 */
@Service
public class RecordService {

    @Autowired
    private RecordMapper recordMapper;

    /**
     * 批量插入多条抽奖记录
     */
    public int add(List<Integer> memberIds, Integer awardId) {
        return recordMapper.batchInsert(memberIds, awardId);
    }

    /**
     * 删除某人的该条抽奖记录
     */
    public int deleteByMemberId(Integer memberId) {
        return recordMapper.deleteByMemberId(memberId);
    }

    /**
     * 删除某个奖项的所有抽奖记录
     */
    public int deleteByAwardId(Integer awardId) {
        return recordMapper.deleteByAwardId(awardId);
    }

    /**
     * 清空该设置页面所有奖项纪录
     */
    public int deleteByUserId(Integer userId) {
        return recordMapper.deleteByUserId(userId);
    }
}
