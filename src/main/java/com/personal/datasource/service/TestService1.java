package com.personal.datasource.service;

import com.personal.datasource.annoation.DataSource;
import com.personal.datasource.dao.Test1Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@DataSource("dataSourceTest1")
public class TestService1 {

    @Autowired
    Test1Dao test1Dao;

    public Map get(){
        return test1Dao.getById(1L);
    }
}
