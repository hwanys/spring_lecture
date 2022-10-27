package kr.co.acomp.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.acomp.hello.service.BbsService;
import kr.co.acomp.hello.vo.Article;

@Controller
@RequestMapping("/bbs")
public class BbsController {

	@Autowired
	private BbsService bbsService;
	
	@GetMapping("")
	public String index(){
		return "index";
	}
	
	// 글 보기
	@GetMapping("/{articleId}")
	@ResponseBody //Ajax로 return된다 / return 되는 내용을 그대로 return 하라!
	public Article viewDetail(@PathVariable String articleId){
		Article article = this.bbsService.viewArticleDetail(articleId);
		return article;
	}
	
	// 글 쓰기
	@PostMapping("/write")
	@ResponseBody
	public Article write(@RequestBody Article article){ // json 내용 -> article 객체로 변환
		
		Article a = article; // article 객체를
		return a;			// 클라이언트로 바로 response함.
	}
	
//	@GetMapping("/{articleID}") // url에 따라오는 글 번호를 처리하는..
//	public String viewDetail(@PathVariable String articleID){
//		System.out.println("글번호는: " + articleID);
//		return "write_ok";
//	}

//	@RequestMapping("/write")
	
// Post 방식
//	@PostMapping("/write")
//	public String doWrite(Article article) { // Article가 커맨드 객체로 인식 -> 
//		bbsService.registArticle(article);
//		System.out.println("post request..");
//		return "write_ok";
//	}
	
// 글쓰기 - ModelAndView 방식
//	@PostMapping("/write")
//	public ModelAndView doWrite(Article article) { // Article가 커맨드 객체로 인식 -> 
//		bbsService.registArticle(article);
//		System.out.println("post request..");
//		return new ModelAndView("write_ok").addObject("article",article);
//	}
	
	@GetMapping("/write")
	public String write() {
		bbsService.registArticle(new Article());
		System.out.println("get request");
		return "write_ok";
	}
}
