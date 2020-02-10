package com.shuidihuzhu.es.entity;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: gehuadong@shuidihuzhu.com
 * @Date: 2020/2/9 11:17
 */
@Data
@Entity
@Table(name = "blog")
public class MysqlBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String author;
    private String content;
    private Date createTime;
    private Date updateTime;
}
