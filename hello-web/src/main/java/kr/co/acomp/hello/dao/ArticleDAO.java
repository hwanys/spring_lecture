package kr.co.acomp.hello.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.acomp.hello.vo.Article;

@Repository
public class ArticleDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public void insertArticle(Article article){
		sqlSession.insert(
				"mappers.article-mapper.insertArticle", article);
//		System.out.println(article);
	}

	public Article selectArticleById(String articleId) {
		
		return sqlSession.selectOne(
				"mappers.article-mapper.selectArticleById", articleId);
		
//		Article article = new Article(10, "lee", "test", "�׽�Ʈ�Դϴ�.");
//		return article;
	}
}
