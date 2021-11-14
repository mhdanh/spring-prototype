package com.mhdanh.prototype.elasticsearch.controller;

import com.mhdanh.prototype.elasticsearch.entity.ArticleEntity;
import com.mhdanh.prototype.elasticsearch.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author danh.mai
 */
@RestController
@RequestMapping("api/v1/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleRepository articleRepository;

    @GetMapping
    public List<ArticleEntity> findAll(@RequestParam(value = "name", required = false) String name) {
        if(StringUtils.hasText(name)) {
            return articleRepository.findAllByName(name);
        }
        return StreamSupport.stream(articleRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @PostMapping
    public ArticleEntity createArticle(@RequestBody ArticleEntity entity) {
        articleRepository.save(entity);
        return entity;
    }

    @DeleteMapping("{articleId}")
    public ResponseEntity deleteArticle(@PathVariable("articleId") Long articleId) {
        return ResponseEntity.noContent().build();
    }



}
