package com.example.tikatest;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import java.io.IOException;
import java.util.Map;

@SpringBootTest
class TikaTestApplicationTests {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 创建索引，创建映射
     */
    @Test
    public void testIndexAndMapping() throws IOException {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("product");
        createIndexRequest.mapping("""
                        {
                            "properties": {
                              "title":{
                                "type":"keyword"
                              },
                              "price":{
                                "type":"double"
                              },
                              "created_at":{
                                "type": "text",
                                "analyzer": "ik_max_word"
                              },
                              "description":{
                                "type": "text",
                                "analyzer": "ik_max_word"
                              }
                            }
                        }
                """, XContentType.JSON);
        CreateIndexResponse createIndexResponse =
                restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println("createIndexResponse = " + createIndexResponse.isAcknowledged());
    }

    /**
     * 删除索引
     */
    @Test
    public void testDeleteIndex() throws IOException {
        AcknowledgedResponse acknowledgedResponse = restHighLevelClient.indices().delete(new DeleteIndexRequest("product"), RequestOptions.DEFAULT);
        System.out.println("acknowledgedResponse = " + acknowledgedResponse.isAcknowledged());
    }

    /**
     * 创建索引，创建映射
     */
    @Test
    public void testAddItem() throws IOException {
        IndexRequest indexRequest = new IndexRequest("product");
        indexRequest.id("100")
                .source("""
                        {
                            "title":"谷歌手机",
                            "price":13992,
                            "created_at":"2022-01-01 12:00:00",
                            "description":"哈哈哈哈哈"
                        }
                """,XContentType.JSON);
        restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
    }

    /**
     * update item
     */
    @Test
    public void testUpdateItem() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest("product", "1");
        updateRequest.doc("""
                        {
                            "title":"小米手机-偶偶偶",
                            "price":1999,
                            "created_at":"2023-01-01 12:00:00",
                            "description":"小米手机是一款好手机"
                        }
                """,XContentType.JSON);
        restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
    }

    /**
     * 删除文档item
     */
    @Test
    public void testDeleteItem() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("product", "1");
        DeleteResponse deleteResponse = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println("deleteResponse = " + deleteResponse.status());
    }

    /**
     * id查询文档item
     */
    @Test
    public void testGetItem() throws IOException {
         GetRequest getRequest = new GetRequest("product", "1");
         GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
         System.out.println("getResponse = " + getResponse.getSourceAsString());
    }

    /**
     * 查询所有文档item
     */
    @Test
    public void testGetAllItem() throws IOException {
        SearchRequest searchRequest = new SearchRequest("product");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        SearchResponse searchResponse =
                restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println("searchResponse = " + searchResponse.getHits().getHits());
        SearchHit[] hits = searchResponse.getHits().getHits();
        for (SearchHit hit : hits) {
            System.out.println("hit = " + hit.getSourceAsString());
        }
    }
    static int time = 0;
    /**
     * 抽取共同方法
     */
    public void query(QueryBuilder queryBuilder, int from, int size) throws IOException {
        SearchRequest searchRequest = new SearchRequest("product");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(queryBuilder).from(from).size(size);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse =
                restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] hits = searchResponse.getHits().getHits();
        for (SearchHit hit : hits) {
            System.out.println(time+":hit = " + hit.getSourceAsString()+",分数："+hit.getScore());
        }
        time++;
    }

    /**
     * 关键词查询文档item
     */
    @Test
    public void testGetItemByKeyword() throws IOException {
        // term 查询
        QueryBuilder queryBuilder = QueryBuilders.termQuery("title", "小米手机");
        query(queryBuilder,0,5);
        // range 查询
        QueryBuilder queryBuilder1 = QueryBuilders.rangeQuery("price").gte(0).lte(2000);
        query(queryBuilder1,0,5);
        // prefix 查询
        QueryBuilder queryBuilder2 = QueryBuilders.prefixQuery("title", "小米");
        query(queryBuilder2,0,5);
        // wildcard 查询
        QueryBuilder queryBuilder3 = QueryBuilders.wildcardQuery("title", "小米*");
        query(queryBuilder3,0,5);
        // fuzzy 查询
        QueryBuilder queryBuilder4 = QueryBuilders.fuzzyQuery("title", "小米");
        query(queryBuilder4,0,5);
        // match 查询
        QueryBuilder queryBuilder5 = QueryBuilders.matchQuery("title", "小米手机");
        query(queryBuilder5,0,5);
        // multi_match 查询
//        QueryBuilder queryBuilder6 = QueryBuilders.multiMatchQuery("小米手机", "title", "price");
//        query(queryBuilder6,0,5);
    }

    /**
     * 分页，高亮 查询文档item
     */
    @Test
    public void testGetItemByPage() throws IOException {
        SearchRequest searchRequest = new SearchRequest("product");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        // 高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.requireFieldMatch(false)
                .field("title")
                .field("description")
                .preTags("<span style='color:red'>")
                .postTags("</span>");
        sourceBuilder.query(QueryBuilders.termQuery("description", "手机"))
                .highlighter(highlightBuilder)
                .from(0)
                .size(5)
                .sort("price", SortOrder.DESC)
                .fetchSource(new String[]{},new String[]{"created_at"})
                .highlighter(highlightBuilder);
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse =
                restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println("符合条件总数："+searchResponse.getHits().getTotalHits());
        System.out.println("获取文档最大分数："+searchResponse.getHits().getMaxScore());
        SearchHit[] hits = searchResponse.getHits().getHits();
        for (SearchHit hit : hits) {
            System.out.println("id = "+hit.getId()+" hit = " + hit.getSourceAsString());
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            if(highlightFields.containsKey("description")){
                System.out.println("高亮字段："+highlightFields.get("description").getFragments()[0].toString());
            }
            if(highlightFields.containsKey("title")){
                System.out.println("高亮字段："+highlightFields.get("title").getFragments()[0].toString());
            }
        }

    }



}
