package me.bezgerts.controller;

import me.bezgerts.domain.Word;
import me.bezgerts.service.word.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WordController {

    @Autowired(required = true)
    private WordService wordService;

    @RequestMapping(path = "/words", method = RequestMethod.GET)
    public String getAllWords(Model model) {
        model.addAttribute("words", wordService.getAll());
        return "words/words";
    }

    @RequestMapping(path = "/words/create", method = RequestMethod.GET)
    public String createWord(Model model) {
        model.addAttribute("word", new Word());
        return "words/create";
    }

    @RequestMapping(path = "/words", method = RequestMethod.POST)
    public String createWord(Word word) {
        wordService.saveOrUpdate(word);
        return "redirect:/words";
    }

    @RequestMapping(path = "/words/edit/{id}", method = RequestMethod.GET)
    public String editWord(Model model, @PathVariable(value = "id") String id) {
        model.addAttribute("word", wordService.get(Long.valueOf(id)));
        return "words/edit";
    }

    @RequestMapping(path = "/words/delete/{id}", method = RequestMethod.GET)
    public String deleteWord(@PathVariable(name = "id") String id) {;
        Word word = wordService.get(Long.valueOf(id));
        wordService.remove(word);
        return "redirect:/words";
    }
}
