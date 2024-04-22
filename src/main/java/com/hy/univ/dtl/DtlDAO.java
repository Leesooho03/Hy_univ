package com.hy.univ.dtl;

import com.hy.univ.main.MainVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("DtlDAO")
public class DtlDAO {
    private final SqlSession sql;
    @Autowired
    public DtlDAO(SqlSession sql) {
        this.sql = sql;
    }

    public MainVO getUnivDtl(String univId) throws Exception {
        return sql.selectOne("testMapper.getUnivDtl", univId);
    }

    public void insertDtl(MainVO vo) throws Exception {
        sql.insert("testMapper.insertDtl", vo);
    }
}
