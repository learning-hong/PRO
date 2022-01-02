package com.ch.project.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ch.project.service.PagingBean;
import com.ch.project.model.Board;
import com.ch.project.model.Like;
import com.ch.project.service.BoardService;
import com.ch.project.service.LikeService;

@Controller
public class BoardController {
	@Autowired
	private BoardService bs;
	@Autowired
	private LikeService ls;

	/*
	 * // 사용자 측(전체 글 조회)
	 * 
	 * @RequestMapping("boardList") public String boardList(Board board, String
	 * pageNum, HttpSession session, Model model) { if (pageNum == null ||
	 * pageNum.equals("")) pageNum = "1"; int currentPage =
	 * Integer.parseInt(pageNum); int rowPerPage = 10; int total =
	 * bs.getTotal(board); int startRow = (currentPage - 1) * rowPerPage + 1; int
	 * endRow = startRow + rowPerPage - 1; board.setStartRow(startRow);
	 * board.setEndRow(endRow); List<Board> boardList = bs.list(board); int num =
	 * total - startRow + 1; PagingBean pb = new PagingBean(currentPage, rowPerPage,
	 * total); model.addAttribute("boardList", boardList); model.addAttribute("num",
	 * num); model.addAttribute("pb", pb); return "board/boardList"; }
	 */
	// 사용자 측(전체 글 조회)
		@RequestMapping("boardList")
		public String boardList(Board board, String pageNum, HttpSession session, Model model) {
			if (pageNum == null || pageNum.equals(""))
				pageNum = "1";
			int currentPage = Integer.parseInt(pageNum);
			int rowPerPage = 10;
			int total = bs.getTotal(board);
			int startRow = (currentPage - 1) * rowPerPage + 1;
			int endRow = startRow + rowPerPage - 1;
			board.setStartRow(startRow);
			board.setEndRow(endRow);
			List<Board> boardList = bs.list(board);
			// 소셜 로그인으로 로그인시 id 변수를 가지 고 있지 않아 에러 발생
			String ltmid = (String)session.getAttribute("id");
			
			System.out.println("ltmid="+ltmid);
			for (Board bd : boardList) {
				int count = ls.ltlikecount(bd.getBid());
				bd.setLtlike_count(count);
				Like like = new Like();
				like.setLtbid(bd.getBid());
				like.setLtmid(ltmid);
				like = ls.select(like);
				if (like == null) 
					bd.setLtlike_stat(1);
				else bd.setLtlike_stat(like.getLtlike());
			}
			int num = total - startRow + 1;
			PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
			model.addAttribute("boardList", boardList);
			model.addAttribute("num", num);
			model.addAttribute("pb", pb);
			return "board/boardList";
		}

	
	

	// 입력
	@RequestMapping("boardInsertForm")
	public String boardInsertForm() {
		return "board/boardInsertForm";
	}

	@RequestMapping("boardInsert") // 사진 추가 기능 구현 필요
	public String boardInsert(Board board, HttpSession session, Model model)
			throws IOException {
		String fileName = board.getFile().getOriginalFilename();
		int result = 0;
		if(fileName != null && !fileName.equals("")) {
			board.setFileName(fileName); // 파일명 (변수 세팅)		
			String real = session.getServletContext().getRealPath("/resources/images") ;
			FileOutputStream fos = new FileOutputStream(
					new File(real+"/"+fileName)
					);
			fos.write(board.getFile().getBytes());
			fos.close();
			result = bs.insert(board);
		}else result= -1; // 이미 있으니 입력하지마세요
		model.addAttribute("result",result);
		return "board/boardInsert";

	} 

	@RequestMapping("updateBoardForm")
	public String updateBoardForm(int bid,String pageNum, Model model) {
		Board board = bs.select(bid);
		model.addAttribute("board", board);
		model.addAttribute("pageNum", pageNum);
		return "board/updateBoardForm";
	}

	@RequestMapping("boardUpdate")
	public String boardUpdate(Board board, HttpSession session, Model model) throws IOException {
		int result = 0;
		String fileName = board.getFile().getOriginalFilename();
		if(fileName != null && !fileName.equals("")) { 
			board.setFileName(fileName);
		  String real = session.getServletContext().getRealPath("/resources/images") ;
		  FileOutputStream fos = new FileOutputStream( new File(real+"/"+fileName) ); // /resources/images+사진.jpg
		  fos.write(board.getFile().getBytes());
		  fos.close();
		  result = bs.update(board);
		}
		else result = -1;
		model.addAttribute("result", result); // 여태까지 한 과정을 저장한다
		return "board/boardUpdate";
	}

	@RequestMapping("deleteBoard")
	public String deleteBoard(int bid, Model model) {
		int result = bs.delete(bid);
		model.addAttribute("result", result);
		return "board/deleteBoard";
	}

	@RequestMapping("boardDetail")
	/*
	 * int bid, String pageNum는 boardList에서 제목 부분은 bid=${}&pageNum={} 부분과 변수명 일치해야함
	 */
	public String boardDetail(int bid, String pageNum, Model model) {
//			bs.updateReadCount(num); // 조회수 기능 구현
		Board board = bs.select(bid);
		model.addAttribute("board", board);
		model.addAttribute("pageNum", pageNum);
		return "board/boardDetail";
	}

	
	
	@RequestMapping("likeupdate")
	public String likes1(Like like,Model model, HttpSession session) {		
		String ltmid = (String)session.getAttribute("id");
		like.setLtmid(ltmid);
		Like like2 = ls.select(like);
		if (like2 == null) {
			ls.likeinsert(like);
		} else {
			if (like2.getLtlike() == 0) {
				like2.setLtlike(1);
				ls.likeupdate(like2);
			} else {
				like2.setLtlike(0);
				ls.likeupdate(like2);
			}
		}
		return "board/boardList";
	}
	
}
