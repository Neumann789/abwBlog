package com.abw.blog.controller;

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

        BaseRsp rsp = new BaseRsp();
        rsp.setCode("0000");
        rsp.setMsg("处理成功");
        return rsp;
    }

}
