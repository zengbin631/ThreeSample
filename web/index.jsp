<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/4
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="org.student.entity.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息列表</title>
</head>
<body>
<table border="1">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>地址</th>
        <th>操作</th>
    </tr>
    <%
        List<Student> students=(List<Student>)request.getAttribute("students");
        for(Student student:students){
    %>
        <tr>
            <td><a href="QueryStudentBySnoServlet?sno=<%=student.getStuid()%>"><%=student.getStuid()%></a></td>
            <td><%=student.getStuname()%></td>
            <td><%=student.getStuage()%></td>
            <td><%=student.getStuaddress()%></td>
            <td><a href="DeleteStudentServlet?sno=<%=student.getStuid()%>">删除</a></td>
        </tr>
    <%
        }
    %>
</table>
<a href="add.jsp">新增</a>
<a href="QueryStudentByPageServlet?currentPage=1">首页</a>
<a href="QueryStudentByPageServlet?currentPage=<%=(Integer.parseInt((String)request.getAttribute("currentPage"))-1)%>">上一页</a>
<a href="QueryStudentByPageServlet?currentPage=<%=(Integer.parseInt((String)request.getAttribute("currentPage"))+1)%>">下一页</a>
<a href="QueryStudentByPageServlet?currentPage=<%=request.getAttribute("weiye")%>">尾页</a>
</body>
</html>
