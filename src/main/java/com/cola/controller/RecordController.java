package com.cola.controller;

import com.cola.model.User;
import com.cola.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @description:
 * @author: Deepcola
 * @time: 2021/2/21 16:34
 */
@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    /**
     * 抽奖
     * 在某个奖项下抽奖, 一次抽取一或多个人(插入一或多条抽奖记录)
     */
    @PostMapping("/add/{awardId}")
    public Object add(@PathVariable String awardId, @RequestBody List<Integer> memberIds) {
        int n = recordService.add(awardId, memberIds);
        return null;
    }

    /**
     * 删除当前奖项某个获奖人员
     */
    @GetMapping("/delete/member")
    public Object deleteByMemberId(Integer memberId) {
        int n = recordService.deleteByMemberId(memberId);
        return null;
    }

    /**
     * 删除当前奖项所有已获奖人员
     */
    @GetMapping("/delete/award")
    public Object deleteByAwardId(Integer awardId) {
        int n = recordService.deleteByAwardId(awardId);
        return null;
    }

    /**
     * 重置抽奖结果: 清空该设置页面所有奖项纪录
     */
    @GetMapping("/delete/setting")
    public Object deleteBySetting(HttpSession session) {
        User user = (User) session.getAttribute("user");
        // user.id -> setting_id -> member_id, award_id -> record_id
        int n = recordService.deleteByUserId(user.getId());
        return null;
    }
}
