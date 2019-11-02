package member.service.impl;

import member.dao.MemberDao;
import member.vo.MemberVo;
import member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberDao dao;


    public void insertMemberInfo(MemberVo memberVo) throws Exception{
        dao.insertMemberInfo(memberVo);
    }

}
