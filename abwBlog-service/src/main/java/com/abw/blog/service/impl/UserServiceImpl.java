package com.abw.blog.service.impl;

import com.abw.blog.common.BaseRsp;
import com.abw.blog.common.constants.RspCodeEnum;
import com.abw.blog.common.exception.AbwException;
import com.abw.blog.common.utils.Md5Utils;
import com.abw.blog.config.ConfigUtils;
import com.abw.blog.mapper.AbwUserMapper;
import com.abw.blog.model.AbwConfig;
import com.abw.blog.model.AbwUser;
import com.abw.blog.service.req.UserInfo;
import com.abw.blog.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanghuabao on 2018/4/23 0023.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AbwUserMapper abwUserMapper;

    public BaseRsp login(UserInfo req){

        AbwUser abwUser=abwUserMapper.getUserByUserNameOrNickName(req.getUserName());
        if(abwUser == null){
            throw new AbwException(RspCodeEnum.LOGIN_UN_REGIST);
        }else{
            if((abwUser.getUserName().equals(req.getUserName())|| abwUser.getNickName().equals(req.getUserName()))
                       &&abwUser.getPassword().equals(Md5Utils.getMD5(req.getPassword()))){
                return BaseRsp.returnSuccss(abwUser);
            }else {
                return BaseRsp.returnRsp(RspCodeEnum.LOGIN_PSW_WRONG);
            }
        }

    }

    @Override
    public BaseRsp regist(UserInfo userInfo) {

        saveUserInfo(userInfo);

        return BaseRsp.returnSuccss();

    }

    /**
     * 保存用户信息
     * @param userInfo
     */
    public void saveUserInfo(UserInfo userInfo){
        AbwUser abwUser = new AbwUser();
        BeanUtils.copyProperties(userInfo,abwUser);
        abwUser.setPassword(Md5Utils.getMD5(abwUser.getPassword()));
        abwUserMapper.insert(abwUser);
    }
}
