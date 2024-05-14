package com.hy.univ.gpt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class GptController {
    private final GptService gptService;

    @Autowired
    public GptController(GptService gptService) {
        this.gptService = gptService;
    }

    @PostMapping("/ask")
    public String ask(@RequestBody String prompt) {
        return gptService.ask(prompt);
    }
}