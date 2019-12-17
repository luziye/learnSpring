package com.luziye.bootluanch.controller;

import com.luziye.bootluanch.dao.Article2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public  String hello(String name){
        Article2.ReaderBean readerBean=Article2.ReaderBean.builder().age(10).name("xulele").build();
        List<Article2.ReaderBean> list=new ArrayList<>();
        list.add(readerBean);
        Article2 article2= Article2.builder()
                .id(90)
                .author("luziye")
                .title("this is a book")
                .content("content")
//                .reader((List<Article2.ReaderBean>) Article2.ReaderBean.builder().age(10).name("xulele").build())
                .reader(list)
                .build();
        return "hello world"+article2;
    }
}
