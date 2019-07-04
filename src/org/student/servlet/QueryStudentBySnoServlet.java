package org.student.servlet;

import org.student.entity.Student;
import org.student.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QueryStudentBySnoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sno= req.getParameter("sno");
        StudentService studentService=new StudentService();
        Student student = studentService.queryStudentBySno(sno);
        req.setAttribute("student",student);
        req.getRequestDispatcher("studentInfo.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
