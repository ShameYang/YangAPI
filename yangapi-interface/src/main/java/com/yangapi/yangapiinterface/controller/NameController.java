package com.yangapi.yangapiinterface.controller;

import com.shameyang.yangapiclientsdk.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author ShameYang
 * @date 2024/8/28 16:42
 * @description 模拟 API 接口
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/get")
    public String getNameByGet(String name) {
        return "GET 你的名字是: " + name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是: " + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user) {
        return "POST 用户名是: " + user.getUsername();
    }
}