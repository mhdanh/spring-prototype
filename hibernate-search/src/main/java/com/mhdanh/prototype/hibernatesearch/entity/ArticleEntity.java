package com.mhdanh.prototype.hibernatesearch.entity;

import lombok.*;
import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author danh.mai
 */
@Table(name="article")
@Entity
@Indexed
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericField(sortable = Sortable.YES, searchable = Searchable.YES)
    private Long id;

    @FullTextField
    private String name;

    @GenericField(sortable = Sortable.YES, searchable = Searchable.YES)
    private BigDecimal price;

}
