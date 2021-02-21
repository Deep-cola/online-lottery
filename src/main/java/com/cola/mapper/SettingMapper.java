package com.cola.mapper;

import com.cola.base.BaseMapper;
import com.cola.model.Setting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SettingMapper extends BaseMapper<Setting> {

    // 根据 userId 查询 setting 信息
    Setting selectByUserId(Integer userId);

    // 根据 userId 修改每次抽奖人数
    int updateByUserId(@Param("batchNumber") Integer batchNumber, @Param("userId") Integer userId);
}