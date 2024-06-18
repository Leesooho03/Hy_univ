package com.hy.univ.dtl;

import com.hy.univ.main.MainVO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import static ch.qos.logback.core.joran.JoranConstants.NULL;

@Controller
public class DtlController {
    @Autowired
    private DtlService dtlService;

    @RequestMapping(value = "/univDtl.do")
    public String univDtl(ModelMap model, HttpServletRequest request) throws Exception {
        String univId = request.getParameter("univ_id");
        MainVO detail = dtlService.getUnivDtl(univId);
        model.addAttribute("univDetail", detail);

        return "UnivDetail";
    }
    @RequestMapping(value = "/insertDtl.do")
    public String insertDtl(@ModelAttribute("MainVO")MainVO mVO) {
        try {
            dtlService.insertDtl(mVO);
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/univDtl.do";
        }
        return "redirect:/univList.do";
    }
    @RequestMapping(value = "/updateDtl.do")
    public String updateUniv(@ModelAttribute("MainVO")MainVO mVO) {
        if ("".equals(mVO.getSch_start())) {
            mVO.setSch_start(null);
        }
        if ("".equals(mVO.getSch_end())) {
            mVO.setSch_end(null);
        }
        if ("".equals(mVO.getSch_nomi_end())) {
            mVO.setSch_nomi_end(null);
        }
        if ("".equals(mVO.getSch_app_end())) {
            mVO.setSch_app_end(null);
        }
        dtlService.updateDtl(mVO);
        return "redirect:/univDtl.do?univ_id=" + mVO.getUniv_id().toString();
    }
}
