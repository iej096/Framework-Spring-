package edu.kh.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Java 객체 : new 연산자에 의해 Heap영역에
//				클래스에 작성된 내용대로 생성된 것

// instance:  개발자가 만들고 관리하는 객체

//		: Spring Container(Spring)가 만들고 관리하는 객체


@Controller // 요청/응답을 제어할 컨트롤러 역할 
			// + Bean으로 등록 (== 객체로 생성해서 스프링이 관리)
		// 어노테이션써놓으면 spring이 알아서 일한다

public class TestController {
	
	// 기존 Servlet : 클래스 단위로 하나의 요청만 처리 가능
	
	// Spring : 메서드 단위로 요청 처리 가능
	
	// @RequestMapping("요청주소")
	// - 요청 주소를 처리할 메서드를 매핑하는 어노테이션
	
	// 1) 메서드에 작성 :
	// 	- 요청 주소와 메서드를 매핑
	// 	- GET/POST 가리지 않고 매핑(속성을 통해서 지정가능)
	
	// 2) 클래스에 작성
	// 	- 공통 주소를 매핑
	//	ex) /todo/insert, /todo/select, /todo/update
	
	// @RequestMapping("todo") 
	// public class 클래스명{
	// 	 @ReuquestMapping("insert")  // /todo/insert 매핑
	//	 public String 메서드명(){}
	// 	 @ReuquestMapping("update")  // /todo/update 매핑
	//	 public String 메서드명(){}
	// }
	
	
	/* ************************************************* */
	// Spring Boot Controller에서
	// 특수한 경우를 제외하고
	// 매핑 주소 제일 앞에 "/"를 작성하지 않는다!!!!!!
	/* ***************************************************/
	
	@RequestMapping("test") // /test 요청시 처리할 메서드 매핑
	// <a href="/test">요청 + forward</a> 부분 매핑
	public String testMethod() {
		System.out.println("/test 요청 받음");
		
		/* Controller 메서드의 반환형이 String 인 이유
		 * - 메서드에서 반환되는 문자열이
		 * 	 forward할 html파일의 경로가 되기때문
		 * */
		
		/* Thymeleaf : JSP대신 사용하는 템플릿 엔진
		 * 
		 * classpath; == src/main/resources
		 * 접두사 : classpath:/templates/
		 * 접미사 :.html
		 */
		
		// 접두사 : src/main/resources/templates/
		// 접미사 : .html
		return "test"; // 접두사 + 반환값 + 접미사 경로의 html로 forward
	// return "src/main/resources/templates/test.html"; 인데 
	// view resolver가 알아서 앞뒤 붙여주니까 test만 써도 상관 없다.
		/* 접두사, 접미사, forward 설정은 View Resolver 객체가 담당 */
	}

}
