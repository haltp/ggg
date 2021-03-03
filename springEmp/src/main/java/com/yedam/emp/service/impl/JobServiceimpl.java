package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.JobVO;
import com.yedam.emp.service.JobService;



@Service
public class JobServiceimpl implements JobService{
	
	//@Autowired DeptSpringDAO dao;
	@Autowired JobMapper dao;

	public int insertJob(JobVO vo) {
		return dao.insertJob(vo);
	}

	public int updateJob(JobVO vo) {
		return dao.updateJob(vo);
	}

	public int deleteJob(JobVO vo) {
		return dao.deleteJob(vo);
	}


	public JobVO getJob(JobVO vo) {
		return dao.getJob(vo);
	}


	public List<JobVO> getSearchJob(JobVO vo) {
		return dao.getSearchJob(vo);
	}

	
	
}
