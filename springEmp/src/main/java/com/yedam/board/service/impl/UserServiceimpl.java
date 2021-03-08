package com.yedam.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.board.service.UserService;
import com.yedam.emp.UserVO;

@Service
public class UserServiceimpl implements UserService {

	@Autowired
	UserMapper dao;

	@Override
	public void insertUser(UserVO vo) {
		dao.insertUser(vo);
	}

	@Override
	public int deleteUser(UserVO vo) {
		return dao.deleteUser(vo);
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return dao.getUser(vo);
	}

	@Override
	public List<UserVO> getSearchUser(UserVO vo) {
		return dao.getSearchUser(vo);
	}

	@Override
	public int updateUser(UserVO vo) {
		return dao.updateUser(vo);

	}

	@Override
	public boolean logCheck(UserVO vo) {
		// 단건조회
		UserVO uservo = dao.getUser(vo);
		// id일치하는지 체크
		if (uservo == null) {
			return false;
		}

		// pw일치여부 체크
		if (uservo.getPassword().equals(vo.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int updatePw(UserVO vo) { //패스워드 변경 처리만들기
		//단건조회
		UserVO uservo = dao.getUser(vo);
		//기존 패스워드와 일치하는지 체크
		if (uservo.getPassword().equals(vo.getOldpassword())) {
			return dao.updatePw(vo);
		}
			return 0;
		//패스워드 업데이트
		
	}
}
