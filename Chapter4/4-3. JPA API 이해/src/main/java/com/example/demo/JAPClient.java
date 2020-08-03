package com.example.demo;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.example.demo.domain.Board;

public class JAPClient {
	public static void main(String[] args) {
		// EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();

		// Transaction 생성
		EntityTransaction tx = em.getTransaction();

		try {
			// Transaction 시작
			tx.begin();

//			Board board = em.find(Board.class, 1L);
//			board.setTitle("검색한 게시글의 제목 수정");
			
			// 삭제할 게시글 조회
//			Board board1 = em.find(Board.class, 1L);
//			board1.setSeq(1L);
//			em.remove(board1);
			
			Board board = new Board();
			board.setTitle("JPA 제목");
			board.setWriter("관리자");
			board.setContent("JPA 글 등록 잘 되네요.");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			// 글 등록하기
			em.persist(board);

			// Transaction Commit
			tx.commit();
			
			tx.begin();
			
			// 글 목록 조회
			String jpql = "select b from Board b order by b.seq desc";
			List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();
			
			for (Board brd : boardList)
				System.out.println("--> " + brd.toString());
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();

			// Transaction Rollback
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
}
