package com.ch.project.service;

import com.ch.project.model.Like;

public interface LikeService {

	void likeupdate(Like like);

	int ltlikecount(int bid);

	int ltlikegetinfo(Like like);

	void likeinsert(Like like);

	Like select(Like like);

	
}
