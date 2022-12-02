package myfirsthibernatemaven._hibernateproject.dao;

import java.util.List;

import myfirsthibernatemaven._hibernateproject.entity.Teacher;

public interface ITeacherDao {

void saveTeacher(Teacher teacher);
	
	List<Teacher> getTeacherList();
}
