package com.yedam.emp.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.emp.DeptVO;

@Repository
public class DeptMybatisDAO {
	
	@Autowired SqlSessionTemplate sqlSession;
	
	//등록
	public int insertDept(DeptVO vo) {
		return sqlSession.insert("DeptDAO.insertDept", vo);
	}
	
	//수정
	public int updateDept(DeptVO vo) {
		return sqlSession.update("DeptDAO.updateDept", vo);
	}
	
	//삭제
	public int deleteDept(DeptVO vo) {
		return sqlSession.delete("DeptDAO.deleteDept", vo);
	}
	
	//단건조회
	public DeptVO getDept(DeptVO vo) { 
		return sqlSession.selectOne("DeptDAO.getDept", vo);
	}
	
	//전체조회
	public List<DeptVO> getSearchDept(DeptVO DeptVO) { 
		System.out.println("mabatis list");
		return sqlSession.selectList("DeptDAO.getSearchDept", DeptVO); 
	}
}
