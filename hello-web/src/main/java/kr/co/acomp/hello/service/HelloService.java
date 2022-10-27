package kr.co.acomp.hello.service;

import kr.co.acomp.hello.dao.AnotherDAO;
import kr.co.acomp.hello.dao.HelloDAO;

public class HelloService {

//	private HelloDAO dao;
	private HelloDAO helloDAO;
	private AnotherDAO anotherDAO;
	
//	public void setHelloDAO(HelloDAO dao){ 
//		this.helloDAO = dao;
//	}
	
	public void setHelloDAO(HelloDAO dao){
		this.helloDAO = dao;
	}
	
	public void setAnotherDAO(AnotherDAO dao){
		this.anotherDAO = dao;
	}
	
//	public int calcTwoNumbers(int a, int b){
	public int calcTwoNumbersAndSquare(int a, int b){
		
//		dao = new HelloDAO();
		
		int result = helloDAO.addTwoNumber(a, b);
		return anotherDAO.square(result);
	}
}