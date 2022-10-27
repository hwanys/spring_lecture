package kr.co.acomp.hello.dao;

import org.springframework.stereotype.Repository;

import kr.co.acomp.hello.vo.Article;

@Repository
public class ArticleDAO {

	public void insertArticle(Article article){
		System.out.println(article);
	}

	public Article selectArticleById(String articleId) {
		
		Article article = new Article(10, "lee", "test", "테스트입니다.");
		
		return article;
	}
}
