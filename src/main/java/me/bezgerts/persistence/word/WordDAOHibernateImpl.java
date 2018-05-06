package me.bezgerts.persistence.word;

import me.bezgerts.domain.Word;
import me.bezgerts.persistence.GenericDaoHibernateImpl;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WordDAOHibernateImpl extends GenericDaoHibernateImpl<Word, Long> implements WordDAO {
    @Override
    public Integer getLastPageNumber(Integer pageSize) {
        Query query = currentSession().createQuery("select count (w.id) from Word w");
        Long countResults = (Long) query.uniqueResult();
        Integer lastPageNumber = (int) (Math.ceil((double) countResults / (double) pageSize));
        return lastPageNumber;
    }

    @Override
    public Long getCountOfAllWords() {
        Query query = currentSession().createQuery("select count (w.id) from Word w");
        return  (Long) query.uniqueResult();
    }

    @Override
    public List<Word> getWordsWithPagination(Integer firstResult, Integer pageSize) {
        Query query = currentSession().createQuery("from Word");
        query.setFirstResult(firstResult);
        query.setMaxResults(pageSize);
        return query.list();
    }
}
