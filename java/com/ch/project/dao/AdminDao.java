package com.ch.project.dao;
import com.ch.project.model.AdminMain;
import com.ch.project.model.Member;
public interface AdminDao {
	Member select(String id);
	int delete(String id);
}
