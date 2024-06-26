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
    public List<MainVO> getUnivList(int startIdx, int recordCountPerPage, String searchKeyword, String s_country, String s_lang, MainVO mVO){
        Map<String,Object> map = new HashMap<>();
        map.put("searchKeyword", searchKeyword);
        map.put("start", startIdx);
        map.put("pageSize", recordCountPerPage);
        map.put("s_country", s_country);
        map.put("s_lang",s_lang );
        map.put("univ_eng", mVO.getUniv_eng());
        map.put("univ_score", mVO.getUniv_score());
        map.put("campus_on", mVO.getCampus_on());
        map.put("campus_off", mVO.getCampus_off());
        map.put("univ_master",mVO.getUniv_master());
        return sql.selectList("testMapper.getUnivList",map);
    }

    public int getUnivTotal(String searchKeyword, String s_country, String s_lang, MainVO mVO) {
        Map<String,Object> map = new HashMap<>();
        map.put("searchKeyword", searchKeyword);
        map.put("s_country", s_country);
        map.put("s_lang",s_lang );
        map.put("univ_eng", mVO.getUniv_eng());
        map.put("univ_score", mVO.getUniv_score());
        map.put("campus_on", mVO.getCampus_on());
        map.put("campus_off", mVO.getCampus_off());
        map.put("univ_master",mVO.getUniv_master());
        return sql.selectOne("testMapper.getUnivTotal",map);
    }

    public List<MainVO> getCountry() {
        return sql.selectList("testMapper.getCountry");
    }

    public List<MainVO> getLang() {
        return sql.selectList("testMapper.getLang");
    }

    public MainVO getSimple(String name) {
        System.out.println(name);
        return sql.selectOne("testMapper.getSimple", name);
    }
}
