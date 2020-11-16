package kosta.exam;

import org.springframework.stereotype.Service;

@Service("target")
public class MemberServiceImpl implements MemberService {

	@Override
	public int insert() {
		System.out.println("MemberServiceImpl의  insert() 핵심기능입니다.");
		return 24;
		}

	@Override
	public String select(int i) {
		System.out.println("MemberServiceImpl의  select(int i) 핵심기능입니다.");
		if(i==0) throw new RuntimeException("예외가 발생했습니다.");//after-returning이 실행되지않는다.
		return "aop공부중...";
	}

	@Override
	public void update(String id) {
		System.out.println("MemberServiceImpl의 update(String id) 핵심기능입니다.");

	}

}
