package com.fei.rank.api.vo;

import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(staticName = "of")
@Builder
public class PageVO<T>  {

    private List<T> list;
    /**
     * 总记录数（跟现有的前端对应，字段命名有点不规范）
     */
    private long totalrecords;
    /**
     * 当前页码
     */
    private int page;

    /**
     * 当前页的记录数
     */
    private Integer records;

    /**
     * 其它返回的字段
     */
    private Map<String,Object> dataMap;

}
