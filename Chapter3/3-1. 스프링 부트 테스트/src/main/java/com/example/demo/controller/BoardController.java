package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.BoardVO;
import com.example.demo.service.BoardService;

@RestController
public class BoardController {

	@Autowired
	private BoardService boardService;

	public BoardController() {
		System.out.println("===> BoardController 생성");
	}

	@GetMapping("/hello")
	public String hello(String name) {
		return boardService.hello(name);
	}

	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		return boardService.getBoard();
	}

	@GetMapping("/getBoardList")
	public List<BoardVO> getBoardList() {
		return boardService.getBoardList();
	}

}
