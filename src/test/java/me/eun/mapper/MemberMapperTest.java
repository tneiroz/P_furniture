package me.eun.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.eun.config.RootConfig;
import me.eun.model.MemberVO;

@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class MemberMapperTest {

	@Autowired
	private MemberMapper membermapper;
	
	//회원가입 sql 연동 테스트
	@Test
	@Ignore
	public void memberJoin() throws Exception {
		MemberVO member = new MemberVO();
		member.setMemberName("멤버 이름 테스트"); //이름
		member.setMemberPw("멤버 비밀번호 테스트"); //비밀번호
		member.setMemberMail("멤버 이메일 테스트"); //이메일
		member.setMemberAddr("멤버 주소 테스트");//주소

		membermapper.memberJoin(member); //쿼리 메소드 실행
	}
	/* 로그인 쿼리 mapper 메서드 테스트 */
    @Test
    public void memberLogin() throws Exception{
        MemberVO member = new MemberVO();    // MemberVO 변수 선언 및 초기화
        
        /* 올바른 이메일,비밀번호입력경우 */
       member.setMemberMail("이메일1");
       member.setMemberPw("비밀번호1111");
        
        MemberVO memberLogin = membermapper.memberLogin(member);
        assertEquals(memberLogin.getMemberMail(), "이메일1");
        
    }

}
