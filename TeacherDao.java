package myfirsthibernatemaven._hibernateproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import myfirsthibernatemaven._hibernateproject.entity.Subject;
import myfirsthibernatemaven._hibernateproject.entity.Teacher;
import myfirsthibernatemaven._hibernateproject.util.HibernateUtil;

public class TeacherDao implements ITeacherDao {

	SessionFactory factory = new Configuration().configure("/myfirsthibernatemaven/_hibernateproject/hibernate.cfg.xml").buildSessionFactory();

	
	@Override
	public void saveTeacher(Teacher teacher) {
		 Transaction transaction = null;
	        try{
	        	Session session = HibernateUtil.getSessionFactory().openSession();
	        	//Session session=factory.openSession();
	            // start the transaction
	            transaction = session.beginTransaction();

	            // save student object
	            session.save(teacher);

	            // commit the transaction
	            transaction.commit();
	            factory.close();
	            session.close();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }

	}

	@Override
	public List<Teacher> getTeacherList() {
		Transaction transaction = null;
        List < Teacher > teachers = null;
        try {
        	Session session = HibernateUtil.getSessionFactory().openSession();
            // start the transaction
            transaction = session.beginTransaction();

            // get students
            teachers = session.createQuery("from Teacher").list();
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
        return teachers;
	}

}
