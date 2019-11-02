<%--
  Created by IntelliJ IDEA.
  User: 94_wo
  Date: 2019-10-31
  Time: 오후 5:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>가입 페이지</title>

    <script type="text/javascript">

        function goSubmit(){
            var registForm = document.frm1;
            registForm.action = "/member/joinOk.do";
            registForm.submit();
        }
        function goCancel(){

        }
    </script>
</head>
<body>
    <form action="/member/joinOk.do" method="post" id="frm1" name="frm1">
        <table>
            <tr>
                <th>이름</th>
                <td><input type="text" name="userNm" id="userNm"/></td>
            </tr>
            <tr>
                <th>이메일</th>
                <td><input type="text" name="userId" id="userId"/></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><input type="text" name="userPw" id="userPw"/></td>
            </tr>
            <tr>
                <th>비밀번호 확인</th>
                <td><input type="text" name="chkUserPw" id="chkUserPw"/></td>
            </tr>
            <tr>
                <th>전화번호</th>
                <td><input type="text" name="phone" id="phone"/></td>
            </tr>
        </table>

        <input type="submit" name="submit" id="submit" value="확인" />
        <input type="button" name="cancel" id="cancel" value="뒤로" onclick="goCancel();"/>
    </form>
</body>
</html>
