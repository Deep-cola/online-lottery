package com.cola.mapper;

import com.cola.base.BaseMapper;
import com.cola.model.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AwardMapper extends BaseMapper<Award> {

    // 根据 settingId 查询 award 列表
    List<Award> selectBySettingId(Integer settingId);
}