package me.bezgerts.persistence.word;

import me.bezgerts.domain.Word;
import me.bezgerts.persistence.GenericDaoHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class WordDAOHibernateImpl extends GenericDaoHibernateImpl<Word, Long> implements WordDAO {
}
