package member.controller;

import member.service.MemberService;
import member.vo.MemberVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

    String dirInfo = "member/";
    MemberService memberService;

    @RequestMapping("/member/join.do")
    public String memberJoin(){
        return "member/memberJoin";
    }

    @RequestMapping("/member/joinOk.do")
    public String memberJoinOk(@ModelAttribute  MemberVo memberVo) throws Exception {
        //MemberVo memberVo = new MemberVo();
        System.out.println(memberVo.getPhone());
        System.out.println(memberVo.getUserId());
        System.out.println(memberVo.getUserNm());
        System.out.println(memberVo.getUserPw());

        try{
            memberService.insertMemberInfo(memberVo);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return dirInfo + "memberDetail";
    }
}
