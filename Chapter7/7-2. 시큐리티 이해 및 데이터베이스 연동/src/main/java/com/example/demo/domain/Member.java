package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Setter;

import lombok.Getter;

import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
public class Member {
	@Id
	private String id;

	private String password;
	private String name;

	@Enumerated(EnumType.STRING)
	private Role role;
	private boolean enabled;
}
