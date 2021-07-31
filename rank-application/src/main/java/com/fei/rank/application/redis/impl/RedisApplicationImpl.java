package com.fei.rank.application.redis.impl;

import com.alibaba.fastjson.JSONObject;
import com.fei.rank.application.entity.EmployeeEntity;
import com.fei.rank.application.redis.RedisApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



@Service
public class RedisApplicationImpl implements RedisApplication {

    @Autowired
    @Qualifier("rankRedis")
    private SingleJedisTemplate jedisTemplate;

    private static final String EMPLOYEE = "EMPLOYEE";

    @Override
    public EmployeeEntity getEmployeeByEmpId(String employeeId) {
        try {
            Object o = jedisTemplate.value().get(employeeId);
            String view=(String) o;
            EmployeeEntity employee = JSONObject.parseObject(view, EmployeeEntity.class);
            return employee;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void pushEmployeeToHash(String employeeId,EmployeeEntity employeeEntity) {
        try {
            jedisTemplate.hash().put(EMPLOYEE, employeeId,employeeEntity);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public EmployeeEntity getEmployeeByHash(String employeeId) {
        try {
            Object o = jedisTemplate.hash().get(EMPLOYEE,employeeId);
            EmployeeEntity employeeEntity=(EmployeeEntity)o;
            return employeeEntity;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
