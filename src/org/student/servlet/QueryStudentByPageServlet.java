package org.student.servlet;

import org.student.entity.Student;
import org.student.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QueryStudentByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentService studentService=new StudentService();
        int totalCount = studentService.getTotalCount();
        int pageSize=5;
        int size=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
        String currentPage=req.getParameter("currentPage");

        if(currentPage==null){
            currentPage="1";
        }else if(!(Integer.parseInt(currentPage)>0&&Integer.parseInt(currentPage)<=size)){
            currentPage="1";
        }else if ((totalCount%pageSize!=0)&&Integer.parseInt(currentPage)==size){
            pageSize=totalCount%pageSize;
        }
        List<Student> students = studentService.queryStudentByPage(Integer.parseInt(currentPage),pageSize);
        req.setAttribute("students",students);
        req.setAttribute("currentPage",currentPage);
        req.setAttribute("weiye",size);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
