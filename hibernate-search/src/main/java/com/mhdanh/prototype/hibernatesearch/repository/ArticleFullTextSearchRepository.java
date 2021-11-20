package com.mhdanh.prototype.hibernatesearch.repository;

import com.mhdanh.prototype.hibernatesearch.dto.ArticleSearchParametters;
import com.mhdanh.prototype.hibernatesearch.entity.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author danh.mai
 */
public interface ArticleFullTextSearchRepository {

    Page<ArticleEntity> findAll(ArticleSearchParametters filter, Pageable pageable);

}
