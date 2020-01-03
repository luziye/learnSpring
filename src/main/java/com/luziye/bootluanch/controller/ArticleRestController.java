package com.luziye.bootluanch.controller;

import com.luziye.bootluanch.jpa.testdb1.ArticleRepository;
import com.luziye.bootluanch.exception.AjaxResponse;
//import com.luziye.bootluanch.dao.Article2;
import com.luziye.bootluanch.model.ArticleVo;
import com.luziye.bootluanch.service.ArticleMybatisRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {
    @Resource(name = "articleMybatisRestServiceImpl")
    ArticleMybatisRestService articleMybatisRestService;
    @Resource
    ArticleRepository articleRepository;
    //增加一篇Article ，使用POST方法
    @RequestMapping(value = "/article", method = RequestMethod.POST, produces = "application/json")
    public AjaxResponse saveArticle(@RequestBody ArticleVo article) {
        //因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
//        log.info("saveArticle：{}", article);
        articleMybatisRestService.saveArticle(article);
        return AjaxResponse.success(article);
    }


    //删除一篇Article，使用DELETE方法，参数是id
    @RequestMapping(value = "/article/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public AjaxResponse deleteArticle(@PathVariable Integer id) {
        articleMybatisRestService.deleteArticle(id);
        return AjaxResponse.success(id);
    }

    //更新一篇Article，使用PUT方法，以id为主键进行更新
    @RequestMapping(value = "/article/{id}", method = RequestMethod.PUT, produces = "application/json")
    public AjaxResponse updateArticle(@PathVariable Integer id, @Valid @RequestBody ArticleVo article) {
        article.setId(id);
        articleMybatisRestService.updateArticle(article);
        log.info("updateArticle：{}", article);
        return AjaxResponse.success(article);
    }

    //获取一篇Article，使用GET方法
    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET, produces = "application/json")
    public AjaxResponse getArticle(@PathVariable Integer id) {
//        Article2.ReaderBean readerBean=Article2.ReaderBean.builder().age(10).name("ben").build();
//        Article2.ReaderBean readerBean2=Article2.ReaderBean.builder().age(20).name("alice").build();
//        List<Article2.ReaderBean> list=new ArrayList<>();
//        list.add(readerBean);
//        list.add(readerBean2);
//
//        //使用lombok提供的builder构建对象
//        Article2 article2 = Article2.builder()
//                .id(1)
//                .author("lzy")
//                .content("spring boot 2.深入浅出")
//                .createTime("")
//                .reader(list)
//                .title("t1").build();
        return AjaxResponse.success(articleMybatisRestService.getArticle(id));
    }

    @RequestMapping(value = "/article/", method = RequestMethod.GET, produces = "application/json")
    public AjaxResponse getAllArticle() {
        List<ArticleVo> articles=articleMybatisRestService.getAll();
        return AjaxResponse.success(articles);
    }

}