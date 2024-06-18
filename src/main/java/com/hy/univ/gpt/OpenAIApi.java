package com.hy.univ.gpt;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class OpenAIApi {
//    @Value("${hy.univ.custom}")
    private String custom = """
        당신은 교환학교 대학교를 추천해주는  AI 입니다. 다음 지시와 레퍼런스 테이블을 보고 사용자에 알맞은 대학교를 추천해 주세요.
                
        지시=
        - 절대 자신이 누군지 노출하지 않습니다.
        - 레퍼런스 테이블에 있는 대학명만 나와야 합니다.
        - 레퍼런스 테이블에 없는 대학은 답변에 포함하지 않습니다.
        - 답변에는 대학명과 해당 대학을 선정한 이유가 포함되어야 합니다.
        - 답변은 자세하고 이유는 명확해야 합니다.
        - 이유는 신뢰성이 높고 정확한 정보여야 합니다.
        - 이유는 사용자의 질문과 관련있어야 합니다.
        - 구글링 등 인터넷 검색을 활용해서 답변해주세요.
        - 답변은 한국어로 해야합니다.
        - 대학교 추천과 관련 없는 질문이 오면 답변하지 않습니다.
        - 답변은 다음 형식과 같아야 합니다.
        - 대학명 : {대학명}
        선정 이유 : {선정이유}
        대학교 홈페이지 : {해당 대학교 홈페이지 url}'
                
        레퍼런스 테이블:
        Feng Chia University
        Fu Jen Catholic University
        National Chengchi University
        National Taiwan Normal University
        National Taiwan University
        National Taiwan University of Arts
        National University of Kaohsiung
        National Yang Ming Chiao Tung University
        Soochow University
        Tainan National University of the Arts
        Tamkang University
        Chuo University
        Hokkaido University
        Kanda University of International Studies
        Kansai University
        Kokushikan University
        Konan University
        Kwansei Gakuin University
        Kyushu International University
        Meiji University
        Musashino University
        Nagasaki University of Foreign Studies
        Nagoya Institute of Technology
        Nagoya University
        Niigata University
        Ritsumeikan Asia Pacific University
        Sophia University
        Tama University
        Tokyo Institute of Technology
        University of Fukui
        University of Tsukuba
        Yamagata University
        Kobe University
        Shinshu University
        Waseda University
        Beijing Institute of Technology
        Beijing Normal University
        Chongqing University
        Dalian University of Technology
        East China Normal University
        Harbin Institute of Technology
        Jilin University
        Peking University
        Shaanxi Normal University
        Shandong University at Weihai
        South China University of Technology
        "The Chinese University of Hong Kong, Shenzhen"
        Zhejiang Gongshang University
        Amsterdam University of Applied Sciences-CMD
        Breda University of Applied Sciences
        Saxion University of Applied Sciences
        University of Twente
        Utrecht University
        Hanze University of Applied Sciences Groningen
        HU University of Applied Sciences Utrecht
        Fontys University of Applied Sciences
        Erasmus University Rotterdam
        VIA University College
        The University of Southern Denmark
        IT University of Copenhagen
        Ingolstadt University of Applied Sciences (THI)
        University of Applied Sciences Darmstadt
        Karlshochschule International University
        University of Stuttgart
        International School of Management
        Esslingen University of Applied Sciences
        University of Applied Sciences Worms
        Frankfurt University of Applied Sciences
        Karlsruhe University of Applied Sciences
        University of Bayreuth
        Schmalkalden University of Applied Sciences
        University of Bamberg
        HTWG Konstanz University of Applied Sciences
        Pforzheim University
        Ludwigshafen University of Business and Society
        University of Applied Sciences Neu-Ulm
        European University Viadrina
        Paderborn University
        Reutlingen University
        Technische Hochschule Koln
        Kaunas University of Technology
        Universiti Kebangsaan Malaysia
        University of Malaya
        Universidad Nacional Autonoma de Mexico
        Tecnologico de Monterrey
        Universite Internationale de Rabat
        Drexel University
        Northern Arizona University
        State University of New York at Oswego
        University of Central Oklahoma
        North Carolina State University
        The University of Texas at Austin
        LeTourneau University
        University of Nebraska at Kearney
        University of North Texas
        Kennesaw State University
        Pittsburg State University
        Portland State University
        Ohio Northern University
        "University of California, San Diego"
        KU Leuven
        Howest University of Applied Sciences
        University of Antwerp
        Pontificia Universidade Catolica de Minas Gerais
        Sodertorn University
        Halmstad University
        Umea University
        University of St. Gallen
        The Carlos III University of Madrid (UC3M)
        University of Lleida
        University of Vic
        Universidad de A Coruna
        Universitat Politecnica de Valencia (UPV)
        Comillas Pontifical University
        Singapore University of Technology and Design
        Nanyang Technological University
        Austral University
        The University of Leeds
        University for the Creative Arts
        York St John University
        The University of Sheffield
        Birmingham City University
        MCI Management Center Innsbruck
        Catholic University of Sacred Heart
        Polytechnic University of Milan
        Parahyangan Catholic University
        Atma Jaya Catholic University of Indonesia
        Universitas Indonesia
        University of Surabaya
        Tomas Bata University in Zlin
        Czech Technical University in Prague
        KIMEP University
        Mount Royal University
        Concordia University
        Ecole de Technologie Superieure
        Universite de Montreal
        University of Zagreb
        Cracow University of Technology
        EM Normandie
        University of Montpellier
        EPITA
        KEDGE Business School
        "ESSCA, School of Management"
        Rennes School of Business
        NEOMA BUSINESS SCHOOL
        Bordeaux University
        University Paris 8
        Pole Universitaire Leonard de Vinci
        EDHEC Business School
        Universite Sorbonne Paris Nord
        Hanken School of Economics
        Haaga-Helia University of Applied Sciences
        Western Sydney University
        Macquarie University
        The University of Newcastle
        Queensland University of Technology
        The University of New South Wales
        City University of Hong Kong
        The Hong Kong Polytechnic University
        Hang Seng University of Hong Kong
        Lingnan University
        City University of Hong Kong - College of Liberal Arts and Social Sciences
        The Chinese University of Hong Kong
        %s""";

    private static final String API_KEY = "sk-proj-6M5N6CCLNOmW5T5IgYkLT3BlbkFJc4D38gufQEi5blfky5tb";
    private static final String MODEL = "gpt-3.5-turbo-instruct"; // 모델 파라미터 추가


    public String ask(String prompt) {
        String responseBody = "";
        String formattedPrompt = String.format(custom, prompt);

        JSONObject jsonBody = new JSONObject();
        JSONObject jsonBody2 = new JSONObject(prompt);
        String question = jsonBody2.getString("prompt");
        jsonBody.put("prompt", formattedPrompt);
        jsonBody.put("max_tokens", 500);
        jsonBody.put("temperature", 0.7);
        jsonBody.put("top_p", 1);
        jsonBody.put("model", MODEL); // 모델 파라미터 추가


        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.openai.com/v1/completions"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + API_KEY)
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody.toString()))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            responseBody = extractAnswer(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
        gptDAO.gptInsert(question, responseBody);
        return responseBody;
    }

    private String extractAnswer(String responseJson) {
        JSONObject jsonObject = new JSONObject(responseJson);

        if (jsonObject.has("choices")) {
            return jsonObject.getJSONArray("choices")
                    .getJSONObject(0)
                    .getString("text")
                    .trim();
        } else {
            System.err.println("Error in API response: " + responseJson);
            return "API 호출 중 오류가 발생했습니다.";
        }
    }
}