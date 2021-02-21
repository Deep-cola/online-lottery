package com.cola.controller;

import com.cola.model.Award;
import com.cola.model.User;
import com.cola.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: Deepcola
 * @time: 2021/2/21 16:35
 */
@RestController
@RequestMapping("/award")
public class AwardController {

    @Autowired
    private AwardService awardService;

    /**
     * 新增奖项
     */
    @PostMapping("/add")
    public Object add(@RequestBody Award award, HttpSession session) {
        User user = (User) session.getAttribute("user");
        // 获取 user.id, 设置到 award 数据表的 setting_id
        int n = awardService.add(award, user.getId());
        // 保证插入数据后页面显示的 奖项id 不为 null
        return award.getId();
    }

    /**
     * 修改奖项
     */
    @PostMapping("/update")
    public Object update(@RequestBody Award award) {
        int n = awardService.update(award);
        return null;
    }

    /**
     * 删除奖项
     */
    @GetMapping("/delete/{id}")
    public Object delete(@PathVariable Integer id) {
        int n = awardService.delete(id);
        return null;
    }
}
