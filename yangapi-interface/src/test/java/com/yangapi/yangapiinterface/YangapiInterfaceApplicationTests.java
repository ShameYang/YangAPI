package com.yangapi.yangapiinterface;

import com.shameyang.yangapiclientsdk.client.YangApiClient;
import com.shameyang.yangapiclientsdk.model.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class YangapiInterfaceApplicationTests {

    @Resource
    private YangApiClient yangApiClient;

    @Test
    void contextLoads() {
        String result = yangApiClient.getNameByGet("shameyang");
        User user = new User();
        user.setUsername("yang");
        String usernameByPost = yangApiClient.getUsernameByPost(user);
        System.out.println(result);
        System.out.println(usernameByPost);
    }

}