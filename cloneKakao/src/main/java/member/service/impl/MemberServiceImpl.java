package member.service.impl;

import member.dao.MemberDao;
import member.vo.MemberVo;
import member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao dao;

    @Override
    public void insertMemberInfo(MemberVo memberVo) throws Exception{
        System.out.println("service Call : " +memberVo.getUserNm());
        dao.insertMemberInfo(memberVo);
    }

}
