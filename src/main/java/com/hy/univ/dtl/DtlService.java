package com.hy.univ.dtl;

import com.hy.univ.main.MainVO;

public interface DtlService {
    MainVO getUnivDtl(String univId) throws Exception;
    void insertDtl(MainVO mVO) throws Exception;
}
