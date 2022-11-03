package kr.co.acomp.hello.controller;

import org.mybatis.spring.MyBatisSystemException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import kr.co.acomp.hello.exception.BizException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BizException.class)
	public String handleBizException(Exception e, Model model){
		
		model.addAttribute("type", e.getClass().getSimpleName());
		model.addAttribute("msg", e.getMessage());
		return "error";
	}
	
	// BbsController에서 index메소드 -> 데이터 넣은 결과 mybatis 에러 발생!
	@ExceptionHandler(MyBatisSystemException.class)
	public String handleMBSException(Exception e, Model model){
			
		model.addAttribute("type", e.getClass().getSimpleName());
		model.addAttribute("msg", e.getMessage());
		return "error";
	}
	
}
