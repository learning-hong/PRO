package com.ch.project.service;

import java.util.List;

import com.ch.project.model.Board;

public interface BoardService {

	/* List<Board> list(); */
	Board select(int bid);
	int insert(Board board);
	int update(Board board);
	int delete(int bid);
	int getTotal(Board board);
	List<Board> list(Board board);

}
