package kr.co.acomp.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.acomp.hello.dao.ArticleDAO;
import kr.co.acomp.hello.vo.Article;

@Service
public class BbsService {
	
	@Autowired
	private ArticleDAO articleDAO;
	
	public void registArticle(Article article){
		articleDAO.insertArticle(article);
	}

	public Article viewArticleDetail(String articleId) {
		return this.articleDAO.selectArticleById(articleId);
	}
}
