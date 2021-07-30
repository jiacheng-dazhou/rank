package com.fei.rank.application.entity;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(staticName =  "of" )
@Builder
public class RankReportDO {
    private Long id;
     //业务需求类型，对应榜单的12个需求 
    private String businessType;
     //月榜单1，日榜单2 
    private String dataType;
     //数据统计时间 
    private String statDate;
     //人员id 
    private String empId;
     //人员姓名 
    private String empName;
     //客户行业 
    private String industryName;
      //总消耗值，单位分 
    private Long totalCost;
     //统计数量值 
    private BigDecimal totalCnt;
     //排名 
    private Integer rk;
     //统计的素材类型，image，video 
    private String materialType;
     //素材url地址 
    private String materialUrl;
     //数据更新时间,yyyy-MM-dd HH:mm:ss 
    private String updateTime;
     //视频首帧地址 
    private String firstFrameUrl;
}
