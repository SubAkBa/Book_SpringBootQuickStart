package com.example.demo.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString(exclude = "member")
@Getter
@Setter
public class Board {
	@Id
	@GeneratedValue
	private Long seq;

	private String title;
//	private String writer;
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private Long cnt;

	@ManyToOne
	@JoinColumn(name = "MEMBER_ID", nullable = false)
	private Member member;

	public void setMember(Member member) {
		this.member = member;
		member.getBoardList().add(this);
	}
}
