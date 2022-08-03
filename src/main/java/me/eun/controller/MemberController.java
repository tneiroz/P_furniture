package me.eun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.eun.model.MemberVO;
import me.eun.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

	@Autowired
	private MemberService memberservice;
	
	//회원가입 페이지 이동
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void joinGET() {
				
	}
	//회원가입
		@RequestMapping(value="/join", method=RequestMethod.POST)
		public String joinPOST(MemberVO member) throws Exception{
			// 회원가입 서비스 실행
			memberservice.memberJoin(member);
			return "redirect:/";
			
		}
	
	//로그인 페이지 이동
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void loginGET() {
		
		
	}
	
	 /* 로그인 */
    @RequestMapping(value="login", method=RequestMethod.POST)
    public String loginPOST(HttpServletRequest request, MemberVO member, RedirectAttributes rttr) throws Exception{
    	HttpSession session = request.getSession();
        MemberVO lvo = memberservice.memberLogin(member);   //ivo로 선언
        System.out.println(lvo);
       if(lvo == null) {                                // 일치하지 않는 이메일, 비밀번호 입력 경우
            int result = 0;
            rttr.addFlashAttribute("result", result);
            return "redirect:/member/login";
        }else {
        	session.setAttribute("member", lvo);             // 일치하는 이메일, 비밀번호 경우 (로그인 성공)
        	return "redirect:/";
        }
    }

    /* 메인페이지 로그아웃 */
    @RequestMapping(value="logout", method=RequestMethod.GET)
    public String logoutMainGET(HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";        
        
    }
   
    /*로그인 하고 마이페이지로 이동*/
	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public void mypage() throws Exception {
		
	}
	
	
}

