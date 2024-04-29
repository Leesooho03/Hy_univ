package com.hy.univ.main;


import lombok.Data;

import java.io.Serializable;

@Data
public class MainVO implements Serializable {
    private String univ_id = "";
    private String univ_name = "";
    private String univ_country = "";
    private String univ_lang = "";
    private String univ_score = "";
    private String univ_to_2024 = "";
    private String univ_to_2025 = "";
    private String univ_web = "";
    private String univ_limit_date = "";
    private String remark = "";
    private String useyn = "";
    private String univ_master = "";
    private String univ_limit = "";
    private String univ_leave = "";
    private String univ_gpa = "";
    private String univ_toefl_ibt = "";
    private String univ_toefl_itp = "";
    private String univ_ielts = "";
    private String univ_toeic = "";
    private String etc = "";
    private String program_link = "";
    private String univ_cant = "";
    private String univ_eng = "";
    private String univ_min = "";
    private String univ_max = "";
    private String class_link = "";
    private String class_etc = "";
    private String campus_on = "";
    private String campus_off = "";
    private String sch_start = "";
    private String sch_end = "";
    private String sch_vacation = "";
    private String sch_nomi_end = "";
    private String sch_app_end = "";
    private String detailUrl = "";
    private String univ_rank = "";



    private int pg = 1;
    private int recordCountPerPage = 15;
    private int pageSize = 10;


}
