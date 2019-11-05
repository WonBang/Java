package member.controller;

import member.service.MemberService;
import member.service.impl.MemberServiceImpl;
import member.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MemberController {

    String dirInfo = "member/";

    @Autowired
    MemberService memberService;

    @RequestMapping("/member/join.do")
    public String memberJoin(){
        return "member/memberJoin";
    }

    @RequestMapping("/member/joinOk.do")
    public String memberJoinOk(@ModelAttribute  MemberVo memberVo, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //MemberVo memberVo = new MemberVo();

        try{
            System.out.println(memberVo.getPhone());
            System.out.println(memberVo.getUserId());
            System.out.println(memberVo.getUserNm());
            System.out.println(memberVo.getUserPw());

            memberService.insertMemberInfo(memberVo);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return dirInfo + "memberDetail";
    }
}
