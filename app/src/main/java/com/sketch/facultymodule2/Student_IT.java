package com.sketch.facultymodule2;

public class Student_IT {
    private String StudentName_IT;
    private String RollNo_IT;
    private String Department_IT;
    private String Years_IT;
    private String Batches_IT;
    private String Attendance_IT;

public Student_IT(){

}
    public String getStudentName_IT() {
        return StudentName_IT;
    }

    public void setStudentName_IT(String studentName_IT) {
        StudentName_IT = studentName_IT;
    }

    public String getRollNo_IT() {
        return RollNo_IT;
    }

    public void setRollNo_IT(String rollNo_IT) {
        RollNo_IT = rollNo_IT;
    }

    public String getDepartment_IT() {
        return Department_IT;
    }

    public void setDepartment_IT(String department_IT) {
        Department_IT = department_IT;
    }

    public String getYears_IT() {
        return Years_IT;
    }

    public void setYears_IT(String years_IT) {
        Years_IT = years_IT;
    }

    public String getBatches_IT() {
        return Batches_IT;
    }

    public void setBatches_IT(String batches_IT) {
        Batches_IT = batches_IT;
    }

    public String getAttendance_IT() {
        return Attendance_IT;
    }

    public void setAttendance_IT(String attendance_IT) {
        Attendance_IT = attendance_IT;
    }

    public Student_IT(String studentName_IT, String rollNo_IT, String department_IT, String years_IT, String batches_IT, String attendance_IT) {
        StudentName_IT = studentName_IT;
        RollNo_IT = rollNo_IT;
        Department_IT = department_IT;
        Years_IT = years_IT;
        Batches_IT = batches_IT;
        Attendance_IT = attendance_IT;

    }
}
