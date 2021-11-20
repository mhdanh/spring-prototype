package com.mhdanh.prototype.hibernatesearch.repository;

import com.mhdanh.prototype.hibernatesearch.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author danh.mai
 */
@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long>, ArticleFullTextSearchRepository {

}
