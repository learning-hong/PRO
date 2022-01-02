package com.ch.project.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Product {
//	private String id; // 작성자 id
//	private String fileName; // 파일이름
//	//upload 용
//	private MultipartFile file; // 사진?
	
	private Integer pId; // 여행 상품 id
	private String writer; // 작성자 
	private String title; // 여행 상품 이름
	private String content; // 내용
	private Integer price; // 가격
	private Date regdate; // 등록일
	
	
}
