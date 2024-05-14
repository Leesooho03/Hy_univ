package com.hy.univ.main;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private MainService mainService;

    @RequestMapping(value = "/univList.do")
    public String univList(ModelMap model, @RequestParam(defaultValue = "1") int pg, HttpServletRequest request, @ModelAttribute("MainVO")MainVO mVO) throws Exception {
        int recordCountPerPage = 10;
        String searchKeyword = request.getParameter("search")==null?"":request.getParameter("search");
        String s_country = request.getParameter("univ_country");
        String s_lang = request.getParameter("univ_lang");

        int totalUniv = mainService.getUnivTotal(searchKeyword, s_country, s_lang);
        int totalPageCount = (int) Math.ceil((double) totalUniv / recordCountPerPage);
        int startIdx = (pg - 1) * recordCountPerPage;
        List<MainVO> univList = mainService.getUnivList(startIdx,recordCountPerPage, searchKeyword, s_country, s_lang);

        model.addAttribute("univList", univList);
        model.addAttribute("totalUniv", totalUniv);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("startIdx", startIdx);
        model.addAttribute("pg", pg);
        model.addAttribute("recordCountPerPage", recordCountPerPage);
        return "UnivList";
    }
    @RequestMapping(value = "/index.do")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/about.do")
    public String about(){
        return "UnivList";
    }

    @RequestMapping(value = "/get-a-quote.do")
    public String getquote(){
        return "get-a-quote";
    }

    @RequestMapping(value = "/pricing.do")
    public String pricing(){
        return "pricing";
    }

    @RequestMapping(value = "/sample-inner-page.do")
    public String sample(){
        return "sample-inner-page";
    }

    @RequestMapping(value = "/service-details.do")
    public String service_dtl(){
        return "service-details";
    }

    @RequestMapping(value = "/gpt.do")
    public String gpt(){ return "gpt"; }

    @RequestMapping(value = "/services.do")
    public String service(ModelMap model, @RequestParam(defaultValue = "1") int pg, HttpServletRequest request, @ModelAttribute("MainVO")MainVO mVO) throws Exception {
        List<MainVO> countryList = mainService.getCountry();
        List<MainVO> lang_list = mainService.getLang();
        int recordCountPerPage = 10;
        String searchKeyword = request.getParameter("search")==null?"":request.getParameter("search");
        String s_country = request.getParameter("univ_country");
        String s_lang = request.getParameter("univ_lang");

        int totalUniv = mainService.getUnivTotal(searchKeyword, s_country, s_lang);
        int totalPageCount = (int) Math.ceil((double) totalUniv / recordCountPerPage);
        int startIdx = (pg - 1) * recordCountPerPage;
        List<MainVO> univList = mainService.getUnivList(startIdx,recordCountPerPage, searchKeyword, s_country, s_lang);


        model.addAttribute("s_country", s_country);
        model.addAttribute("s_lang", s_lang);
        model.addAttribute("univList", univList);
        model.addAttribute("totalUniv", totalUniv);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("startIdx", startIdx);
        model.addAttribute("pg", pg);
        model.addAttribute("recordCountPerPage", recordCountPerPage);
        model.addAttribute("searchKeyword", searchKeyword);
        model.addAttribute("countryList", countryList);
        model.addAttribute("langList", lang_list);
        return "services";
    }

    @RequestMapping(value = "/contact.do")
    public String contact(){
        return "contact";
    }
    @RequestMapping(value = "/univList1.do")
    public String string(ModelMap model, @RequestParam(defaultValue = "1") int pg, HttpServletRequest request, @ModelAttribute("MainVO")MainVO mVO) throws Exception {
        List<MainVO> countryList = mainService.getCountry();
        List<MainVO> lang_list = mainService.getLang();
        int recordCountPerPage = 10;
        String searchKeyword = request.getParameter("search")==null?"":request.getParameter("search");
        String s_country = request.getParameter("univ_country");
        String s_lang = request.getParameter("univ_lang");

        int totalUniv = mainService.getUnivTotal(searchKeyword, s_country, s_lang);
        int totalPageCount = (int) Math.ceil((double) totalUniv / recordCountPerPage);
        int startIdx = (pg - 1) * recordCountPerPage;
        List<MainVO> univList = mainService.getUnivList(startIdx,recordCountPerPage, searchKeyword, s_country, s_lang);

        model.addAttribute("univList", univList);
        model.addAttribute("totalUniv", totalUniv);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("startIdx", startIdx);
        model.addAttribute("pg", pg);
        model.addAttribute("recordCountPerPage", recordCountPerPage);
        return "UnivList_1";
    }

}
