package com.mhdanh.prototype.elasticsearch.repository;

import com.mhdanh.prototype.elasticsearch.entity.ArticleEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author danh.mai
 */
public interface ArticleRepository extends ElasticsearchRepository<ArticleEntity, String> {

    List<ArticleEntity> findAllByName(String name);

}
