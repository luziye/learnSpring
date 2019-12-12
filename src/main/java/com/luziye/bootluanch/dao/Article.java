package com.luziye.bootluanch.dao;

import com.fasterxml.jackson.annotation.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
@JsonPropertyOrder(value = {"content","title"})
public class Article {
    @JsonIgnore
    private Long  id;
    @JsonProperty("auther")
    private String author;
    private String title;

    private String content;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    private List<Reader> reader;

}
