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
 * @time: 2021/2/2 12:08
 */
@Service
public class AwardService {

    @Autowired
    private AwardMapper awardMapper;

    @Autowired
    private SettingMapper settingMapper;

    /**
     * 根据 settingId 查询 award 列表
     */
    public List<Award> queryBySettingId(Integer settingId) {
        return awardMapper.selectBySettingId(settingId);
    }

    /**
     * 新增奖项
     */
    public int add(Award award, Integer userId) {
        // 通过 user.id 查询 setting 信息
        Setting setting = settingMapper.selectByUserId(userId);
        // 设置 award 数据表的 setting_id 为 setting.id
        award.setSettingId(setting.getId());
        // 插入奖项
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
