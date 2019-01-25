package com.readandwrite.demo.service.serviceImpl;

import com.readandwrite.demo.entity.Member;
import com.readandwrite.demo.mapper.MemberMapper;
import com.readandwrite.demo.service.Master;
import com.readandwrite.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Transactional
    @Override
    public int insert(Member member) {
        return memberMapper.insert(member);
    }

    @Master
    @Override
    public int save(Member member) {
        return memberMapper.insert(member);
    }

    @Override
    public int updateById(Member member) {
        return memberMapper.updateById(member);
    }

    @Override
    public List<Member> selectAll() {
        return memberMapper.selectAll();
    }

    @Override
    public int deleteById(Integer id ) {
        return memberMapper.deleteById(id);
    }


    @Master
    @Override
    public String getToken(String appId) {
        //  有些读操作必须读主数据库
        //  比如，获取微信access_token，因为高峰时期主从同步可能延迟
        //  这种情况下就必须强制从主数据读
        return null;
    }

    @Override
    public Member selectById(Integer id) {
        return memberMapper.selectById(id);
    }
}