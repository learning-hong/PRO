package com.ch.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.project.model.Board;
@Repository
public interface BoardDao {
	
	/* List<Board> list(); */
	Board select(int bid);
	int insert(Board board);
	int update(Board board);
	int delete(int bid);
	int getTotal(Board board);
	List<Board> list(Board board);

}
