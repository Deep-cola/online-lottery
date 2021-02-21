package com.cola.controller;

import com.cola.exception.AppException;
import com.cola.model.User;
import com.cola.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: Deepcola
 * @time: 2021/2/2 12:07
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册(请求数据为 multiPartFile 格式)
     */
    @PostMapping("/register")
    public Object register(User user, MultipartFile headFile) {
        // 校验请求数据-由于前端已校验, 所以可以不使用, 但是实际上是一定需要的

        // 1.保存上传的用户头像到服务端本地, 获取服务路径
        if (headFile != null) {
            String head = userService.saveHead(headFile);
            // 2.把上传的路径映射为 http 服务路径
            // 3.把用户头像的 http 路径设置到 user 的 head 属性, 把 user 添加到数据库
            user.setHead(head);
        }
        userService.register(user);

        return null;
    }

    /**
     * 用户登录(请求数据为 json 格式)
     */
    @PostMapping("/login")
    public Object login(@RequestBody User user, HttpServletRequest request) {
        // 根据用户名查询并获取该用户: 不存在为 null
        User getUser = userService.queryByUsername(user.getUsername());
        // 用户不存在
        if (getUser == null) {
            throw new AppException("LOG001", "用户不存在");
        }
        // 用户存在: 校验密码
        if (!user.getPassword().equals(getUser.getPassword())) {
            throw new AppException("LOG002", "用户名或密码错误");
        }
        // 用户存在 + 密码验证通过: 保存 session
        HttpSession session = request.getSession();// 没有创建一个 session
        session.setAttribute("user", getUser);
        // 登录成功
        return null;
    }

    /**
     * 注销
     */
    @GetMapping("/logout")
    public Object logout(HttpSession session) {
        session.removeAttribute("user");
        return null;
    }
}
