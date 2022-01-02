package com.ch.project.service;

import java.util.List;

import com.ch.project.model.Member;

public interface MemberService {

   Member select(String id);

   int insert(Member member);

   int update(Member member);

   int delete(String id);

   List<Member> memberList();
  

}