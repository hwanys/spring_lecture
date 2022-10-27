package kr.co.acomp.hello;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.acomp.hello.service.BbsService;
//import kr.co.acomp.hello.service.HelloService;
import kr.co.acomp.hello.vo.Article;

public class HelloMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx =
				new ClassPathXmlApplicationContext("/spring-context.xml");
		
//		HelloDAO dao = ctx.getBean("helloDAO", HelloDAO.class);
//		HelloService service = ctx.getBean("helloService", HelloService.class);
		
//		int result = dao.addTwoNumber(5, 67);
//		int result = service.calcTwoNumbers(4, 8); 
//		int result = service.calcTwoNumbersAndSquare(4, 8); 
		
		BbsService service = ctx.getBean("bbsService", BbsService.class);
		service.registArticle(new Article());
		
//		System.out.println(result);

	}

}
