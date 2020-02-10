package com.shuidihuzhu.es.repository;

import com.shuidihuzhu.es.entity.EsBlog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author: gehuadong@shuidihuzhu.com
 * @Date: 2020/2/9 12:29
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, Integer> {
}
