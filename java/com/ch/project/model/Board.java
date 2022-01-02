package com.ch.project.model;

import java.sql.Date;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Board {
	 private int bid; // 글 번호	
 	 private String writer; // 작성자
 	 private String title; // 제목		
 	 private String content; // 내용	
 	 
 	private String fileName; // db 사진 명			
 	
 	private Date regdate; // 등록일	
 	private int hit; // 좋아요 수	
 	
 // paging용
 	private int startRow; // 시작 번호
 	private int endRow; // 끝 번호
 	
 // 좋아요 갯수   
  	private int ltlike_count;
  	private int ltlike_stat;
 	
 // 사진 upload용 
  	 private MultipartFile file; // 실제 사진명 
	
 	
}
