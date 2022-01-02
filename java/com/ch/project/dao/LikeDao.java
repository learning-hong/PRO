package com.ch.project.dao;

import com.ch.project.model.Like;

public interface LikeDao {

	int ltlikecount(int bid);

	int ltlikegetinfo(Like like);

	void likeinsert(Like like);

	void likeupdate(Like like);

	Like select(Like like);

}
