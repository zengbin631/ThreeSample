<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/3
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>新增</title>
  </head>
  <body>
  <form action="AddStudentServlet" method="post">
    学号：<input type="text" name="sno"><br/>
    姓名：<input type="text" name="sname"><br/>
    年龄：<input type="text" name="sage"><br/>
    地址：<input type="text" name="saddress"><br/>
    <input type="submit" name="新增">
  </form>
  </body>
</html>
