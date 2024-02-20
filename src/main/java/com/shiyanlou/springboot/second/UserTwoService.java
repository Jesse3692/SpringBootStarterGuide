package com.shiyanlou.springboot.second;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserTwoService {

    @Autowired
    private UserTwoRepository userTwoRepository;

    @Transactional(rollbackFor = Exception.class)
    public UserTwo save(UserTwo userTwo) {
        // 保存实体类
        return userTwoRepository.save(userTwo);
    }
}
