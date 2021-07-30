package com.fei.rank.api.query;


import lombok.*;

/**
 * @author zhoujiacheng
 * @Date 2021/06/23
 */
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(staticName = "of")
@Builder
public class QueryTopTen{
    /**
     *一级行业名称
     */
    private String industryName;
    /**
     *素材类型
     */
    private String materialType;
    /**
     * 数据统计时间
     */
    private String statDate;
    /**
     * 业务需求类型，对应榜单的12个需求类别
     */
    private String businessType;
}
