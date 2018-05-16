package me.bezgerts.controller;

import me.bezgerts.domain.Word;
import me.bezgerts.service.word.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WordController {

    @Autowired(required = true)
    private WordService wordService;

    @RequestMapping(path = "/words", method = RequestMethod.GET)
    public String getWords(@RequestParam(value = "page", required = false) Integer page,
                           @RequestParam(value = "size", required = false) Integer size,
                           Model model) {

        if (page != null && size != null) {
            Page<Word> words = wordService.getWords(new PageRequest(page, size));
            model.addAttribute("words", words);
        } else {
            Page<Word> words = wordService.getWords(new PageRequest(0, 100));
            model.addAttribute("words", wordService.getWords(new PageRequest(0, 100)));
        }

        return "words/words";
    }

    @RequestMapping(path = "/words/create", method = RequestMethod.GET)
    public String createWord(Model model) {
        model.addAttribute("word", new Word());
        return "words/create";
    }

    @RequestMapping(path = "/words", method = RequestMethod.POST)
    public String createWord(Word word) {
        wordService.save(word);
        return "redirect:/words";
    }

    @RequestMapping(path = "/words/edit/{id}", method = RequestMethod.GET)
    public String editWord(Model model, @PathVariable(value = "id") String id) {
        model.addAttribute("word", wordService.find(Long.valueOf(id)));
        return "words/edit";
    }

    @RequestMapping(path = "/words/delete/{id}", method = RequestMethod.GET)
    public String deleteWord(@PathVariable(name = "id") String id) {;
        Word word = wordService.find(Long.valueOf(id));
        wordService.delete(word);
        return "redirect:/words";
    }
}
