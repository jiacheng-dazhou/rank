package com.fei.rank.application.redis;


import com.fei.rank.application.entity.EmployeeEntity;

public interface RedisService {

    /**
     * 根据员工id获取员工信息
     */
    EmployeeEntity getEmployeeByEmpId(String employeeId);
}
