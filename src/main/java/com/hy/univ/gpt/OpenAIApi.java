package com.hy.univ.gpt;

import com.mysql.cj.xdevapi.JsonParser;
import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OpenAIApi {
    private static final String API_KEY = "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";
    private static final String MODEL = "gpt-3.5-turbo-instruct"; // 모델 파라미터 추가


    public String ask(String prompt) {
        String responseBody = "";
        String formattedPrompt = String.format("다음에 해당하는 대학교를 추천해주세요. 해외 대학이어야 하고, 해당 대학을 추천한 이유와 해당 대학의 홈페이지 링크도 첨부해주세요. 링크는 클릭할 수 있어야 합니다. 답변은 한국어로 해주세요.: %s", prompt);

        JSONObject jsonBody = new JSONObject();
        JSONObject jsonBody2 = new JSONObject(prompt);
        String a = jsonBody2.getString("prompt");
        jsonBody.put("prompt", formattedPrompt);
        jsonBody.put("max_tokens", 500);
        jsonBody.put("n", 1);
        jsonBody.put("temperature", 0.7);
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
        gptDAO.gptInsert(a, responseBody);
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