package com.yedam.emp.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.DeptVO;
import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.JobVO;
import com.yedam.emp.common.Paging;
import com.yedam.emp.service.DeptService;
import com.yedam.emp.service.EmpService;
import com.yedam.emp.service.JobService;

/*
 * @GetMapping 는 수정
 */
@Controller
public class EmpController implements Validator{

	@Autowired
	EmpService empService;
	@Autowired
	DeptService deptService;
	@Autowired
	JobService jobService;

	@RequestMapping("/")
	public String main() {
		return "main";
	}

	@GetMapping("/insertEmp") // 등록페이지로
	public String insertEmp(EmpVO vo, Model model, DeptVO deptvo, JobVO jobvo) {
		// deptvo.setStart(1); 
		 //deptvo.setEnd(1000);
		model.addAttribute("deptList", deptService.getSearchDept(deptvo));
		model.addAttribute("jobList", jobService.getSearchJob(jobvo));
		return "/emp/insertEmp";
	}

	@PostMapping("/insertEmp") // 등록처리
	public String insertEmpProc(@Valid EmpVO vo, BindingResult result, DeptVO deptvo, Model model, JobVO jobvo) {
		// 입력값 검증
//		EmpValidation empValidation = new EmpValidation();
//		empValidation.validate(vo, result);
		if (result.hasErrors()) {
			model.addAttribute("deptList", deptService.getSearchDept(deptvo));
			model.addAttribute("jobList", jobService.getSearchJob(jobvo));
			return "/emp/insertEmp"; // 등록페이지로
		} else {
			empService.insertEmp(vo);
			return "redirect:/getSearchEmp";
		}

	}

	@GetMapping("/updateEmp") // 수정페이지로
	public String updateEmp(EmpVO vo, Model model, DeptVO deptvo, JobVO jobvo) {
		model.addAttribute("empVO", empService.getEmp(vo));
		model.addAttribute("deptList", deptService.getSearchDept(deptvo));
		model.addAttribute("jobList", jobService.getSearchJob(jobvo));
		return "/emp/updateEmp";
	}

	@PostMapping("/updateEmp") // 수정처리
	public String updateEmpProc(EmpVO vo, HttpSession session) {
		String id = (String)session.getAttribute("loginid");
		empService.updateEmp(vo);
		return "redirect:/getSearchEmp";
	}

	@GetMapping("/deleteEmp") // 삭제
	public String deleteEmp(EmpVO vo) {
		empService.deleteEmp(vo);
		return "redirect:/getSearchEmp";
	}

	@GetMapping("/getEmp") // 단건조회 //@PathVariable쓸때 "/getEmp/{id}"
	public String getEmp(Model model
	// , HttpServletRequest request
//						, @RequestParam(value="id"   //@RequestParam: getParamter 방법과 같다   //("id") : 변수 지정
//									  , required = false
//									  , defaultValue = "100" ) String id   //디폴트값 넣은 
//						, @PathVariable String id
			, @ModelAttribute("emp11") EmpVO vo) {
//		1. getParamter 방법(옛날에 썼던 방법)
//		String id = request.getParameter("employee_id");

//		EmpVO vo = new EmpVO();
//		vo.setEmployee_id(id);

		model.addAttribute("emp", empService.getEmp(vo));
		return "/emp/getEmp";
	}

	@GetMapping("/getSearchEmp") // 검색조회
	public String getSearchEmp(EmpSearchVO vo, Paging paging, Model model) {
		paging.setPageUnit(5); // 한 페이지에 표시되는 레코드 건 수
		paging.setPageSize(3); // 페이지번호

		// 페이징
		if (vo.getPage() == null) {
			vo.setPage(1);
		}
		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast());
		paging.setTotalRecord(empService.getCount(vo));
		model.addAttribute("paging", paging);
		model.addAttribute("list", empService.getSearchEmp(vo));
		return "/emp/getSearchEmp";
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}
}
