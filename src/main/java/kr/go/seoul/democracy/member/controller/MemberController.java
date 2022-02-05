package kr.go.seoul.democracy.member.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.go.seoul.common.ImageResizeTemplate;
import kr.go.seoul.common.transfer.ImageTransferInfo;
import kr.go.seoul.democracy.common.model.vo.Member;
import kr.go.seoul.democracy.member.model.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	@Qualifier("profileImageTemplate")
    private ImageResizeTemplate imgTemplate;
    

	@Autowired
	private MemberService mService;
	
	//메인 화면에서 로그인 페이지로 이동하는 로직
	@RequestMapping(value="/member/goLogin.do",method=RequestMethod.GET)
	public String goLoginPage() {
		
		return "member/memberLogin";
	}
	
	
	//메인 화면에서 마이 페이지로 이동하는 로직
	@RequestMapping(value="/member/goMypage.do",method=RequestMethod.GET)
	public String goMypage() {
		
		return "member/myPage";
	}
	
	//로그인 페이지에서 아이디 찾기 페이지로  가는 로직
	@RequestMapping(value="/member/goMemberSearchId.do",method=RequestMethod.GET)
	public String goMemberSearchId() {
		
		return "member/memberSearchId";//대소문자 주의
		
	}
	
	
    //로그인 페이지에서 '비밀번호 변경 페이지'로 가는 로직
	@RequestMapping(value="/member/goMemberSearchPwd.do",method=RequestMethod.GET)
	public String goMemberSearchPwd() {
		return "member/memberSearchPwd";
	}
	
	
	//회원가입 페이지로 이동하는 로직
	@RequestMapping(value="/member/goMemberJoinus.do",method=RequestMethod.GET)
	public String goMemberJoinus() 
	{//기본페이지에서 회원가입 누른 사람들 회원가입 페이지로 보내는 메소드
		return "member/memberJoinus";
	}
	
	
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public String login(HttpServletRequest request,
			Member member
			){
				
				System.out.println("Login 로직 정상 호출");
				
				Member m = mService.selectLoginMember(member);
				
				if(m!=null)
				{
					System.out.println("로그인 성공");
					HttpSession session = request.getSession();
					session.setAttribute("member",m);
					
					return "redirect:/";
				}else {
					return "member/loginFail";
				}
				
				}
	
	@RequestMapping(value="/member/memberJoin.do", method=RequestMethod.POST)
	public ModelAndView memberJoinus(Member member,ModelAndView mav) {
		
		//2가지 
		//1. request 객체 사용 - request.getParameter();
		//2. @requestParam(데이터 받을때 사용)
		//3. VO를 이용해서 받는법 활용해보자
		
		//사용자가 입력한 자동으로 데이터를 m에 담아서 보내준다.
		int result=mService.insertMember(member);
		
		/*
		if(result>0) {
			System.out.println("회원 가입 성공");
		}else
		{
			System.out.println("회원 가입 실패");
		}*/
		
		
		if(result>0) {
			mav.addObject("msg","회원 가입 성공!");
			mav.addObject("location","/");
		}else
		{
			mav.addObject("msg","회원 가입 실패-지속적인 문제 발생시 관리자에게 문의-");
			mav.addObject("location","/member/joinPage.do");			
	}
		mav.setViewName("member/msg");
		
	return mav;
	
}
	
	
	
	
	
	
	
    /**
     * 이미지 리사이징 업로드를 설명하기 위한 예시
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/member/imageUpload.do", method = RequestMethod.POST)
    public String imageUpload(HttpServletRequest request) throws IOException {
        ImageTransferInfo info = (ImageTransferInfo) imgTemplate.fileTransfer(request, "img", "profile");
        info.getFileName();
        System.err.println("img transfer");
        System.err.println(info);                                                                                       // 이동한 파일 정보
        return "index";
    }
	

}
