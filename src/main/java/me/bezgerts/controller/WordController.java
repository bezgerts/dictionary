package me.bezgerts.controller;

import me.bezgerts.domain.Word;
import me.bezgerts.service.word.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WordController {

    @Autowired(required = true)
    private WordService wordService;

    @RequestMapping(path = "/words", method = RequestMethod.GET)
    public String getAllWords(@RequestParam(value = "firstResult", required = false) Integer firstResult,
                              @RequestParam(value = "pageSize", required = false) Integer pageSize,
                              Model model) {

        if (firstResult != null && pageSize != null) {
            model.addAttribute("words", wordService.getWordsWithPagination(firstResult, pageSize));
            model.addAttribute("lastPageNumber", wordService.getLastPageNumber(pageSize));
        } else {
            model.addAttribute("words", wordService.getWordsWithPagination(0, 10));
            model.addAttribute("lastPageNumber", wordService.getLastPageNumber(10));
        }

        model.addAttribute("countOfAllWords", wordService.getCountOfAllWords());
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
