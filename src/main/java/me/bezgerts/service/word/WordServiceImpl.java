package me.bezgerts.service.word;

import me.bezgerts.domain.Word;
import me.bezgerts.persistence.GenericDAO;
import me.bezgerts.persistence.word.WordDAO;
import me.bezgerts.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WordServiceImpl extends GenericServiceImpl<Word, Long> implements WordService {

    private WordDAO wordDAO;

    public WordServiceImpl() {}

    @Autowired
    public WordServiceImpl(@Qualifier("wordDAOHibernateImpl") GenericDAO<Word, Long> genericDAO){
        super(genericDAO);
        this.wordDAO = (WordDAO) genericDAO;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Integer getLastPageNumber(Integer pageSize) {
        return wordDAO.getLastPageNumber(pageSize);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Long getCountOfAllWords() {
        return wordDAO.getCountOfAllWords();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Word> getWordsWithPagination(Integer firstResult, Integer pageSize) {
        return wordDAO.getWordsWithPagination(firstResult, pageSize);
    }
}