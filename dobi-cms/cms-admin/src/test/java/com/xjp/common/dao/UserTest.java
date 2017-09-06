package com.xjp.common.dao;

import com.xjp.dao.TestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author xujiping
 * @create 2017-09-01 9:34
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private TestMapper testMapper;

    @Test
    public void test(){
        List<com.xjp.model.Test> list = testMapper.selectAll();
        System.out.println(list);
    }
}
