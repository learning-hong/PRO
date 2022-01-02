package com.ch.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ch.project.dao.LikeDao;
import com.ch.project.dao.MemberDao;
import com.ch.project.model.Like;


@Service
public class LikeServiceImpl implements LikeService{
	@Autowired
	private LikeDao ld;
	@Override
	public int ltlikecount(int bid) {
		return ld.ltlikecount(bid);
	}
	@Override
	public int ltlikegetinfo(Like like) {
		return ld.ltlikegetinfo(like);
	}
	@Override
	public void likeinsert(Like like) {
		ld.likeinsert(like);
	}
	@Override
	public void likeupdate(Like like) {
		ld.likeupdate(like);
	}
	public Like select(Like like) {
		return ld.select(like);
	}
	
}
