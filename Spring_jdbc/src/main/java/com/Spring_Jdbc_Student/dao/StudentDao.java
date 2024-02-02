package com.Spring_Jdbc_Student.dao;

import java.util.List;

import com.Spring_Jdbc_Student.model.Student;

public interface StudentDao 
{
	public int saveStudent(Student student);
	public int deleteStudent(int roll);
	public int updateStudent(int roll,String name,float marks);
	public List<Student> getStudentbyRoll(int roll);
	public List<Student> getAllStudent();
}
