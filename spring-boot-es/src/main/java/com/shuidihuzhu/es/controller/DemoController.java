package com.shuidihuzhu.es.controller;

import com.shuidihuzhu.es.entity.EsBlog;
import com.shuidihuzhu.es.entity.MysqlBlog;
import com.shuidihuzhu.es.repository.EsBlogRepository;
import com.shuidihuzhu.es.repository.MysqlBlogRepository;
import lombok.Data;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: gehuadong@shuidihuzhu.com
 * @Date: 2020/2/9 11:28
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private MysqlBlogRepository mysqlBlogRepository;

    @Autowired
    private EsBlogRepository esBlogRepository;

    @GetMapping("/getAllByMysql")
    public Object getAllByMysql() {
        List<MysqlBlog> all = mysqlBlogRepository.findAll();
        return all;
    }

    @GetMapping("/getAllByEs")
    public Object getByEs() {
        Iterable<EsBlog> blogRepositoryAll = esBlogRepository.findAll();
        List<EsBlog> list = new ArrayList<>();
        Iterator<EsBlog> iterator = blogRepositoryAll.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

    @PostMapping(value = "/getByParam")
    public Object getByParam(Param param) {
        if (param.env.equals("mysql")) {
            List<MysqlBlog> byParam = mysqlBlogRepository.getByParam(param.keyword);
            return byParam;
        }

        if (param.env.equals("es")) {
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
            boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("title", param.keyword));
            boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("content", param.keyword));
            Page<EsBlog> page = (Page<EsBlog>) esBlogRepository.search(boolQueryBuilder);
            return page.getContent();
        }

        return null;
    }


    @Data
    public static class Param {
        private String keyword;
        private String env;
    }
}
