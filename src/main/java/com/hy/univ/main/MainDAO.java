package com.hy.univ.main;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("MainDAO")
public class MainDAO {
    private final SqlSession sql;
    @Autowired
    public MainDAO(SqlSession sql) {
        this.sql = sql;
    }
    public List<MainVO> getUnivList(int startIdx, int recordCountPerPage){
        Map<String,Object> map = new HashMap<>();
        map.put("start", startIdx);
        map.put("pageSize", recordCountPerPage);
        return sql.selectList("testMapper.getUnivList",map);
    }

    public int getUnivTotal() {
        Map<String,Object> map = new HashMap<>();
        return sql.selectOne("testMapper.getUnivTotal",map);
    }
}
