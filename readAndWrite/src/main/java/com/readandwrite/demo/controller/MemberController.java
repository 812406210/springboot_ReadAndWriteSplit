package com.readandwrite.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.readandwrite.demo.entity.Member;
import com.readandwrite.demo.service.MemberService;
import com.readandwrite.demo.util.CodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/memberController")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/selectAll")
    @ResponseBody
    public JSONObject selectAll(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        List<Member> memberList =  memberService.selectAll();
        //查询不到
        if(memberList.isEmpty()  || memberList==null){
            jsonObject.put("code", CodeEnum.ERROR_NOT_FOUND.getValue());
            jsonObject.put("message",CodeEnum.ERROR_NOT_FOUND.getMessage());
            return  jsonObject;
        }

        //查询有结果
        jsonObject.put("code", CodeEnum.SUCCESS.getValue());
        jsonObject.put("message",CodeEnum.SUCCESS.getMessage());
        jsonObject.put("memberList",memberList);
        return  jsonObject;
    }

    @RequestMapping("/addMember")
    @ResponseBody
    public JSONObject addMember(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        Member member = new Member();
        member.setName("yangwenjie");
        member.setAge(26);
        int insertNum = memberService.insert(member);
        if(insertNum == 0){
            jsonObject.put("code", CodeEnum.ERROR_CREATE_FAIL.getValue());
            jsonObject.put("message",CodeEnum.ERROR_CREATE_FAIL.getMessage());
            return  jsonObject;
        }
        //查询有结果
        jsonObject.put("code", CodeEnum.SUCCESS.getValue());
        jsonObject.put("message",CodeEnum.SUCCESS.getMessage());
        return  jsonObject;
    }


    @RequestMapping("/updateMember")
    @ResponseBody
    public JSONObject updateMember(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        Member member =memberService.selectById(4);
        member.setName("yangwenjie");
        int updateNum = memberService.updateById(member);
        if(updateNum == 0){
            jsonObject.put("code", CodeEnum.ERROR_UPDATE_FAIL.getValue());
            jsonObject.put("message",CodeEnum.ERROR_UPDATE_FAIL.getMessage());
            return  jsonObject;
        }
        //查询有结果
        jsonObject.put("code", CodeEnum.SUCCESS.getValue());
        jsonObject.put("message",CodeEnum.SUCCESS.getMessage());
        return  jsonObject;
    }



    @RequestMapping("/deleteMember")
    @ResponseBody
    public JSONObject deleteMember(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();

        int deleteNum = memberService.deleteById(1);
        if(deleteNum == 0){
            jsonObject.put("code", CodeEnum.ERROR_DELETE_FAIL.getValue());
            jsonObject.put("message",CodeEnum.ERROR_DELETE_FAIL.getMessage());
            return  jsonObject;
        }
        //查询有结果
        jsonObject.put("code", CodeEnum.SUCCESS.getValue());
        jsonObject.put("message",CodeEnum.SUCCESS.getMessage());
        return  jsonObject;
    }





}
