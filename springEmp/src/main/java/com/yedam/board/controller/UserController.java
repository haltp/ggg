package com.yedam.board.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.board.service.UserService;
import com.yedam.emp.UserVO;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	// 등록처리
	@PostMapping("/user")
	public UserVO insertUserProc(@RequestBody UserVO vo) {
		System.out.println("등록===="+vo);
		userService.insertUser(vo);
		if (vo.getId().equals("0")) {
			System.out.println("등록1===="+vo);
			return vo;
		} else {
			System.out.println("등록2===="+vo);
			return userService.getUser(vo);
		}
	}
	
	//수정처리
	@PutMapping("/user")
	public UserVO updateUser(@RequestBody UserVO vo) {
		userService.updateUser(vo);
		System.out.println("수정===="+vo);
			return vo;
	}

	// 삭제
	@DeleteMapping(value = "/user")
	public Map deleteUser(@RequestBody UserVO vo) {
		int r = userService.deleteUser(vo);
		return Collections.singletonMap("cnt", r);
	}

	// 전체 조회
	@GetMapping("/user")
	public List<UserVO> getSearchUser(UserVO vo) {
		return userService.getSearchUser(vo);
	}

	// 단건 조회
	@GetMapping("/user/{id}")
	public UserVO getUser(UserVO vo,
								  @PathVariable String id) {
		vo.setId(id);
		return userService.getUser(vo);

	}

}
