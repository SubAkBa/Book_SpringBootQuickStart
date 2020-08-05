package com.example.demo;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Board;
import com.example.demo.persistence.BoardRepository;

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	private BoardRepository boardRepository;

//	@BeforeEach
//	public void dataPrepare() {
//		for (int i = 1; i <= 200; ++i) {
//			Board board = new Board();
//
//			board.setTitle("테스트 제목 " + i);
//			board.setWriter("테스터");
//			board.setContent("테스트 내용 " + i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//
//			boardRepository.save(board);
//		}
//	}
//
//	@Test
//	public void testFindByTitle() {
//		List<Board> boardList = boardRepository.findByTitle("테스트 제목 10");
//
//		System.out.println("검색 결과");
//
//		for (Board board : boardList)
//			System.out.println("---> " + board.toString());
//	}

// (1) 등록 기능 테스트
//	@Test
//	public void testInsertBoard() {
//		Board board = new Board();
//
//		board.setTitle("첫 번째 게시글");
//		board.setWriter("테스터");
//		board.setContent("잘 등록되나요?");
//		board.setCreateDate(new Date());
//		board.setCnt(0L);
//
//		boardRepository.save(board);
//	}

// (2) 상세 조회 기능 테스트
//	@Test
//	public void testGetBoard() {
//		Board board = boardRepository.findById(1L).get();
//
//		System.out.println(board.toString());
//	}

//	(3) 수정 기능 테스트
//	@Test
//	public void testUpdateBoard() {
//		System.out.println("=== 1번 게시글 조회 ===");
//		Board board = boardRepository.findById(1L).get();
//
//		System.out.println("=== 1번 게시글 제목 수정===");
//		board.setTitle("제목을 수정했습니다.");
//		boardRepository.save(board);
//	}

//	(4) 삭제 기능 테스트
//	@Test
//	public void testDeleteBoard() {
//		boardRepository.deleteById(1L);
//	}
}
