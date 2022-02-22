package com.sketch.facultymodule2;

public class Students{
    private String StudentName;
    private String RollNo;
    private String Department;
    private String Years;
    private String Batches;
    private String Attendance;

    public Students(){}

    public Students(String studentName, String rollNo, String department, String years, String batches, String attendance) {
        StudentName = studentName;
        RollNo = rollNo;
        Department = department;
        Years = years;
        Batches = batches;
        Attendance= attendance;
    }

    public String getAttendance() {
        return Attendance;
    }

    public void setAttendance(String attendance) {
        Attendance = attendance;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String rollNo) {
        RollNo = rollNo;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getYears() {
        return Years;
    }

    public void setYears(String years) {
        Years = years;
    }

    public String getBatches() {
        return Batches;
    }

    public void setBatches(String batches) {
        Batches = batches;
    }
}
