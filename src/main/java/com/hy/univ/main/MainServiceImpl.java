package com.hy.univ.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainServiceImpl implements MainService {
    @Autowired
    private MainDAO mainDAO;

    @Override
    public List<MainVO> getUnivList(int startIdx, int recordCountPerPage){
        return mainDAO.getUnivList(startIdx, recordCountPerPage);
    }

    @Override
    public int getUnivTotal() {
        return mainDAO.getUnivTotal();
    }
}
