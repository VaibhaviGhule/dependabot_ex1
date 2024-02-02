package com.Spring_Jdbc_Student;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Spring_Jdbc_Student.dao.StudentDao;
import com.Spring_Jdbc_Student.model.Student;

public class App 
{
    public static void main( String[] args)
    {
    	ApplicationContext con = new ClassPathXmlApplicationContext("com/SpringJdbcStudent/config/applicationContext.xml");
    	StudentDao std = (StudentDao)con.getBean("studentDao");
    	Scanner sc = new Scanner(System.in);
    	do
    	{
    		System.out.println("1 : To Insert the Student");
    		System.out.println("2 : To Update the Student");
    		System.out.println("3 : To Delete the Student");
    		System.out.println("4 : To Display all records");
    		System.out.println("5 : To fetch student by roll number");
    		System.out.println("6 : To EXIT");
    		System.out.print("\nEnter your choice : ");
    		int choice = sc.nextInt();
    		switch(choice)
    		{
    			case 1 : System.out.println("Enter Student roll number , student name , student marks");
    					 Student stud = new Student(sc.nextInt(),sc.next(),sc.nextFloat());
    					 int save = std.saveStudent(stud);
    					 System.out.println("\nStudent Inserted Sucessfully....");
    					 break;
    		         
    			case 2 : System.out.println("Enter Student roll number , student name , student marks");
    					 int update = std.updateStudent(sc.nextInt(),sc.next(),sc.nextFloat());
    					 System.out.println("\nStudent Updated Sucessfully....");
    					 break;
    					 
    			case 3 : System.out.println("Enter Student Roll number to delete record : ");
    			         int delete = std.deleteStudent(sc.nextInt());
    			         System.out.println("Student Deleted Sucessfully.....");
    			         break;
    			         
    			case 4 : List<Student> student = std.getAllStudent();
    				     Iterator<Student> it = student.iterator();
    				     while(it.hasNext())
    				    	 System.out.println(it.next());
    				     break;
    			        
    			case 5 : System.out.println("Enter Student roll number to fetch it's record : ");
    					 List<Student> fetch = std.getStudentbyRoll(sc.nextInt());
		         		 System.out.println(fetch);
		         		 break;
    				     
    			case 6 : System.exit(0);
    		}         
    	}
    	while(true);
    }
}
