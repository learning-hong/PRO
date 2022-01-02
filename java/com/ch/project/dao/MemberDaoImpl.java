package com.ch.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.project.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
   @Autowired
   private SqlSessionTemplate sst;

   @Override
   public Member select(String id) {
      return sst.selectOne("memberns.select", id);
   }
  
   @Override
   public int insert(Member member) {
      return sst.insert("memberns.insert", member);
   }

   @Override
   public int update(Member member) {
      return sst.insert("memberns.update", member);
   }

   @Override
   public int delete(String id) {
      return sst.update("memberns.delete", id);
   }

   @Override
   public List<Member> memberList() {
      // TODO Auto-generated method stub
      return sst.selectList("memberns.memberList");
   }

 
   
   
}