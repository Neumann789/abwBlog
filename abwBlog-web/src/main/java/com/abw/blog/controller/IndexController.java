package com.abw.blog.controller;

import com.abw.blog.common.BaseReq;
import com.abw.blog.common.BaseRsp;
import com.abw.blog.common.constants.RspCodeEnum;
import com.abw.blog.config.ConfigUtils;
import com.abw.blog.model.AbwConfig;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

    /**
     * 后面这个配置可以加上权限控制
     * @return
     */
    @RequestMapping(value = "/config",method= RequestMethod.POST)
    public BaseRsp config(){
        Map<String,Object> allConfig = ConfigUtils.getAllConfig();
        return BaseRsp.returnSuccss(allConfig);
    }



}
