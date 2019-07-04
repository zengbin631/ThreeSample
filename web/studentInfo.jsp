<%@ page import="org.student.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/4
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详情</title>
</head>
<body>
    <%
        Student student=(Student)request.getAttribute("student");
        %>
    <form action="UpdateStudentServlet" method="post">
        学号：<input type="text" name="sno" value="<%=student.getStuid()%>" readonly="readonly"><br/>
        姓名：<input type="text" name="sname" value="<%=student.getStuname()%>"><br/>
        年龄：<input type="text" name="sage" value="<%=student.getStuage()%>"><br/>
        地址：<input type="text" name="saddress" value="<%=student.getStuaddress()%>"><br/>
        <input type="submit" value="修改">
        <a href="QueryStudentByPageServlet">返回</a>
    </form>

</body>
</html>
