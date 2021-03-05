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
}
