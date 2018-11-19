package com.hxe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hxe.core.user.query.TokenQuery;
import com.hxe.core.user.query.UserQuery;
import com.hxe.core.user.service.ITokenService;
import com.hxe.core.user.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    @Autowired
    private IUserService userService;
    @Autowired
    private ITokenService tokenService;

    @Test
    public void contextLoads() {
        TokenQuery query = new TokenQuery();
        query.setId(1L);
        UserQuery userquery = new UserQuery();
        userquery.setId(1L);;
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(userService.getOne(query));
        System.out.println(tokenService.getOne(query));
    }
}
