package com.ch.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.project.model.Board;
@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSessionTemplate sst;
	
	
	/*
	 * @Override public List<Board> list() {
	 * 
	 * return sst.selectList("boardns.list"); }
	 */

	@Override
	public Board select(int bid) {
		
		return sst.selectOne("boardns.select", bid);
	}

	@Override
	public int insert(Board board) {
		
		return sst.insert("boardns.insert",board);
	}

	@Override
	public int update(Board board) {
		
		return sst.update("boardns.update",board);
	}

	@Override
	public int delete(int bid) {
		
		return sst.delete("boardns.delete",bid);
	}

	@Override
	public int getTotal(Board board) {
		
		return sst.selectOne("boardns.getTotal",board);
	}

	@Override
	public List<Board> list(Board board) {
		
		return sst.selectList("boardns.list",board);
	}


}
