package com.cola.mapper;

import com.cola.base.BaseMapper;
import com.cola.model.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecordMapper extends BaseMapper<Record> {

    // 批量插入多条抽奖记录
    int batchInsert(@Param("awardId") String awardId, @Param("memberIds") List<Integer> memberIds);

    // 删除当前奖项某个获奖人员
    int deleteByMemberId(Integer memberId);

    // 删除当前奖项所有已获奖人员
    int deleteByAwardId(Integer awardId);

    // 清空抽奖页面: 根据 userId 清空该设置页面所有奖项纪录
    int deleteByUserId(Integer userId);
}