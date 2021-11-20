package com.mhdanh.prototype.hibernatesearch.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author danh.mai
 */
@Setter
@Getter
public class ArticleSearchParametters {
    private Long id;
    private String name;
    private BigDecimal price;
}
