package com.hy.univ.dtl;

import com.hy.univ.main.MainVO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

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
    public String insertDtl(@RequestParam Map<String, Object> map) {
        MainVO mVO = new MainVO();
        mVO.setUniv_rank(map.get("univ_rank").toString());
        mVO.setUniv_id(map.get("univ_id").toString());
        mVO.setUniv_cant(map.get("univ_cant").toString());
        mVO.setUniv_eng(map.get("univ_eng").toString());
        mVO.setUniv_min(map.get("univ_min").toString());
        mVO.setUniv_max(map.get("univ_max").toString());
        mVO.setClass_etc(map.get("class_etc").toString());
        mVO.setClass_link(map.get("class_link").toString());
        mVO.setCampus_off(map.get("campus_off").toString());
        mVO.setCampus_on(map.get("campus_on").toString());
        mVO.setUniv_master(map.get("univ_master").toString());
        mVO.setUniv_limit(map.get("univ_limit").toString());
        mVO.setUniv_leave(map.get("univ_leave").toString());
        mVO.setUniv_gpa(map.get("univ_gpa").toString());
        mVO.setUniv_toefl_ibt(map.get("univ_toefl_ibt").toString());
        mVO.setUniv_toefl_itp(map.get("univ_toefl_itp").toString());
        mVO.setUniv_ielts(map.get("univ_ielts").toString());
        mVO.setUniv_toeic(map.get("univ_toeic").toString());
        mVO.setEtc(map.get("etc").toString());
        mVO.setProgram_link(map.get("program_link").toString());
        mVO.setSch_start(map.get("sch_start").toString());
        mVO.setSch_end(map.get("sch_end").toString());
        mVO.setSch_vacation(map.get("sch_vacation").toString());
        mVO.setSch_nomi_end(map.get("sch_nomi_end").toString());
        mVO.setSch_app_end(map.get("sch_app_end").toString());

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
    public String updateUniv(@RequestParam Map<String, Object> map) {
        MainVO mVO = new MainVO();
        mVO.setUniv_rank(map.get("univ_rank").toString());
        mVO.setUniv_id(map.get("univ_id").toString());
        mVO.setUniv_cant(map.get("univ_cant").toString());
        mVO.setUniv_eng(map.get("univ_eng").toString());
        mVO.setUniv_min(map.get("univ_min").toString());
        mVO.setUniv_max(map.get("univ_max").toString());
        mVO.setClass_etc(map.get("class_etc").toString());
        mVO.setClass_link(map.get("class_link").toString());
        mVO.setCampus_off(map.get("campus_off").toString());
        mVO.setCampus_on(map.get("campus_on").toString());
        mVO.setUniv_master(map.get("univ_master").toString());
        mVO.setUniv_limit(map.get("univ_limit").toString());
        mVO.setUniv_leave(map.get("univ_leave").toString());
        mVO.setUniv_gpa(map.get("univ_gpa").toString());
        mVO.setUniv_toefl_ibt(map.get("univ_toefl_ibt").toString());
        mVO.setUniv_toefl_itp(map.get("univ_toefl_itp").toString());
        mVO.setUniv_ielts(map.get("univ_ielts").toString());
        mVO.setUniv_toeic(map.get("univ_toeic").toString());
        mVO.setEtc(map.get("etc").toString());
        mVO.setProgram_link(map.get("program_link").toString());
        mVO.setSch_start(map.get("sch_start").toString());
        mVO.setSch_end(map.get("sch_end").toString());
        mVO.setSch_vacation(map.get("sch_vacation").toString());
        mVO.setSch_nomi_end(map.get("sch_nomi_end").toString());
        mVO.setSch_app_end(map.get("sch_app_end").toString());
        dtlService.updateDtl(mVO);
        return "redirect:/univDtl.do?univ_id=" + map.get("univ_id").toString();
    }
}
