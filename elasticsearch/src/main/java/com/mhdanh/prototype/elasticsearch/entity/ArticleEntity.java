package com.mhdanh.prototype.elasticsearch.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author danh.mai
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "article")
public class ArticleEntity {

    @Id
    private String id;
    private String name;

}
