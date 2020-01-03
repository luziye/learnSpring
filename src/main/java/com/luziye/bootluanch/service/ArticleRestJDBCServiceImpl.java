//package com.luziye.bootluanch.service;
//
//import com.luziye.bootluanch.dao.Article2;
//import com.luziye.bootluanch.dao.ArticleJDBCDAO;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@Slf4j
//@Service
//public class ArticleRestJDBCServiceImpl implements ArticleRestService {
//
//    @Resource
//    ArticleJDBCDAO articleJDBCDAO;
//
//    @Resource
//    JdbcTemplate primaryJdbcTemplate;
//    @Resource
//    JdbcTemplate secondaryJdbcTemplate;
//
//    @Transactional
//    @Override
//    public Article2 saveArticle(Article2 article) {
//        articleJDBCDAO.save(article, primaryJdbcTemplate);
//
//        articleJDBCDAO.save(article, secondaryJdbcTemplate);
//        int a = 2/0;    //人为制造一个被除数为0的异常
//        return article;
//    }
//
//    @Override
//    public void deleteArticle(Integer id) {
//        articleJDBCDAO.deleteById(id, primaryJdbcTemplate);
//    }
//
//    @Override
//    public void updateArticle(Article2 article) {
//        articleJDBCDAO.updateById(article, primaryJdbcTemplate);
//    }
//
//    @Override
//    public Article2 getArticle(Integer id) {
//        return articleJDBCDAO.findById(id, primaryJdbcTemplate);
//
//    }
//
//    @Override
//    public List<Article2> getAll() {
//        return articleJDBCDAO.findAll(primaryJdbcTemplate);
//    }
//}
