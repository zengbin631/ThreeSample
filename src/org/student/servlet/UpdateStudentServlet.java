package org.student.servlet;

import org.student.entity.Student;
import org.student.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String sno=req.getParameter("sno");
        String sname=req.getParameter("sname");
        int sage=Integer.parseInt(req.getParameter("sage"));
        String saddress=req.getParameter("saddress");
        Student student=new Student(sname,sage,saddress);
        StudentService studentService=new StudentService();
        boolean b = studentService.updateStudentBySno(sno, student);
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        if(b){
            resp.sendRedirect("QueryStudentByPageServlet");
        }else{
            out.print("修改失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
