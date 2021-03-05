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

import com.yedam.board.service.CommentsService;
import com.yedam.board.service.CommentsVO;

@RestController // @Controller + @ResponseBody //@ResponseBody: json구조의 string으로 바꾸기 위해
public class CommentsController {

	@Autowired
	CommentsService commentsService;

	// 등록처리
	@PostMapping("/comments")
	public CommentsVO insertCommentsProc(@RequestBody CommentsVO vo) {
		commentsService.insertComments(vo);
		if (vo.getId().equals("0")) {
			return vo;
		} else {
			return commentsService.getComments(vo);
		}
	}
	
	//수정처리
	@PutMapping("/comments")
	public CommentsVO updateCommentsProc(@RequestBody CommentsVO vo) {
		System.out.println("수정===="+vo);
			return vo;
	}

	// 삭제
	@DeleteMapping(value = "/comments") //method = RequestMethod.DELETE
	public Map deleteCommentsProc(@RequestBody CommentsVO vo) {
		int r = commentsService.deleteComments(vo);
		return Collections.singletonMap("cnt", r);
	}

	// 게시글의 댓글 조회
	@GetMapping("/comments")
	public List<CommentsVO> getSearchComments(CommentsVO vo) {
		return commentsService.getSearchComments(vo);
	}

	// 단건 조회
	@GetMapping("/comments/{id}")
	public CommentsVO getComments(CommentsVO vo,
								  @PathVariable String id) {
		vo.setId(id);
		return commentsService.getComments(vo);

	}

}
