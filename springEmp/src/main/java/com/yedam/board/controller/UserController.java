package com.yedam.board.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.board.service.UserService;
import com.yedam.emp.UserVO;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	// 전체 조회
	@GetMapping("/getuserlist")
	public List<UserVO> getSearchUser(UserVO vo) {
		return userService.getSearchUser(vo);
	}

	// 단건 조회
	@GetMapping("/getuser")
	public UserVO getUser(UserVO vo) {
		return userService.getUser(vo);
	}

	// 삭제
	@GetMapping(value = "/deleteuser")
	public Map deleteUser(UserVO vo) {
		int r = userService.deleteUser(vo);
		return Collections.singletonMap("cnt", r);
	}

	// 등록
	@PostMapping("/insertuser")
	public ResponseEntity<Object> insertUserProc(UserVO vo) throws JsonProcessingException {
		userService.insertUser(vo);
		UserVO userVO = userService.getUser(vo);
		if(userVO != null) {
			ObjectMapper mapper = new ObjectMapper();	//jackson 라이브러리 json
			return ResponseEntity.status(200).body(mapper.writeValueAsString(userVO) );
		} else {
			return ResponseEntity.status(500).body("insert error");
		}
	}

	// 수정처리
	@PostMapping("/updateuser")
	public UserVO updateUser(UserVO vo, Model model) {
		userService.updateUser(vo);
		System.out.println("수정====" + vo);
		return vo;
	}

}
