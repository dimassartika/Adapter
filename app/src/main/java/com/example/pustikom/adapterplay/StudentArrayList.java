package com.example.pustikom.adapterplay;

import com.example.pustikom.adapterplay.com.example.pustikom.user.Student;

import java.util.ArrayList;

/**
 * Created by Dimas Sartika on 10/20/2016.
 */

public class StudentArrayList {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static StudentArrayList instance = new StudentArrayList();

    public static StudentArrayList getInstance(){
        return instance;
    }

    public static ArrayList<Student> getList(){
        return studentList;
    }
	
	//add student
    public void addStudent(Student student){
        student.setId(studentList.size()+1);
        studentList.add(student);
    }

    public int sizeStudentList(){
        return studentList.size();
        //ngitung size dr array list (nomerin dari nol)
    }
	//remove student
    public void clearStudentList(){
        studentList.clear();
    }
}
