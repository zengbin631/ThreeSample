package org.student.service;

import org.student.dao.StudentDao;
import org.student.entity.Student;

import java.util.List;

public class StudentService {
    StudentDao studentDao=new StudentDao();

    public Student queryStudentBySno(String sno){
        return studentDao.queryStudentBySno(sno);
    }
    public List<Student> queryStudentAll(){
        return studentDao.queryStudentAll();
    }
    public boolean updateStudentBySno(String sno,Student student){
        if(studentDao.isExist(sno)){
            return studentDao.updateStudentBySno(sno,student);
        }
        return false;
    }
    public boolean deleteStudent(String sno){
        if(studentDao.isExist(sno)){
            return studentDao.deleteStudent(sno);
        }
        return false;
    }
    public boolean addStudent(Student student){
        if(!studentDao.isExist(student.getStuid())){
            return studentDao.addStudent(student);
        }
        return false;
    }
    public int getTotalCount(){
        return studentDao.getTotalCount();
    }
    public List<Student> queryStudentByPage(int currentPage,int pageSize){
        return studentDao.queryStudentByPage(currentPage,pageSize);
    }
}
