//package com.luziye.bootluanch.dao;
//
//
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@Repository
//public class ArticleJDBCDAO {
//
//    @Resource
//    private JdbcTemplate primaryJdbcTemplate;
//
//
//
//    //保存文章
//    public void save(Article2 article,JdbcTemplate jdbcTemplate) {
//        //jdbcTemplate.update适合于insert 、update和delete操作；
//        jdbcTemplate.update("INSERT INTO article(author, title,content,create_time) values(?, ?, ?, ?)",
//                article.getAuthor(),
//                article.getTitle(),
//                article.getContent(),
//                article.getCreateTime());
//
//    }
//
//    //删除文章
//    public void deleteById(Integer id,JdbcTemplate jdbcTemplate) {
//        //jdbcTemplate.update适合于insert 、update和delete操作；
//        jdbcTemplate.update("DELETE FROM article WHERE id = ?",new Object[]{id});
//
//    }
//
//    //更新文章
//    public void updateById(Article2 article,JdbcTemplate jdbcTemplate) {
//        //jdbcTemplate.update适合于insert 、update和delete操作；
//        jdbcTemplate.update("UPDATE article SET author = ?, title = ? ,content = ?,create_time = ? WHERE id = ?",
//                article.getAuthor(),
//                article.getTitle(),
//                article.getContent(),
//                article.getCreateTime(),
//                article.getId());
//
//    }
//
//    //根据id查找文章
//    public Article2 findById(Integer id,JdbcTemplate jdbcTemplate) {
//        //queryForObject用于查询单条记录返回结果
//        return (Article2) jdbcTemplate.queryForObject("SELECT * FROM article WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper(Article2.class));
//    }
//
//    //查询所有
//    public List<Article2> findAll(JdbcTemplate jdbcTemplate){
//        //query用于查询结果列表
//        return (List<Article2>) jdbcTemplate.query("SELECT * FROM article ",  new BeanPropertyRowMapper(Article2.class));
//    }
//
//
//}