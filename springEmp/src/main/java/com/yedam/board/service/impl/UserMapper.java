package com.yedam.board.service.impl;

import java.util.List;

import com.yedam.emp.UserVO;


public interface UserMapper {
	// 입력
	public void insertUser(UserVO vo);
	
	//수정
	public int updateUser(UserVO vo);

	// 삭제
	public int deleteUser(UserVO vo);

	// 단건 조회
	public UserVO getUser(UserVO vo);

	// 전체 조회
	public List<UserVO> getSearchUser(UserVO vo);
	
	//로그인
	public boolean logCheck(UserVO vo);
		
	//changePw
	public int updatePw(UserVO vo);
}
