package com.abw.blog.mapper;

import com.abw.blog.model.AbwUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by fanghuabao on 2018/4/23 0023.
 *
 * TODO 没有成功 后续完成
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AbwUserMapper.class)
@MapperScan("com.abw.blog.mapper")
public class AbwUserMapperTest {

    @Autowired
    private AbwUserMapper   abwUserMapper;

    @Test
    public void selectByPrimaryKey(){
        AbwUser abwUser = abwUserMapper.selectByPrimaryKey(1L);

    }


}
