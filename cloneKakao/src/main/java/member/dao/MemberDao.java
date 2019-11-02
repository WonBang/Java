package member.dao;

import member.vo.MemberVo;
import org.apache.ibatis.session.SqlSession;

public class MemberDao {

    private SqlSession sqlSession;

    public void insertMemberInfo(MemberVo memberVo) throws Exception{
        sqlSession.insert("MemberDao.insertMemberInfo", memberVo);
    }
}
