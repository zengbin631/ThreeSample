package org.student.servlet;

import org.student.entity.Student;
import org.student.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String stuid=req.getParameter("sno");
        String stuname=req.getParameter("sname");
        int stuage=Integer.parseInt(req.getParameter("sage"));
        String stuaddress = req.getParameter("saddress");
        Student student=new Student(stuid,stuname,stuage,stuaddress);
        StudentService studentService=new StudentService();
        boolean b = studentService.addStudent(student);
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        if(b){
//            out.print("增加成功");
            resp.sendRedirect("QueryStudentByPageServlet");
        }else{
            out.print("增加失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
