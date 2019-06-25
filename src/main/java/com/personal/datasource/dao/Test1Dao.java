package com.personal.datasource.dao;

import com.personal.datasource.model.Test1Table;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Test1Dao{

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public Map getById(Long id) {
        Map map = sqlSessionFactory.openSession().selectOne("com.personal.datasource.datasource_test1.select",id);
        return map;
    }
}
