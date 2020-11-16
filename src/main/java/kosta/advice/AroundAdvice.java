package kosta.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * 사전, 사후 처리 담당
 * */
@Service("arAdvice")
@Aspect
@Order(2)
public class AroundAdvice {
	
	@Around("PointCutClass.aa()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("around의 사전 처리 중입니다....\n");
		//연결해주는 느낌..
		Object obj = joinPoint.proceed();
		
		System.out.println("around의 사후 처리 중입니다....\n");
		return obj;
	}
}
