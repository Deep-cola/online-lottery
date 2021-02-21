package com.cola.mapper;

import com.cola.base.BaseMapper;
import com.cola.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper extends BaseMapper<Member> {

    // 根据 settingId 查询 member 列表
    List<Member> selectBySettingId(Integer settingId);
}