package com.abw.blog.controller;

import com.abw.blog.common.BaseReq;
import com.abw.blog.common.BaseRsp;
import com.abw.blog.common.constants.RspCodeEnum;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fanghuabao on 2018/4/13 0013.
 */

@RestController
@RequestMapping("/abwBlog")
public class IndexController {

    @RequestMapping(value = "/index",method= RequestMethod.POST)
    public BaseRsp index(@RequestBody BaseReq req){

        BaseRsp rsp = new BaseRsp(RspCodeEnum.SUCCESS);
        return rsp;
    }

}
