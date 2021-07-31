package com.fei.rank.application.redis;


import com.fei.rank.application.entity.EmployeeEntity;

public interface RedisApplication {

    /**
     * 根据员工id获取员工信息
     */
    EmployeeEntity getEmployeeByEmpId(String employeeId);

    /**
     * 存入员工信息，hash存储
     */
    void pushEmployeeToHash(String employeeId,EmployeeEntity employeeEntity);

    /**
     * 根据员工id获取员工信息，hash存储
     */
    EmployeeEntity getEmployeeByHash(String employeeId);
}
