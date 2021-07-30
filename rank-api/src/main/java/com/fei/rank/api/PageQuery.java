package com.fei.rank.api;


import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageQuery<T> {
    private PageInfo page;//分页条件
    private T search;//查询条件

    public PageInfo getPageOrDefault(PageInfo page) {
        if (page == null) {
            return new PageInfo();
        } else {
            return page;
        }
    }

    //获取起始查询点
    public long getOffset(int curpage, int pagesize) {
        curpage = curpage > 0 ? curpage - 1 : curpage;
        return curpage * pagesize;
    }

    @Data
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PageInfo {
        private int pagesize = 10;//查询数量
        private int curpage = 0;//当前页
    }
}

