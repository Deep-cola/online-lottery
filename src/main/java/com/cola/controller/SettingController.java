package com.cola.controller;

import com.cola.model.Award;
import com.cola.model.Member;
import com.cola.model.Setting;
import com.cola.model.User;
import com.cola.service.AwardService;
import com.cola.service.MemberService;
import com.cola.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @description:
 * @author: Deepcola
 * @time: 2021/2/21 16:34
 */
@RestController
@RequestMapping("/setting")
public class SettingController {

    @Autowired
    private SettingService settingService;

    @Autowired
    private AwardService awardService;

    @Autowired
    private MemberService memberService;

    /**
     * 抽奖设置页面数据查询
     * 进入抽奖设置页面初始化, 需要获取所有需要的数据:
     * setting 对象中的属性: batchNumber
     * setting 对象没有的属性: user(用户信息)、
     *                      awards(奖项信息, 根据 setting_id 查询)、
     *                      member(抽奖人员, 根据 setting_id 查询)
     */
    @GetMapping("/query")
    public Object query(HttpSession session) {
        // 获取 session 中的 user
        User user = (User) session.getAttribute("user");
        // 根据 user.id 查询 setting 信息
        Setting setting = settingService.queryBuUserId(user.getId());
        // 把 user 设置到 setting 新增属性 user 中
        setting.setUser(user);
        // 根据 setting_id 查询 awards, 设置到 setting 新增属性 awards 中
        List<Award> awards = awardService.queryBySettingId(setting.getId());
        setting.setAwards(awards);
        // 根据 setting_id 查询 members, 设置到 setting 新增属性 members 中
        List<Member> members = memberService.queryBySettingId(setting.getId());
        setting.setMembers(members);
        return setting;
    }

    /**
     * 修改每次抽奖人数
     */
    @GetMapping("/update")
    public Object update(Integer batchNumber, HttpSession session) {
        User user = (User) session.getAttribute("user");
        // 根据 user 修改每次抽奖人数
        int n = settingService.updateByUserId(batchNumber, user.getId());
        return null;
    }
}
