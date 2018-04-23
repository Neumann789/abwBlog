package com.abw.blog.controller;

import com.abw.blog.common.BaseRsp;
import com.abw.blog.common.constants.RspCodeEnum;
import com.abw.blog.service.req.UserInfo;
import com.abw.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fanghuabao on 2018/4/21 0021.
 */
@RestController
@RequestMapping("/abwBlog")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method= RequestMethod.POST)
    public BaseRsp login(@RequestBody UserInfo req){
        return userService.login(req);
    }


    @RequestMapping(value = "/regist",method= RequestMethod.POST)
    public BaseRsp regist(@RequestBody UserInfo req){
        return userService.regist(req);
    }

}
