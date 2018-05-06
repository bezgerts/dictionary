package me.bezgerts.service.word;

import me.bezgerts.domain.Word;
import me.bezgerts.service.GenericService;

import java.util.List;

public interface WordService extends GenericService<Word, Long> {
    Integer getLastPageNumber(Integer pageSize);
    Long getCountOfAllWords();
    List<Word> getWordsWithPagination(Integer firstResult, Integer pageSize);
}
