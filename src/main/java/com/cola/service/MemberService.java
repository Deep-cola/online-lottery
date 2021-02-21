package com.cola.service;

import com.cola.mapper.MemberMapper;
import com.cola.mapper.SettingMapper;
import com.cola.model.Member;
import com.cola.model.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Deepcola
 * @time: 2021/2/2 12:09
 */
@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private SettingMapper settingMapper;

    // 根据 settingId 查询 member 列表
    public List<Member> queryBySettingId(Integer settingId) {
        return memberMapper.selectBySettingId(settingId);
    }

    /**
     * 添加抽奖人员
     */
    public int add(Member member, Integer userId) {
        Setting setting = settingMapper.selectByUserId(userId);
        // 设置 setting.id 到 member 的 setting_id
        member.setSettingId(setting.getId());
        return memberMapper.insertSelective(member);
    }

    /**
     * 修改抽奖人员信息
     */
    public int update(Member member) {
        return memberMapper.updateByPrimaryKeySelective(member);
    }

    /**
     * 删除抽奖人员
     */
    public int delete(Integer id) {
        return memberMapper.deleteByPrimaryKey(id);
    }
}
