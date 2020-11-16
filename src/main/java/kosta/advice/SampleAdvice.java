package kosta.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service //id="sampleAdvice"
@Aspect
@Order(1)
public class SampleAdvice {
	/**
	 * before : 사전처리
	 * */
	@Before("PointCutClass.aa()")
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object params [] = joinPoint.getArgs();//들고들어오는 매개변수 리스트
		System.out.println(methodName+"의 매개변수의 개수 : "+params.length);
		if(params.length>0) {
			for(Object o:params) {
				System.out.println(methodName+"의 인수 : "+o);
			}
		}
		System.out.println(methodName+"가 호출되기전 before....\n");
	}
	
	/**
	 * after : 사후처리(예외발생여부 상관없이 무조건)
	 * */
	@After("PointCutClass.aa()")
	public void afterFinally() {
		System.out.println("after...예외 발생여부 상관없이 실행...\n");
	}
	
	/**
	 * after-returning : 사후처리(예외없이 정상 작동 했을 때)
	 * 
	 * 인수 Object는 joinPoint 대상이 실행 된 후 리턴한 값을 받는 매개변수
	 * 인수의 obj이름은 xml의 설정의 returning="obj"동일해야한다!!
	 * */
	@AfterReturning(pointcut = "PointCutClass.aa()",returning = "obj")
	public void afterReturning(JoinPoint point, Object obj) {
		String methodName = point.getSignature().getName();
		System.out.println(methodName+"이 리턴한 값은 "+obj);
		System.out.println("예외없이 정상적으로 동작했을 때 ...afterReturning...\n");
	}
	
	/**
	 * after-throwing : 사후처리(예외가 발생 했을 때)
	 * 인수 Throwable은 예외에 대한 정보를 매개변수로 전달 받는다.
	 * 인수의 e이름은 xml 설정의 throwing="e" 동일해야한다!!
	 * */
	@AfterThrowing(pointcut = "PointCutClass.aa()",throwing = "e")
	public void afterThrowing(Throwable e) {
		System.out.println("afterThrowing 예외가 발생했을 때 실행..."+e+"\n");
	}
}
