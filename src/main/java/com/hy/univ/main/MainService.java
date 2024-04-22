package com.hy.univ.main;

import java.util.List;

public interface MainService {
    List<MainVO> getUnivList(int startIdx, int recordCountParPage) throws Exception;
    int getUnivTotal();
}
