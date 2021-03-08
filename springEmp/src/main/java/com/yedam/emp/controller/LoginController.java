package com.yedam.emp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.board.service.UserService;
import com.yedam.emp.ChangePwValidation;
import com.yedam.emp.UserVO;

@Controller
public class LoginController {
	
	@Resource UserService userService;

	@GetMapping("/login")	//로그인페이지 이동
	public String login()	{
		return "user/login";
	}
	
	@PostMapping("/login")	//로그인처리
	public String loginProc(UserVO vo, HttpSession session)	{
		if(userService.logCheck(vo)) { //로그인 된 경우
			//세션에 저장
			session.setAttribute("loginid", vo.getId());
			return "redirect:/";
		} else {
			return "user/login";
		}
	}
	
	@GetMapping("/logout")	//로그아웃처리
	public String logoutProc(HttpSession session)	{
		session.invalidate(); //세션 무효화
		return "redirect:/";
	}
	
	@GetMapping("/changePw")	//패스워드변경페이지 이동
	public String changePw()	{
		return "user/changePw";
	}
	
	@PostMapping("/changePw")	//패스워드변경처리를 위한 세션저장
	public String changePwProc(HttpSession session, UserVO vo, BindingResult result)	{
		//validation
		ChangePwValidation pwValidation = new ChangePwValidation();
		pwValidation.validate(vo, result);
		
		//패스워드변경서비스
		String id = (String)session.getAttribute("loginid");
		vo.setId(id);
		userService.updatePw(vo);		
		return "user/changePw";
	}
	
}
