package kosta.exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("kosta/advice/applicationContext.xml");

		MemberService service = context.getBean("target", MemberService.class);

		System.out.println("======================");
		int result = service.insert(); 
		System.out.println("insert()의 결과 값 : "+result );
		System.out.println("======================");
		service.update("소은");
		System.out.println("======================");
		String result2 = service.select(10);
		System.out.println("select(int)의 결과 값 : " + result2);

		/**
		 * 코딩된 순서에 따라 먼저 실행되는 것.. around라고 먼저 하는 것이 아니다! aspect속성에 order를 지정해주면 순서대로 가능!
		 */

	}
}
