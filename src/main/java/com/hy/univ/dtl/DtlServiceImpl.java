package com.hy.univ.dtl;

import com.hy.univ.main.MainVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtlServiceImpl implements DtlService {
    @Autowired
    private DtlDAO dtlDAO;

    @Override
    public MainVO getUnivDtl(String univId) throws Exception {
        return dtlDAO.getUnivDtl(univId);
    }
    @Override
    public void insertDtl(MainVO vo) throws Exception {
        dtlDAO.insertDtl(vo);
    }
}
