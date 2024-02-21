package com.shiyanlou.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.springboot.entity.User;
import com.shiyanlou.springboot.service.IUserService;

@RestController
@RequestMapping("user")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    // 使用 post 请求新建
    @PostMapping()
    public String save(User user) {
        userService.save(user);
        return "save success";
    }

    // 使用put请求更新，会拦截类似/user/1这种形式的路径
    @PutMapping("{id}")
    public String update(User user, @PathVariable int id) {
        // 当数据不存在时，不允许更新
        if (userService.findById(id) == null) {
            return "Not Exist";
        }

        // 防止传入的id不一致，如user中的id属性是2，而url路径中id为1
        if (user.getId() != id) {
            return "Unmatched parameters";
        }
        userService.update(user);
        return "update success";

    }

    // 使用delete请求删除
    @DeleteMapping("{id}")
    public String delete(@PathVariable int id) {
        userService.delete(id);
        return "delete success";
    }

    // 使用get方法查询
    @GetMapping()
    public List<User> list() {
        return userService.list();
    }

    // 使用get方法查询单个数据
    @GetMapping("{id}")
    public User getById(@PathVariable int id) {
        return userService.findById(id);
    }

}
