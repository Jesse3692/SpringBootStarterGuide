package com.shiyanlou.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.shiyanlou.springboot.first.UserOne;
import com.shiyanlou.springboot.first.UserOneService;
import com.shiyanlou.springboot.second.UserTwo;
import com.shiyanlou.springboot.second.UserTwoService;

/**
 * ApplicationRunner 接口可以让在spring boot启动后马上执行想要执行的方法
 */
@Component
public class DataSourceTest implements ApplicationRunner{
    @Autowired
    public UserOneService userOneService;

    @Autowired
    public UserTwoService userTwoService;

    /**
     * 该方法在spring boot启动完成后立即执行
     */
    @Override
    public void run(ApplicationArguments args){
        // 新建一个实体类
        UserOne userOne = new UserOne();
        userOne.setUsername("shiyanlou1");
        userOne.setPassword("springboot1");
        // 调用Service
        userOneService.save(userOne);

        UserTwo userTwo = new UserTwo();
        userTwo.setPassword("shiyanlou2");
        userTwo.setUsername("springboot2");
        // 调用Service
        userTwoService.save(userTwo);
    }
}
