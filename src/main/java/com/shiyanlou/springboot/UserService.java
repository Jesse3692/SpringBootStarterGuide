package com.shiyanlou.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 添加事务管理
     */
    @Transactional(rollbackFor = Exception.class)
    public User save(User user) {
        // 保存实体类
        userRepository.save(user);
        // 人为抛出异常
        int shiyanlou = 1 / 0;
        // 修改密码
        user.setPassword("123456");
        // 重新保存，更新记录
        return userRepository.save(user);
    }
}
