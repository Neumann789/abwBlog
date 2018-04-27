package com.abw.blog.config;

import com.abw.blog.common.constants.RspCodeEnum;
import com.abw.blog.common.exception.AbwException;
import com.abw.blog.common.utils.RegexUtils;
import com.abw.blog.common.utils.SpringUtils;
import com.abw.blog.mapper.AbwConfigMapper;
import com.abw.blog.model.AbwConfig;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by fanghuabao on 2018/4/26 0026.
 */


public class ConfigUtils implements InitializingBean{

    /**
     * 正则匹配字符格式形如:  k1=v1|k2=v2|k3=v3
     */
    public static final String EXT_MAP_REGEX = "([A-Za-z0-9]+=[A-Za-z0-9/]*\\|)*[A-Za-z0-9]+=[A-Za-z0-9/]*";

    public static Map<String,Object> configContainer = new ConcurrentHashMap<>();

    /**
     * TODO 树状结构的逻辑，待定实现
     * @return
     */
    public static Map<String,Object> getAllConfig(){
        if(configContainer.isEmpty()){
            init();
        }
        return configContainer;
    }

    /**
     * 将AbwConfig转换为ConfigCell
     * @param abc
     * @return
     */
    private static ConfigCell trans2ConfigCell(AbwConfig abc){
        ConfigCell cc = new ConfigCell();
        BeanUtils.copyProperties(abc,cc);
        cc.setExtMap(extractMapFromExtMap(abc.getExtMap()));
        return cc;
    }

    /**
     * 解析extMap
     *
     * @param extMap
     * @return
     */
    private static Map<String,String> extractMapFromExtMap(String extMap){

        Map<String,String> map = new HashMap<>();


        //格式校验
        if(RegexUtils.isMatch(extMap,EXT_MAP_REGEX)){

            String[] extMapSplitArr = extMap.split("\\|");

            for(String str:extMapSplitArr){
                String[] strArr = str.split("=");
                map.put(strArr[0],strArr[1]);
            }

        }else if(StringUtils.isEmpty(extMap)){
            //支持此字段可以为空
        }else{
            throw new AbwException(RspCodeEnum.CONFIG_READ_ERROR.getRspCode()
                    ,RspCodeEnum.CONFIG_READ_ERROR.getRspMsg("extMap格式有误"));
        }
        //转换
        return map;
    }



    /**
     * 初始化配置容器
     */
    public static void init(){

        AbwConfigMapper abwConfigMapper = SpringUtils.getBean(AbwConfigMapper.class);
        List<AbwConfig> abwConfigs = abwConfigMapper.selectAll();
        for(AbwConfig abc:abwConfigs){
            //登记type_key-val
            String typeKey = abc.getConfigType().concat("_").concat(abc.getConfigKey());
            if(!configContainer.containsKey(typeKey)){
                ConfigCell cc = trans2ConfigCell(abc);
                configContainer.put(typeKey,cc);
            }
            //登记type-list(val)
            String type = abc.getConfigType();
            if (!configContainer.containsKey(type)){
                List<ConfigCell> configCells = new ArrayList<>();
                ConfigCell cc = trans2ConfigCell(abc);
                configCells.add(cc);
                configContainer.put(type,configCells);
            }else{
                List<ConfigCell> configCells = (List<ConfigCell>)configContainer.get(type);
                ConfigCell cc = trans2ConfigCell(abc);
                configCells.add(cc);
            }
        }
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }
}
