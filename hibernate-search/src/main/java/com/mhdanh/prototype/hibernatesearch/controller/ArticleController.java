package com.mhdanh.prototype.hibernatesearch.controller;

import com.mhdanh.prototype.hibernatesearch.dto.ArticleSearchParametters;
import com.mhdanh.prototype.hibernatesearch.entity.ArticleEntity;
import com.mhdanh.prototype.hibernatesearch.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author danh.mai
 */
@RestController
@RequestMapping("api/v1/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleRepository articleRepository;

    @PostMapping
    public ArticleEntity createArticle(@RequestBody ArticleEntity article) {
        articleRepository.save(article);
        return article;
    }

    @GetMapping
    public List<ArticleEntity> findArticle(
            ArticleSearchParametters filter,
            Pageable pageable
    ) {
        return articleRepository.findAll(filter, pageable).getContent();
    }

}
