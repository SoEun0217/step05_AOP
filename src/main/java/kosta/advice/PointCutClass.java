package kosta.advice;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutClass {
	
	@Pointcut("execution(* kosta.exam.MemberServiceImpl.*(..))")
	public void aa() {
		
	}
	/**
	 * 로그 pointCut
	 * */
	
	/**
	 * 세션체크 pointCut
	 * */
	
	/**
	 * transaction pointCut
	 * */
}
