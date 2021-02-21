package com.cola.service;

import com.cola.exception.AppException;
import com.cola.mapper.SettingMapper;
import com.cola.mapper.UserMapper;
import com.cola.model.Setting;
import com.cola.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @description:
 * @author: Deepcola
 * @time: 2021/2/21 16:35
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SettingMapper settingMapper;

    // 获取本地路径前缀
    @Value("${user.head.local-path}")
    private String headLocalPath;

    @Value("${user.head.remote-path}")
    private String headRemotePath;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");

    /**
     * 根据用户名查询用户
     */
    public User queryByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    /**
     * 将用户头像保存到服务端本地
     */
    public String saveHead(MultipartFile headFile) {
        // 1.获取当前日期并格式化, 以当前日期作为文件夹名
        Date date = new Date();
        String dirUri = "/" + DATE_FORMAT.format(date);
        File dirFile = new File(headLocalPath + dirUri);
        // 如果文件夹不存在就创建一个
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        // 2.保存到本地的相应文件夹, 保证文件唯一: 随机字符串作为文件名, 同时保留后缀
        // 获取头像文件后缀
        String suffix = headFile.getOriginalFilename()
                .substring(headFile.getOriginalFilename().lastIndexOf("."));
        // 文件名: 随机字符串 + 文件后缀
        String headName = UUID.randomUUID().toString() + suffix;
        String uri = dirUri + "/" + headName;
        try {
            headFile.transferTo(new File(headLocalPath + uri));
        } catch (IOException e) {
            throw new AppException("REGISTER001", "头像上传出错");
        }
        // 返回绝对路径
        return headRemotePath + uri;
    }

    /**
     * 用户注册
     * 事务处理: 多个更新必须, 部分查询＋更新有时候需要
     * 在方法执行后: 有异常就 callback, 没有异常 commit  -> 禁止使用 try-Catch
     */
    @Transactional// 可以手动设置隔离级别和传播特性
    public void register(User user) {
        // 数据库校验 - 用户名不能重复
        User get = userMapper.selectByUsername(user.getUsername());
        if (get != null) {
            throw new AppException("REGISTER002", "用户名已存在");
        }
        // 插入 user 数据表
        int n = userMapper.insertSelective(user);
        // 插入 setting 表(登录后, 进入设置页面, 添加奖项个抽奖人员, 需要 setting_id)
        Setting setting = new Setting();
        setting.setUserId(user.getId());// 用户 id
        setting.setBatchNumber(8);// 设置每次抽奖人数默认值为 8
        settingMapper.insertSelective(setting);
    }

}
