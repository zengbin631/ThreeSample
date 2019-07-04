package org.student.dao;

import org.student.entity.Student;
import org.student.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.student.util.DBUtil.preparedStatement;

public class StudentDao {
    //根绝学号修改学生
    public boolean updateStudentBySno(String sno,Student student){
        String sql="update student set stuname=?,stuage=?,stuaddress=? where stuid=?";
        Object[] objects={student.getStuname(),student.getStuage(),student.getStuaddress(),sno};
        return DBUtil.executeUpdate(sql,objects);
    }
    //删除学生
    public boolean deleteStudent(String sno){
        String sql="delete from student where stuid=?";
        Object[] objects={sno};
        return DBUtil.executeUpdate(sql,objects);
    }
    //判断学生是否存在
    public Boolean isExist(String sno){
        return queryStudentBySno(sno)==null?false:true;
    }
    //增加学生
    public boolean addStudent(Student student){
        String sql="insert into student values(?,?,?,?)";
        Object[] objects={student.getStuid(),student.getStuname(),student.getStuage(),student.getStuaddress()};
        return DBUtil.executeUpdate(sql,objects);
    }
    //根据学号查询学生
    public Student queryStudentBySno(String sno){
        Student student=null;
        ResultSet resultSet=null;
        try {
            String sql="select * from student where stuid=?";
            Object[] objects={sno};
            resultSet=DBUtil.executeQuery(sql,objects);
            if(resultSet.next()){
                String stuid=resultSet.getString("stuid");
                String stuname=resultSet.getString("stuname");
                int stuage = resultSet.getInt("stuage");
                String stuaddress=resultSet.getString("stuaddress");
                student=new Student(stuid,stuname,stuage,stuaddress);
            }
            return student;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            try {
                if(resultSet!=null){resultSet.close();}
                if(preparedStatement!=null){
                    preparedStatement.close();}
                if(DBUtil.connection!=null){DBUtil.connection.close();}
            }catch (SQLException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    //查询全部学生
    public List<Student> queryStudentAll(){
        List<Student> students=new ArrayList<>();
        Student student=null;
        ResultSet resultSet=null;
        try {
            String sql="select * from student";
            resultSet=DBUtil.executeQuery(sql,null);
            while(resultSet.next()){
                String stuid=resultSet.getString("stuid");
                String stuname=resultSet.getString("stuname");
                int stuage = resultSet.getInt("stuage");
                String stuaddress=resultSet.getString("stuaddress");
                student=new Student(stuid,stuname,stuage,stuaddress);
                students.add(student);
            }
            return students;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            try {
                if(resultSet!=null){resultSet.close();}
                if(preparedStatement!=null){
                    preparedStatement.close();}
                if(DBUtil.connection!=null){DBUtil.connection.close();}
            }catch (SQLException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    //查询总数据量
    public int getTotalCount(){
        String sql="select count(*) from student";
        return DBUtil.getTotalCount(sql);
    }
    //查询当前也集合
    public List<Student> queryStudentByPage(int currentPage,int pageSize){
        List<Student> students=new ArrayList<>();
        Student student=null;
        ResultSet resultSet=null;
        try{
            String sql="select * from student limit ?,?";
            Object[] objects={(currentPage-1)*pageSize,pageSize};
            resultSet = DBUtil.executeQuery(sql, objects);
            while(resultSet.next()){
                String stuid=resultSet.getString("stuid");
                String stuname=resultSet.getString("stuname");
                int stuage = resultSet.getInt("stuage");
                String stuaddress=resultSet.getString("stuaddress");
                student=new Student(stuid,stuname,stuage,stuaddress);
                students.add(student);
            }
            return students;
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            try {
                if(resultSet!=null){resultSet.close();}
                if(preparedStatement!=null){
                    preparedStatement.close();}
                if(DBUtil.connection!=null){DBUtil.connection.close();}
            }catch (SQLException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
