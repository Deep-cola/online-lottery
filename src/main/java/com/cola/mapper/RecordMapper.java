package com.cola.mapper;

import com.cola.base.BaseMapper;
import com.cola.model.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecordMapper extends BaseMapper<Record> {

    // 批量插入抽奖记录
    int batchInsert(@Param("memberIds") List<Integer> memberIds, @Param("awardId") Integer awardId);

    // 根据人员 id 删除某个人抽奖记录
    int deleteByMemberId(Integer memberId);

    // 根据奖项 id 删除某个奖项抽奖记录
    int deleteByAwardId(Integer awardId);

    // 根据 userId 删除所有奖项抽奖记录
    int deleteByUserId(Integer userId);
}