package com.hy.univ.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainServiceImpl implements MainService {
    @Autowired
    private MainDAO mainDAO;

    @Override
    public List<MainVO> getUnivList(int startIdx, int recordCountPerPage, String searchKeyword, String s_country, String s_lang){
        return mainDAO.getUnivList(startIdx, recordCountPerPage, searchKeyword, s_country, s_lang);
    }

    @Override
    public int getUnivTotal(String searchKeyword, String s_country, String s_lang) {
        return mainDAO.getUnivTotal(searchKeyword, s_country, s_lang);
    }

    @Override
    public List<MainVO> getCountry() {
        return mainDAO.getCountry();
    }

    @Override
    public List<MainVO> getLang() {
        return mainDAO.getLang();
    }
}
