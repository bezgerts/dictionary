package me.bezgerts.repository;

import me.bezgerts.domain.Word;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<Word, Long> {
    Page<Word> findAll(Pageable pageable);
}
