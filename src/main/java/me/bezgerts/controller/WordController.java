package me.bezgerts.controller;

import me.bezgerts.domain.Word;
import me.bezgerts.service.word.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WordController {

    @Autowired
    private WordService wordService;

    @GetMapping("/word")
    public String word() {
        Word word = new Word();
        word.setWord("asdasdasd");
        wordService.add(word);
        return "home";
    }
}
