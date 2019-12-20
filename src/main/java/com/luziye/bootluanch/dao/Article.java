package com.luziye.bootluanch.dao;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @JsonIgnore
    private Long  id;
    @JsonProperty("aaa")
    private String author;
    private String title;

    private String content;

    private Date createTime;

}
