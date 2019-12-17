package com.luziye.bootluanch.dao;

import com.fasterxml.jackson.annotation.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class Article {
    private Long  id;
    @JsonProperty("aaa")
    private String author;
    private String title;

    private String content;

    private Date createTime;
}
