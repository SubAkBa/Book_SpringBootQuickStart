package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.BoardVO;

public interface BoardService {
	String hello(String name);

	BoardVO getBoard();

	List<BoardVO> getBoardList();
}
