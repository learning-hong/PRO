package com.ch.project.model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Member {
	private String id;
	private String email;
	private String password;
	private String name;
	private String del;
	private Date regdate;
	
	private String memberPhoto;
	// file upload
	private MultipartFile file;
}


