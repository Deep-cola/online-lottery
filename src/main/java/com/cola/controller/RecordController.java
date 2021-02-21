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
 * @time: 2021/2/2 12:13
 */
@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    /**
     * 在某个奖项下抽奖, 一次抽取多个人(插入多条抽奖记录)
     */
    @PostMapping("/add/{awardId}")
    public Object add(@RequestBody List<Integer> memberIds, @PathVariable Integer awardId) {
        int n = recordService.add(memberIds, awardId);
        return null;
    }

    /**
     * 删除某人的该条抽奖记录
     */
    @GetMapping("/delete/member")
    public Object deleteByMemberId(Integer memberId) {
        int n = recordService.deleteByMemberId(memberId);
        return null;
    }

    /**
     * 删除某个奖项的所有抽奖记录
     */
    @GetMapping("/delete/award")
    public Object deleteByAwardId(Integer awardId) {
        int n = recordService.deleteByAwardId(awardId);
        return null;
    }

    /**
     * 清空该设置页面所有奖项纪录
     */
    @GetMapping("/delete/setting")
    public Object deleteBySetting(HttpSession session) {
        User user = (User) session.getAttribute("user");
        // user.id -> setting_id -> member_id, award_id -> record_id
        int n = recordService.deleteByUserId(user.getId());
        return null;
    }
}
