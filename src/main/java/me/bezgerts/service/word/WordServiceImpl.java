package me.bezgerts.service.word;

import me.bezgerts.domain.Word;
import me.bezgerts.repository.WordRepository;
import me.bezgerts.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WordServiceImpl implements WordService {

    public WordServiceImpl() {}

    @Autowired
    private WordRepository wordRepository;

    @Override
    public Page<Word> getWords(Pageable pageable) {
        Page<Word> words = wordRepository.findAll(pageable);
        return words;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Word word) {
        wordRepository.save(word);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Word find(Long id) {
        return wordRepository.findOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Word word) {
        wordRepository.delete(word);
    }
}