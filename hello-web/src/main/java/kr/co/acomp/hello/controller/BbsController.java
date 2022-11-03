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
		bbsService.registArticle(new Article(5, "kim", "test", "test"));
		return "index";
	}
	
	// �� ����
	@GetMapping("/{articleId}")
	@ResponseBody //Ajax�� return�ȴ� / return �Ǵ� ������ �״�� return �϶�!
	public Article viewDetail(@PathVariable String articleId){
		Article article = this.bbsService.viewArticleDetail(articleId);
		return article;
	}
	
	// �� ����
	@PostMapping("/write")
	@ResponseBody
	public Article write(@RequestBody Article article){ // json ���� -> article ��ü�� ��ȯ
		
		Article a = article; // article ��ü��
		return a;			// Ŭ���̾�Ʈ�� �ٷ� response��.
	}
	
//	@GetMapping("/{articleID}") // url�� ������� �� ��ȣ�� ó���ϴ�..
//	public String viewDetail(@PathVariable String articleID){
//		System.out.println("�۹�ȣ��: " + articleID);
//		return "write_ok";
//	}

//	@RequestMapping("/write")
	
// Post ���
//	@PostMapping("/write")
//	public String doWrite(Article article) { // Article�� Ŀ�ǵ� ��ü�� �ν� -> 
//		bbsService.registArticle(article);
//		System.out.println("post request..");
//		return "write_ok";
//	}
	
// �۾��� - ModelAndView ���
//	@PostMapping("/write")
//	public ModelAndView doWrite(Article article) { // Article�� Ŀ�ǵ� ��ü�� �ν� -> 
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
