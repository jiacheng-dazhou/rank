package com.fei.rank.application.service.impl;

import com.alibaba.fastjson.JSONObject;

import com.fei.rank.api.query.QueryTopTen;
import com.fei.rank.application.dao.RankReportDao;
import com.fei.rank.application.entity.EmployeeEntity;
import com.fei.rank.application.redis.RedisService;
import com.fei.rank.application.service.RankService;
import com.fei.rank.application.support.FeiShuUserInfoView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RankServiceImpl implements RankService {

    @Autowired
    private RankReportDao rankReportDao;

    @Autowired
    private RedisService redisService;

    @Override
    public List<String> getAllIndustryName(QueryTopTen queryTopTen) {
        FeiShuUserInfoView userInfoView = redisService.getEmployeeByEmpId("88ab995a");
        String key = redisService.getKey();
        EmployeeEntity employee = JSONObject.parseObject(key, EmployeeEntity.class);
        if(StringUtils.isNotBlank(queryTopTen.getStatDate())){
            List<String> list=rankReportDao.getAllIndustryName(queryTopTen.getStatDate(),queryTopTen.getBusinessType());
            return list;
        }
        return null;
    }
}
