package com.fei.rank.api.vo;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhoujiacheng
 * @Date 2021/06/23
 */
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(staticName = "of")
@Builder
public class QueryTopTenVO {
    /**
     * 素材url
     */
    private String materialUrl;
    /**
     * 一级行业名称
     */
    private String industryName;
    /**
     * 素材类型
     */
    private String materialType;
    /**
     * 消耗合计值
     */
    private BigDecimal totalCost;
    /**
     * 新建广告数合计值
     */
    private BigDecimal totalCnt;
    /**
     * 排名
     */
    private Integer rk;
    /**
     * 数据更新时间
     */
    private String updateTime;
    /**
     * 数据统计时间
     */
    private String statDate;
    /**
     * 需求类型
     */
    private String businessType;
    /**
     * 榜单类型
     */
    private String dataType;

    private List<EmployeeInfo> employeeInfo;

    /**
     * 视频首帧地址
     */
    private String firstFrameUrl;

    @Data
    @NoArgsConstructor(access = AccessLevel.PACKAGE)
    @AllArgsConstructor(staticName = "of")
    @Builder
    public static class EmployeeInfo{
        /**
         * 员工id
         */
        private String empId;
        /**
         * 员工姓名
         */
        private String empName;
        /**
         * 部门名称
         */
        private String buDeptName;
        /**
         * 头像
         */
        private String empPhoto;
    }
}
