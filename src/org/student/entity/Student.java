package org.student.entity;

public class Student {
    private String stuid;
    private String stuname;
    private int stuage;
    private String stuaddress;
    public Student() {
    }
    public Student(String stuname, int stuage, String stuaddress) {
        this.stuname = stuname;
        this.stuage = stuage;
        this.stuaddress = stuaddress;
    }
    public Student(String stuid, String stuname, int stuage, String stuaddress) {
        this.stuid = stuid;
        this.stuname = stuname;
        this.stuage = stuage;
        this.stuaddress = stuaddress;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public int getStuage() {
        return stuage;
    }

    public void setStuage(int stuage) {
        this.stuage = stuage;
    }

    public String getStuaddress() {
        return stuaddress;
    }

    public void setStuaddress(String stuaddress) {
        this.stuaddress = stuaddress;
    }

    @Override
    public String toString() {
        return this.getStuid()+"-"+this.getStuname()+"-"+this.getStuage()+"-"+this.getStuaddress();
    }
}
