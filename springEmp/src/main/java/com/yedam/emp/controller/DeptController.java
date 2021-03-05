package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.emp.DeptVO;
import com.yedam.emp.common.Paging;
import com.yedam.emp.service.DeptService;



@Controller
public class DeptController {
	
	@Autowired DeptService DeptService;
	
	@GetMapping("/insertDept")	//등록페이지로
	public String insertDept(DeptVO vo) {
		return "/dept/insertDept";
	}
	
	@PostMapping("/insertDept")	//등록처리
	public String insertDeptProc(DeptVO vo) {
		DeptService.insertDept(vo);
		return "redirect:/getSearchDept";
	}
	
	@GetMapping("/updateDept")	//수정페이지로
	public String updateDept(DeptVO vo, Model model) {
		model.addAttribute("DeptVO", DeptService.getDept(vo) );
		return "/dept/updateDept";
	}
	
	@PostMapping("/updateDept")	//수정처리
	public String updateDeptProc(DeptVO vo) {
		DeptService.updateDept(vo);
		return "redirect:/getSearchDept";
	}
	
	@GetMapping("/deleteDept")	//삭제
	public String deleteDept(DeptVO vo) {
		DeptService.deleteDept(vo);
		return "redirect:/getSearchDept";
	}
	
	@GetMapping("/getDept")	//단건조회
	public String getDept(DeptVO vo, Model model) {
		model.addAttribute("dept", DeptService.getDept(vo));
		return "/dept/getDept";
	}
	
	@GetMapping("/getSearchDept")	//검색조회
	public String getSearchDept(DeptVO vo, Paging paging, Model model) {
		paging.setPageUnit(5);	//한 페이지에 표시되는 레코드 건 수
		paging.setPageSize(3); //페이지번호
		
		//페이징
		if(vo.getPage() == null ) {
			vo.setPage(1);
		}
		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast());
		paging.setTotalRecord(DeptService.getCount(vo));
		model.addAttribute("paging", paging);
		model.addAttribute("list", DeptService.getSearchDept(vo));
		return "/dept/getSearchDept";
	}
	
	
}
