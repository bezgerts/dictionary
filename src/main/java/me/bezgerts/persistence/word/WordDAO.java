package me.bezgerts.persistence.word;

import me.bezgerts.domain.Word;
import me.bezgerts.persistence.GenericDAO;

import java.util.List;

public interface WordDAO extends GenericDAO<Word, Long> {
    Integer getLastPageNumber(Integer pageSize);
    Long getCountOfAllWords();
    List<Word> getWordsWithPagination(Integer firstResult, Integer pageSize);
}
