package com.luziye.bootluanch.service;

import com.luziye.bootluanch.jpa.testdb1.Article;
import com.luziye.bootluanch.jpa.testdb1.ArticleRepository;
import com.luziye.bootluanch.model.ArticleVo;
import com.luziye.bootluanch.utils.DozerUtils;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleRestServiceImpl implements  ArticleRestService  {

    //将JPA仓库对象注入
    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private Mapper dozerMapper;

    public ArticleVo saveArticle(ArticleVo article) {

        Article articlePO = dozerMapper.map(article,Article.class);
        articleRepository.save(articlePO);    //保存一个对象到数据库，insert

        return  article;
    }

    @Override
    public void deleteArticle(Integer id) {
        articleRepository.deleteById(id);   //根据id删除1条数据库记录
    }

    @Override
    public void updateArticle(ArticleVo article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleRepository.save(articlePO);   //更新一个对象到数据库，仍然使用save方法
    }

    @Override
    public ArticleVo getArticle(Integer id) {
        Optional<Article> article = articleRepository.findById(id);  //根据id查找一条数据
        return dozerMapper.map(article.get(),ArticleVo.class);
    }

    @Override
    public List<ArticleVo> getAll() {
        List<Article> articleLis = articleRepository.findAll();  //查询article表的所有数据
        return DozerUtils.mapList(articleLis,ArticleVo.class);
    }
}