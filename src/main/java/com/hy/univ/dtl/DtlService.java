package com.hy.univ.dtl;

import com.hy.univ.main.MainVO;

import java.util.List;

public interface DtlService {
    MainVO getUnivDtl(String univId) throws Exception;
    void insertDtl(MainVO mVO) throws Exception;

    void updateDtl(MainVO mVO);
}
