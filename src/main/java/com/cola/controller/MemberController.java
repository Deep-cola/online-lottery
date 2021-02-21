package com.cola.controller;

import com.cola.model.Member;
import com.cola.model.User;
import com.cola.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: Deepcola
 * @time: 2021/2/21 16:34
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * 新增抽奖人员
     */
    @PostMapping("/add")
    public Object add(@RequestBody Member member, HttpSession session) {
        User user = (User) session.getAttribute("user");
        int n = memberService.add(member, user.getId());
        return member.getId();
    }

    /**
     * 修改抽奖人员
     */
    @PostMapping("/update")
    public Object update(@RequestBody Member member) {
        int n = memberService.update(member);
        return null;
    }

    /**
     * 删除抽奖人员
     */
    @GetMapping("/delete/{id}")
    public Object delete(@PathVariable Integer id) {
        int n = memberService.delete(id);
        return null;
    }
}
