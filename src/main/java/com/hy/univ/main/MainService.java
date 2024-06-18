package com.hy.univ.main;

import java.util.List;

public interface MainService {
    List<MainVO> getUnivList(int startIdx, int recordCountParPage, String searchKeyword, String s_country, String s_lang, MainVO mVO) throws Exception;
    int getUnivTotal(String searchKeyword, String s_country, String s_lang, MainVO mVO) throws Exception;
    List<MainVO> getCountry();

    List<MainVO> getLang();

    MainVO getSimple(String name);
}
