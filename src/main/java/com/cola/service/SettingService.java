package com.cola.service;

import com.cola.mapper.SettingMapper;
import com.cola.model.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Deepcola
 * @time: 2021/2/2 12:11
 */
@Service
public class SettingService {

    @Autowired
    private SettingMapper settingMapper;

    // 根据 userId 查询 setting 信息
    public Setting queryByUserId(Integer userId) {
        return settingMapper.selectByUserId(userId);
    }

    // 根据 userId 修改每次抽奖人数
    public int updateByUserId(Integer batchNumber, Integer userId) {
        return settingMapper.updateByUserId(batchNumber, userId);
    }
}
