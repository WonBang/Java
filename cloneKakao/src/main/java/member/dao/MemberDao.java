package member.dao;

import member.vo.MemberVo;
import org.apache.ibatis.session.SqlSession;

public class MemberDao {

    private SqlSession sqlSession;

    public void insertMemberInfo(MemberVo memberVo) throws Exception{
        System.out.println("dao Call " +memberVo.getUserNm());
        sqlSession.insert("MemberDao.insertMemberInfo", memberVo);
    }
}
