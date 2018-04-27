package com.abw.blog.service;

import com.abw.blog.common.BaseRsp;
import com.abw.blog.service.req.UserInfo;

/**
 * Created by fanghuabao on 2018/4/23 0023.
 *
 * 用户服务类
 */

public interface UserService {

    /**
     * 用户注册
     * @param userInfo
     */
    public BaseRsp regist(UserInfo userInfo);

    /**
     * 登录
     * @param userInfo
     */
    public BaseRsp login(UserInfo userInfo);



}
