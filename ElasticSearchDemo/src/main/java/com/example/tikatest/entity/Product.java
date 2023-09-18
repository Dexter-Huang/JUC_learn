package com.example.tikatest.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Setter
@Getter
@Accessors(chain = true)
@ToString
@Document(indexName = "product", shards = 1, replicas = 0,createIndex = true)
public class Product {
    @Id
    private Integer id;
    @Field(type = FieldType.Keyword)
    private String title;
    @Field(type = FieldType.Float)
    private Double price;
    @Field(analyzer = "ik_max_word", searchAnalyzer = "ik_max_word",type = FieldType.Text)
    private String description;

}
