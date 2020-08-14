package com.example.demo.board.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.board.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String>{

}
