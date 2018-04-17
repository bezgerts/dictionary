package me.bezgerts.service.word;

import me.bezgerts.domain.Word;
import me.bezgerts.persistence.GenericDAO;
import me.bezgerts.persistence.word.WordDAO;
import me.bezgerts.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl extends GenericServiceImpl<Word, Long> implements WordService {

    private WordDAO wordDAO;

    public WordServiceImpl() {}

    @Autowired
    public WordServiceImpl(@Qualifier("wordDAOHibernateImpl") GenericDAO<Word, Long> genericDAO){
        super(genericDAO);
        this.wordDAO = (WordDAO) genericDAO;
    }
}