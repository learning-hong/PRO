package com.ch.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.project.dao.BoardDao;
import com.ch.project.model.Board;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao bd;

	/*
	 * @Override public List<Board> list() {
	 * 
	 * return bd.list(); }
	 */
	@Override
	public Board select(int bid) {
		
		return bd.select(bid);
	}
	@Override
	public int insert(Board board) {
		
		return bd.insert(board);
	}
	@Override
	public int update(Board board) {
		
		return bd.update(board);
	}
	@Override
	public int delete(int bid) {
		
		return bd.delete(bid);
	}
	@Override
	public int getTotal(Board board) {
		
		return bd.getTotal(board);
	}
	@Override
	public List<Board> list(Board board) {
		
		return bd.list(board);
	} 

}
