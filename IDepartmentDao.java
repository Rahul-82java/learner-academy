package myfirsthibernatemaven._hibernateproject.dao;

import java.util.List;

import myfirsthibernatemaven._hibernateproject.entity.Department;

public interface IDepartmentDao {

	void saveDepartment(Department department);
	
	List<Department> getDepartmentList();
}
