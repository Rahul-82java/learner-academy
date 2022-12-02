package myfirsthibernatemaven._hibernateproject.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.Metadata;
import org.hibernate.metamodel.MetadataSources;


import myfirsthibernatemaven._hibernateproject.entity.Student;
import myfirsthibernatemaven._hibernateproject.util.HibernateUtil;


public class StudentDao implements IStudentDao {

    // save Student
    // get All Students
    // get Student By Id
    // Update Student
    // Delete Student

	@SuppressWarnings("deprecation")
	SessionFactory factory = new Configuration().configure("/myfirsthibernatemaven/_hibernateproject/hibernate.cfg.xml").buildSessionFactory();
    @Override
    public void saveStudent(Student student) {
        Transaction transaction = null;
        try{
        	Session session = HibernateUtil.getSessionFactory().openSession();
        	//Session session=factory.openSession();
            // start the transaction
            transaction = session.beginTransaction();

            // save student object
            session.save(student);

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

    /* (non-Javadoc)
     * @see net.javaguides.hibernate.dao.IStudentDao#updateStudent(net.javaguides.hibernate.model.Student)
     */
    @Override
    public void updateStudent(Student student) {
        Transaction transaction = null;
        try  {
        	Session session = HibernateUtil.getSessionFactory().openSession();
            // start the transaction
            transaction = session.beginTransaction();

            // save student object
            session.saveOrUpdate(student);

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

    /* (non-Javadoc)
     * @see net.javaguides.hibernate.dao.IStudentDao#getStudentById(long)
     */
    @Override
    public Student getStudentById(long id) {
        Transaction transaction = null;
        Student student = null;
        try  {
        	Session session = HibernateUtil.getSessionFactory().openSession();
            // start the transaction
            transaction = session.beginTransaction();

            // get student object
            student = (Student)session.get(Student.class, id);
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
            factory.close();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return student;
    }

    /* (non-Javadoc)
     * @see net.javaguides.hibernate.dao.IStudentDao#getAllStudents()
     */
    @Override
    @SuppressWarnings("unchecked")
    public List < Student > getAllStudents() {
        Transaction transaction = null;
        List < Student > students = null;
        try {
        	Session session = HibernateUtil.getSessionFactory().openSession();
            // start the transaction
            transaction = session.beginTransaction();

            // get students
            students = session.createQuery("from Student").list();
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
        return students;
    }

    /* (non-Javadoc)
     * @see net.javaguides.hibernate.dao.IStudentDao#deleteStudent(long)
     */
    @Override
    public void deleteStudent(long id) {
        Transaction transaction = null;
        Student student = null;
        try {
        	
        	Session session = HibernateUtil.getSessionFactory().openSession();
            // start the transaction
            transaction = session.beginTransaction();

            student = (Student)session.get(Student.class, id);
            // get student object
            session.delete(student);
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
    }
}