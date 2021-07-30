package com.fei.rank.application.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface RankReportDao {
    /**
     * 获取所有行业名称
     */
    List<String> getAllIndustryName(@Param("statDate") String statDate, @Param("businessType") String businessType);
}