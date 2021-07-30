package com.fei.rank.application.service;



import com.fei.rank.api.query.QueryTopTen;

import java.util.List;

public interface RankService {

    /**
     * 获取所有行业名称
     */
    List<String> getAllIndustryName(QueryTopTen queryTopTen);
}
