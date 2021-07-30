package com.fei.rank.server.web.controller;


import com.fei.rank.api.query.QueryTopTen;
import com.fei.rank.application.service.RankService;
import com.fei.rank.server.support.CallResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController()
@Slf4j
public class RankController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RankService rankService;

    @RequestMapping("/getRank")
    public List<Map<String, Object>> getDbType(){
        String sql = "select * from bigdata_app_rank_report limit 0,2";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Map.Entry<String, Object>> entries = map.entrySet( );
            if(entries != null) {
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
                while(iterator.hasNext( )) {
                    Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
                    Object key = entry.getKey( );
                    Object value = entry.getValue();
                    System.out.println(key+":"+value);
                }
            }
        }
        return list;
    }
    @RequestMapping("/getIndustry")
    public CallResult getAllIndustry(QueryTopTen queryTopTen){
        CallResult callResult = defaultErrorResult();
        log.info("传入参数queryTopTen=={}"+queryTopTen);
        if(queryTopTen==null){
            return defaultErrorResult("传参为空");
        }
        try {
            List<String> industryNames = rankService.getAllIndustryName(queryTopTen);
            callResult= successResult(industryNames);
        } catch (Exception e) {
            log.error("错误信息："+e.getMessage());
            callResult=defaultErrorResult("获取行业失败");
        }
        return callResult;
    }
    private static CallResult defaultErrorResult() {
        CallResult result = new CallResult();
        result.setCode("-1");
        result.setMessage("error");
        return result;
    }
    private static CallResult defaultErrorResult(String message) {
        CallResult result = new CallResult();
        result.setCode("-1");
        result.setMessage(message);
        return result;
    }
    public static <T> CallResult successResult(T t)
    {
        CallResult result = successResult();
        result.setT(t);
        return result;
    }
    public static CallResult successResult()
    {
        CallResult result = new CallResult();
        result.setCode("0");
        result.setMessage("success");
        return result;
    }
}
