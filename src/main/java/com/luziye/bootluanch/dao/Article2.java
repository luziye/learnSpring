package com.luziye.bootluanch.dao;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"content", "title"})

public class Article2 {

    /**
     * id : 1
     * author : luziye
     * title : 手摸手开发spring boot
     * content : abc
     * createTime :
     * reader : [{"name":"luziye","age":18},{"name":"kobe","age":37}]
     */
    @JsonIgnore
    private Integer id;
    @JsonProperty("auther")
    private String author;
    private String title;
    private String content;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String createTime;
    private List<ReaderBean> reader;


    @Data
    @Builder
    public static class ReaderBean {
        /**
         * name : luziye
         * age : 18
         */
        private String name;
        private int age;

    }
}
