package myfirsthibernatemaven._hibernateproject.dao;
import java.util.List;

import myfirsthibernatemaven._hibernateproject.entity.Student;


public interface IStudentDao {

 void saveStudent(Student student);

 void updateStudent(Student student);

 Student getStudentById(long id);

 List<Student> getAllStudents();

 void deleteStudent(long id);

}