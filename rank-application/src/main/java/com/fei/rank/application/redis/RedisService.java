package com.fei.rank.application.redis;


import com.fei.rank.application.support.FeiShuUserInfoView;

public interface RedisService {
    /**
     * 根据员工id获取员工信息
     */
    FeiShuUserInfoView getEmployeeByEmpId(String employeeId);

    /**
     * 测试
     */
    String getKey();
}
