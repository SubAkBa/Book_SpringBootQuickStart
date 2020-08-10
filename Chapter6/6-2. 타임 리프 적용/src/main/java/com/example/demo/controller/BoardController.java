package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Board;
import com.example.demo.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

//	@RequestMapping("/getBoardList")
//	public String getBoardList(Model model) {
//		List<Board> boardList = new ArrayList<Board>();
//
//		for (int i = 1; i <= 10; ++i) {
//			Board board = new Board();
//
//			board.setSeq(new Long(i));
//			board.setTitle("게시판 프로그램 테스트");
//			board.setWriter("도우너");
//			board.setContent("게시판 프로그램 테스트입니다...");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//
//			boardList.add(board);
//		}
//
//		model.addAttribute("boardList", boardList);
//		
//		return "getBoardList";
//	}

	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, Board board) {
		List<Board> boardList = boardService.getBoardList(board);

		model.addAttribute("boardList", boardList);

		return "getBoardList";
	}

	@GetMapping("/insertBoard")
	public String insertBoardView() {
		return "insertBoard";
	}

	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);

		return "redirect:getBoardList";
	}

	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));

		return "getBoard";
	}

	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);

		return "forward:getBoardList";
	}

	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);

		return "forward:getBoardList";
	}

	@GetMapping("/hello")
	public void hello(Model model) {
		model.addAttribute("greeting", "Hello 타임리프.^^");
	}
}
