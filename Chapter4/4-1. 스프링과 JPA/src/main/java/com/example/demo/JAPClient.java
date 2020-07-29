package com.example.demo;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.example.demo.domain.Board;

public class JAPClient {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();

		// Transaction 생성
//		EntityTransaction tx = em.getTransaction();

		try {
			// Transaction 시작
//			tx.begin();

//			Board board = new Board();
//
//			board.setTitle("JPA 제목");
//			board.setWriter("관리자");
//			board.setContent("JPA 글 등록 잘 되네요.");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//
//			em.persist(board);

			Board searchBoard = em.find(Board.class, 1L);
			System.out.println("--> " + searchBoard.toString());

			// Transaction Commit
//			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();

			// Transaction Rollback
//			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
}
