package myfirsthibernatemaven._hibernateproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import myfirsthibernatemaven._hibernateproject.entity.Department;
import myfirsthibernatemaven._hibernateproject.entity.Student;
import myfirsthibernatemaven._hibernateproject.util.HibernateUtil;

public class DepartmentDao implements IDepartmentDao {

	SessionFactory factory = new Configuration().configure("/myfirsthibernatemaven/_hibernateproject/hibernate.cfg.xml").buildSessionFactory();
	
	@Override
	public void saveDepartment(Department department) {
		 Transaction transaction = null;
	        try{
	        	Session session = HibernateUtil.getSessionFactory().openSession();
	        	//Session session=factory.openSession();
	            // start the transaction
	            transaction = session.beginTransaction();

	            // save student object
	            session.save(department);

	            // commit the transaction
	            transaction.commit();
				/*
				 * factory.close(); session.close();
				 */
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
		
	}

	@Override
	public List<Department> getDepartmentList() {
		Transaction transaction = null;
        List < Department > departments = null;
        try {
        	Session session = HibernateUtil.getSessionFactory().openSession();
            // start the transaction
            transaction = session.beginTransaction();

            // get students
            departments = session.createQuery("from department").list();
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
			/*
			 * factory.close(); session.close();
			 */
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return departments;
	}

}
