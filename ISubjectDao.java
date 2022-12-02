package myfirsthibernatemaven._hibernateproject.dao;

import java.util.List;

import myfirsthibernatemaven._hibernateproject.entity.Subject;

public interface ISubjectDao {

	void saveSubject(Subject subject);
	
	List<Subject> getSubList();
}
