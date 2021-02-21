package com.cola.service;

import com.cola.mapper.AwardMapper;
import com.cola.mapper.SettingMapper;
import com.cola.model.Award;
import com.cola.model.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Deepcola
 * @time: 2021/2/21 16:39
 */
@Service
public class AwardService {

    @Autowired
    private AwardMapper awardMapper;

    @Autowired
    private SettingMapper settingMapper;

    /**
     * 根据 settingId 查询 Award 列表
     */
    public List<Award> queryBySettingId(Integer settingId) {
        return awardMapper.selectBySettingId(settingId);
    }

    /**
     * 添加奖项
     */
    public int add(Award award, Integer userId) {
        // 根据 user.id 查询 setting 信息
        Setting setting = settingMapper.selectByUserId(userId);
        // 设置 setting.id 到 award 数据表的 settingId
        award.setSettingId(setting.getId());
        return awardMapper.insertSelective(award);
    }

    /**
     * 修改奖项
     */
    public int update(Award award) {
        return awardMapper.updateByPrimaryKeySelective(award);
    }

    /**
     * 删除奖项
     */
    public int delete(Integer id) {
        return awardMapper.deleteByPrimaryKey(id);
    }
}
