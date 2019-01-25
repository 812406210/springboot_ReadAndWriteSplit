package com.readandwrite.demo.service;

import com.readandwrite.demo.entity.Member;

import java.util.List;

public interface MemberService {

     int insert(Member member);

     int save(Member member);

     int updateById(Member member);

     List<Member> selectAll();

     int deleteById(Integer id);

     String getToken(String appId);

     Member selectById(Integer id );

}
