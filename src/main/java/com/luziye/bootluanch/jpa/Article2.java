//package com.luziye.bootluanch.dao;
//
//import com.fasterxml.jackson.annotation.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "article")
//@JsonPropertyOrder(value = {"author", "reader", "content"})
//
//public class Article2 {
//
//    /**
//     * id : 1
//     * author : luziye
//     * title : 手摸手开发spring boot
//     * content : abc
//     * createTime :
//     * reader : [{"name":"luziye","age":18},{"name":"kobe","age":37}]
//     */
//    @Id
//    @GeneratedValue
////    @JsonIgnore
//    private Integer id;
//    //    @JsonProperty("auther")
//    @Column(nullable = false, length = 32)
//    private String author;
//
//    @Column(nullable = false, unique = true, length = 32)
//    private String title;
//
//    private String content;
//
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    private String createTime;
//    private List<ReaderBean> reader;
//
//
//    @Data
//    @Builder
//    public static class ReaderBean {
//        /**
//         * name : luziye
//         * age : 18
//         */
//        private String name;
//        private int age;
//
//    }
//}
