package com.luziye.bootluanch.controller;

import com.luziye.bootluanch.dao.AjaxResponse;
import com.luziye.bootluanch.dao.Article;
import com.luziye.bootluanch.dao.Article2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {

    //增加一篇Article ，使用POST方法
    @RequestMapping(value = "/article", method = RequestMethod.POST, produces = "application/json")
    public AjaxResponse saveArticle(@RequestBody Article2 article2) {
        //因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
        log.info("saveArticle：{}", article2);
        return AjaxResponse.success(article2);
    }


    //删除一篇Article，使用DELETE方法，参数是id
    @RequestMapping(value = "/article/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public AjaxResponse deleteArticle(@PathVariable Integer id) {
        log.info("deleteArticle：{}", id);
        return AjaxResponse.success(id);
    }

    //更新一篇Article，使用PUT方法，以id为主键进行更新
    @RequestMapping(value = "/article/{id}", method = RequestMethod.PUT, produces = "application/json")
    public AjaxResponse updateArticle(@PathVariable Integer id, @RequestBody Article2 article) {
        article.setId(id);
        log.info("updateArticle：{}", article);
        return AjaxResponse.success(article);
    }

    //获取一篇Article，使用GET方法
    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET, produces = "application/json")
    public AjaxResponse getArticle(@PathVariable Integer id) {
        Article2.ReaderBean readerBean=Article2.ReaderBean.builder().age(10).name("ben").build();
        Article2.ReaderBean readerBean2=Article2.ReaderBean.builder().age(20).name("alice").build();
        List<Article2.ReaderBean> list=new ArrayList<>();
        list.add(readerBean);
        list.add(readerBean2);

        //使用lombok提供的builder构建对象
        Article2 article2 = Article2.builder()
                .id(1)
                .author("lzy")
                .content("spring boot 2.深入浅出")
                .createTime("")
                .reader(list)
                .title("t1").build();
        return AjaxResponse.success(article2);
    }
}