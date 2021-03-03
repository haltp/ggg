package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.emp.JobVO;
import com.yedam.emp.service.JobService;



@Controller
public class JobController {
	
	@Autowired JobService JobService;
	
	@GetMapping("/insertJob")	//등록페이지로
	public String insertJob(JobVO vo) {
		return "/job/insertJob";
	}
	
	@PostMapping("/insertJob")	//등록처리
	public String insertJobProc(JobVO vo) {
		JobService.insertJob(vo);
		return "redirect:/getSearchJob";
	}
	
	@GetMapping("/updateJob")	//수정페이지로
	public String updateJob(JobVO vo, Model model) {
		model.addAttribute("JobVO", JobService.getJob(vo) );
		return "/job/updateJob";
	}
	
	@PostMapping("/updateJob")	//수정처리
	public String updateJobProc(JobVO vo) {
		JobService.updateJob(vo);
		return "redirect:/getSearchJob";
	}
	
	@GetMapping("/deleteJob")	//삭제
	public String deleteJob(JobVO vo) {
		JobService.deleteJob(vo);
		return "redirect:/getSearchJob";
	}
	
	@GetMapping("/getJob")	//단건조회
	public String getJob(JobVO vo, Model model) {
		model.addAttribute("job", JobService.getJob(vo));
		return "/job/getJob";
	}
	
	@GetMapping("/getSearchJob")	//검색조회
	public String getSearchJob(JobVO vo, Model model) {
		model.addAttribute("list", JobService.getSearchJob(vo));
		return "/job/getSearchJob";
	}	
}
