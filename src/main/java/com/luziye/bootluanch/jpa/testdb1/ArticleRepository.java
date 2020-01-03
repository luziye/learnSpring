package com.luziye.bootluanch.jpa.testdb1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Integer> {
    Article findByAuthor(String auther);
}