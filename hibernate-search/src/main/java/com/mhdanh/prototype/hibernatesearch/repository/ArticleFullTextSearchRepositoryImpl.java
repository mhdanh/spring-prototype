package com.mhdanh.prototype.hibernatesearch.repository;

import com.mhdanh.prototype.hibernatesearch.dto.ArticleSearchParametters;
import com.mhdanh.prototype.hibernatesearch.entity.ArticleEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.engine.search.sort.dsl.SortOrder;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.Duration;
import java.util.List;

/**
 * @author danh.mai
 */
@RequiredArgsConstructor
public class ArticleFullTextSearchRepositoryImpl implements  ArticleFullTextSearchRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Page<ArticleEntity> findAll(ArticleSearchParametters filter, Pageable pageable) {
        int size = pageable.getPageSize();
        int offset = (int) pageable.getOffset();
        SearchSession searchSession = Search.session(entityManager);

        SearchResult<ArticleEntity> result = searchSession.search(ArticleEntity.class)
                .where(searchFactory -> searchFactory.matchAll())
                .fetch(offset, size);

        long totalHitCount = result.total().hitCount();
        List<ArticleEntity> entities = result.hits();
        return new PageImpl<>(entities, pageable, totalHitCount);
    }
}
