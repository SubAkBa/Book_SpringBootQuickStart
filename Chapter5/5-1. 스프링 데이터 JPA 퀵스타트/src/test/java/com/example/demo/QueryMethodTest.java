package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.domain.Board;
import com.example.demo.persistence.BoardRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryMethodTest {

	@Autowired
	private BoardRepository boardRepository;

//	(1) LIKE 연산자 사용하기
//	@Test
//	public void testByContentContaining() {
//		List<Board> boardList = boardRepository.findByContentContaining("17");
//
//		System.out.println("검색 결과");
//		for (Board board : boardList)
//			System.out.println("---> " + board.toString());
//	}

//	(2) 여러 조건 사용하기
//	@Test
//	public void testFindByTitleContainingOrContentContaining() {
//		List<Board> boardList = boardRepository.findByTitleContainingOrContentContaining("17", "17");
//
//		System.out.println("검색 결과");
//
//		for (Board board : boardList)
//			System.out.println("---> " + board.toString());
//	}

//	(3) 데이터 정렬하기
//	@Test
//	public void testFindByTitleContainingOrderBySeqDesc() {
//		List<Board> boardList = boardRepository.findByTitleContainingOrderBySeqDesc("17");
//
//		System.out.println("검색 결과");
//
//		for (Board board : boardList)
//			System.out.println("--> " + board.toString());
//	}

//	(1) 페이징 처리
//	@Test
//	public void testFindByTitleContaining() {
//		Pageable paging = PageRequest.of(0, 5);
//
//		List<Board> boardList = boardRepository.findByTitleContaining("제목", paging);
//
//		System.out.println("검색 결과");
//
//		for (Board board : boardList)
//			System.out.println("---> " + board.toString());
//	}

//	(2) 정렬 처리
//	@Test
//	public void testFindByTitleContaining() {
//		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
//
//		List<Board> boardList = boardRepository.findByTitleContaining("제목", paging);
//
//		System.out.println("검색 결과");
//
//		for (Board board : boardList)
//			System.out.println("---> " + board.toString());
//	}

//	Page<T> 타입 사용하기
	@Test
	public void testFindByTitleContaining() {
		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");

		Page<Board> pageInfo = boardRepository.findByTitleContaining("제목", paging);

		System.out.println("PAGE SIZE : " + pageInfo.getSize());
		System.out.println("TOTAL PAGES : " + pageInfo.getTotalPages());
		System.out.println("TOTAL COUNT : " + pageInfo.getTotalElements());
		System.out.println("NEXT : " + pageInfo.nextPageable());

		List<Board> boardList = pageInfo.getContent();

		System.out.println("검색 결과");

		for (Board board : boardList)
			System.out.println("---> " + board.toString());
	}
}
