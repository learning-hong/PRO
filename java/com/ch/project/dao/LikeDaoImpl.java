package com.ch.project.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.project.model.Like;

@Repository
public class LikeDaoImpl implements LikeDao {
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public int ltlikecount(int bid) {
		return sst.selectOne("boardns.ltlikecount", bid);
	}

	@Override
	public int ltlikegetinfo(Like like) {
		return sst.selectOne("boardns.ltlikegetinfo", like);
	}

	@Override
	public void likeinsert(Like like) {
		sst.insert("boardns.likeinsert", like);
	}

	@Override
	public void likeupdate(Like like) {
		sst.update("boardns.likeupdate", like);
	}

	@Override
	public Like select(Like like) {
		return sst.selectOne("boardns.selectLike", like);
	}
}
