package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *高分电影：(HighScoreFilm)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "HighScoreFilm")
public class HighScoreFilm implements Serializable {

    //HighScoreFilm编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "high_score_film_id")
    private Integer high_score_film_id;
    // 电影名称
    @Basic
    private String movie_title;
    // 别名
    @Basic
    private String alias;
    // 导演
    @Basic
    private String director;
    // 编剧
    @Basic
    private String screenwriter;
    // 演员
    @Basic
    private String performer;
    // 类型
    @Basic
    private String type;
    // 国家
    @Basic
    private String country;
    // 语言
    @Basic
    private String language;
    // 年份
    @Basic
    private String particular_year;
    // 片长
    @Basic
    private String film_length;
    // 上映时间
    @Basic
    private String release_time;
    // 官方网站
    @Basic
    private String official_website;
    // IDMB链接
    @Basic
    private String idmb_link;
    // IDMB评分
    @Basic
    private String idmb_score;
    // 豆瓣评分
    @Basic
    private String douban_score;
    // 获奖情况
    @Basic
    private String awards;
    // 影片海报
    @Basic
    private String movie_poster;
    // 相似电影推荐
    @Basic
    private String similar_film_recommendation;
    // 剧情
    @Basic
    private String plot;
    // 点击数
    @Basic
    private Integer hits;
    // 点赞数
    @Basic
    private Integer praise_len;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
