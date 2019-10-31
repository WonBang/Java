package member.controller;

import member.service.MemberService;
import org.springframework.stereotype.Controller;
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
    public String memberJoinOk(){



        return dirInfo + "main";
    }
}
