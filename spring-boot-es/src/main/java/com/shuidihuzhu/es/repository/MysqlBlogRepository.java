package com.shuidihuzhu.es.repository;

import com.shuidihuzhu.es.entity.MysqlBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author: JoJo
 * @Description: ${description}
 * @Date: 2020/2/9 11:27
 */
public interface MysqlBlogRepository extends JpaRepository<MysqlBlog, Integer> {

    @Query("select e from  MysqlBlog e where e.title like concat('%', :keyword, '%') or e.content like concat('%', :keyword, '%')")
    List<MysqlBlog> getByParam(@Param("keyword") String keyword);
}
