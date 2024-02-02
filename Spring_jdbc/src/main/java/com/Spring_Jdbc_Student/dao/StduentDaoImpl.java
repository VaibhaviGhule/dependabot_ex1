package com.Spring_Jdbc_Student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.Spring_Jdbc_Student.model.Student;

public class StduentDaoImpl implements StudentDao
{

	JdbcTemplate jt;

	public void setJt(JdbcTemplate jt)
	{
		this.jt = jt;
	}

	@Override
	public int saveStudent(Student student)
	{
		return jt.update("INSERT INTO STUDENT VALUES ("+student.getRoll()+",'"+student.getName()+"',"+student.getMarks()+")");
	}

	@Override
	public int deleteStudent(int roll)
	{
		return jt.update("DELETE FROM STUDENT WHERE rollno = "+roll);
	}

	@Override
	public int updateStudent(int roll,String name,float marks)
	{
		return jt.update("UPDATE STUDENT SET name = "+name+" , marks = "+marks+" WHERE rollno = "+roll);
	}

	@Override
	public List<Student> getStudentbyRoll(int roll) 
	{
		return jt.query("SELECT * FROM STUDENT WHERE rollno = "+roll,new StudentRowMapper());
	}

	@Override
	public List<Student> getAllStudent()
	{
		return jt.query("SELECT * FROM STUDENT ",new StudentRowMapper());
	}
	
}
final class StudentRowMapper implements RowMapper<Student>
{
	@Override
	public Student mapRow(ResultSet rs, int rownum) throws SQLException
	{
		Student s = new Student();
		s.setRoll(rs.getInt(1));
		s.setName(rs.getString(2));
		s.setMarks(rs.getFloat(3));
		return s;
	}
}
