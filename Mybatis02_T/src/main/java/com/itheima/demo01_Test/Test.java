package com.itheima.demo01_Test;

import com.itheima.demo02_pojo.User;
import com.itheima.demo03_mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class Test {
    public static void main(String[] args) throws IOException {

        String resource = "mybatis-config.xml";//指定核心配置文件名称
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 执行sql
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> select = mapper.selectAll();
        System.out.println(select);
        //4. 释放资源
        sqlSession.close();
    }
}
