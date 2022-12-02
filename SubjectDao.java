package myfirsthibernatemaven._hibernateproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import myfirsthibernatemaven._hibernateproject.entity.Student;
import myfirsthibernatemaven._hibernateproject.entity.Subject;
import myfirsthibernatemaven._hibernateproject.util.HibernateUtil;

public class SubjectDao implements ISubjectDao{
	
	SessionFactory factory = new Configuration().configure("/myfirsthibernatemaven/_hibernateproject/hibernate.cfg.xml").buildSessionFactory();

	@Override
	public void saveSubject(Subject subject) {
		 Transaction transaction = null;
	        try{
	        	Session session = HibernateUtil.getSessionFactory().openSession();
	        	//Session session=factory.openSession();
	            // start the transaction
	            transaction = session.beginTransaction();

	            // save student object
	            session.save(subject);

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
	public List<Subject> getSubList() {
		 Transaction transaction = null;
	        List < Subject > subject = null;
	        try {
	        	Session session = HibernateUtil.getSessionFactory().openSession();
	            // start the transaction
	            transaction = session.beginTransaction();

	            // get students
	            subject = session.createQuery("from Subject").list();
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
	        return subject;
	}

}
