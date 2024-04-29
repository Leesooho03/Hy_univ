package com.hy.univ.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private MainService mainService;

    @RequestMapping(value = "/univList.do")
    public String univList(ModelMap model, @RequestParam(defaultValue = "1") int pg) throws Exception {
        int recordCountPerPage = 10;

        int totalUniv = mainService.getUnivTotal();
        int totalPageCount = (int) Math.ceil((double) totalUniv / recordCountPerPage);
        int startIdx = (pg - 1) * recordCountPerPage;
        List<MainVO> univList = mainService.getUnivList(startIdx,recordCountPerPage);

        model.addAttribute("univList", univList);
        model.addAttribute("totalUniv", totalUniv);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("startIdx", startIdx);
        model.addAttribute("pg", pg);
        model.addAttribute("recordCountPerPage", recordCountPerPage);
        return "UnivList";
    }

}
