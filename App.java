package myfirsthibernatemaven._hibernateproject;

import java.util.List;

import myfirsthibernatemaven._hibernateproject.dao.DepartmentDao;
import myfirsthibernatemaven._hibernateproject.dao.IDepartmentDao;
import myfirsthibernatemaven._hibernateproject.dao.IStudentDao;
import myfirsthibernatemaven._hibernateproject.dao.ISubjectDao;
import myfirsthibernatemaven._hibernateproject.dao.ITeacherDao;
import myfirsthibernatemaven._hibernateproject.dao.StudentDao;
import myfirsthibernatemaven._hibernateproject.dao.SubjectDao;
import myfirsthibernatemaven._hibernateproject.dao.TeacherDao;
import myfirsthibernatemaven._hibernateproject.entity.Department;
import myfirsthibernatemaven._hibernateproject.entity.Student;
import myfirsthibernatemaven._hibernateproject.entity.Subject;
import myfirsthibernatemaven._hibernateproject.entity.Teacher;

public class App {

	public static void main(String[] args) {

		Department department = new Department();
		department.setName("Electrical");

		IStudentDao studentDao = new StudentDao();

		Student student = new Student();
		student.setEmail("jesika@gmail.com");
		student.setFirstName("jesika");
		student.setLastName("tyson");
		student.setDepartment(department);

		studentDao.saveStudent(student);

		List<Student> students = studentDao.getAllStudents();
		students.forEach(student1 -> System.out.println("#####" + student1));

		// lets save subject
		Subject subject = new Subject();
		subject.setSubjectName("electronics");
		subject.setDepartment(department);

		ISubjectDao subjectDao = new SubjectDao();
		subjectDao.saveSubject(subject);

		List<Subject> subjects = subjectDao.getSubList();
		subjects.forEach(student1 -> System.out.println("@@@@Subject list for all the classes :-" + student1));
		
		// lets deal with teacher
		Teacher teacher = new Teacher();
		teacher.setDepartment(department);
		teacher.setTeacherName("Robin Desuza");
		
		ITeacherDao teacherDao = new TeacherDao();
		teacherDao.saveTeacher(teacher);
		
		//get teacher list for all classes
		teacherDao.getTeacherList().forEach(teach -> System.out.println("&&&&Teacher list for all the classes :-"+teach));

		
		

	}
}