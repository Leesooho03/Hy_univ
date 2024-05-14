package com.hy.univ.gpt;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository("gptDAO")
public class gptDAO {
    private static SqlSession sql = null;

    public gptDAO(SqlSession sql) {
        gptDAO.sql = sql;
    }

    public static void gptInsert(String prompt, String responseBody){
        Map<String,Object> map = new HashMap<>();
        map.put("responseBody",responseBody);
        map.put("prompt",prompt);
        sql.insert("testMapper.gptInsert", map);
    }
}
