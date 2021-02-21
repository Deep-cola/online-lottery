package com.cola.service;

import com.cola.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Deepcola
 * @time: 2021/2/21 16:37
 */
@Service
public class RecordService {

    @Autowired
    private RecordMapper recordMapper;

    /**
     * 批量插入多条抽奖记录
     */
    public int add(String awardId, List<Integer> memberIds) {
        return recordMapper.batchInsert(awardId, memberIds);
    }

    /**
     * 删除当前奖项某个获奖人员
     */
    public int deleteByMemberId(Integer memberId) {
        return recordMapper.deleteByMemberId(memberId);
    }

    /**
     * 删除当前奖项所有已获奖人员
     */
    public int deleteByAwardId(Integer awardId) {
        return recordMapper.deleteByAwardId(awardId);
    }

    /**
     * 重置抽奖页面: 清空该设置页面所有奖项纪录
     */
    public int deleteByUserId(Integer userId) {
        return recordMapper.deleteByUserId(userId);
    }
}
