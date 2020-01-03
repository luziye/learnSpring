package jpa;

import com.luziye.bootluanch.jpa.testdb1.Article;
import com.luziye.bootluanch.jpa.testdb1.ArticleRepository;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


//@Run(SpringRunner.class)
@SpringBootTest
public class JPAKeyWordTest {

    @Resource
    private ArticleRepository articleRepository;
    
    @Test
    public void userTest() {
        Article article = articleRepository.findByAuthor("dufu");
        System.out.println(article);
    }

}
