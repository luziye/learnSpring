package com.luziye.bootluanch.service;

import com.luziye.bootluanch.model.ArticleVo;

import java.util.List;

public interface ArticleRestService {

     ArticleVo saveArticle(ArticleVo article);

     void deleteArticle(Integer id);

     void updateArticle(ArticleVo article);

     ArticleVo getArticle(Integer id);

     List<ArticleVo> getAll();
}