package me.bezgerts.controller;

import me.bezgerts.domain.Word;
import me.bezgerts.repository.WordRepository;
import me.bezgerts.service.word.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WordRestController {

    @Autowired
    private WordRepository repository;

    @Autowired
    private WordService wordService;

    @RequestMapping(path = "rest/words", method = RequestMethod.GET)
    public Page<Word> getWords(@RequestParam(value = "page", required = false) Integer page,
                           @RequestParam(value = "size", required = false) Integer size,
                           Model model) {

        Page<Word> words = null;
        if (page != null && size != null) {
            words = wordService.getWords(new PageRequest(page, size));
        } else {
            words = wordService.getWords(new PageRequest(0, 100));
        }
        return words;
    }
}
