package me.bezgerts.service.word;

import me.bezgerts.domain.Word;
import me.bezgerts.service.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WordService {
    Page<Word> getWords(Pageable pageable);
    void save(Word word);
    Word find(Long id);
    void delete(Word word);
}
