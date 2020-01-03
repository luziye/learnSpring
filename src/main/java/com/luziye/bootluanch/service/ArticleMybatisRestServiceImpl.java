package com.luziye.bootluanch.service;

import com.luziye.bootluanch.generator.Article;
import com.luziye.bootluanch.generator.ArticleDao;
import com.luziye.bootluanch.model.ArticleVo;
import com.luziye.bootluanch.utils.DozerUtils;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleMybatisRestServiceImpl implements ArticleMybatisRestService {
    @Resource
    protected Mapper dozerMapper;
    @Resource
    private ArticleDao articleDao;
    @Override
    public ArticleVo saveArticle(ArticleVo article) {
        Article articlePo=dozerMapper.map(article, Article.class);
        articleDao.insert(articlePo);
        return null;
    }

    @Override
    public void deleteArticle(Integer id) {
        articleDao.deleteByPrimaryKey(id);
    }

    @Override
    public void updateArticle(ArticleVo article) {
        articleDao.updateByPrimaryKeySelective(dozerMapper.map(article, Article.class));
    }

    @Override
    public ArticleVo getArticle(Integer id) {
        return dozerMapper.map(articleDao.selectByPrimaryKey(id),ArticleVo.class);
    }

    @Override
    public List<ArticleVo> getAll() {
        List<Article> articles=articleDao.selectByExample(null);
        return DozerUtils.mapList(articles,ArticleVo.class);
    }
}
