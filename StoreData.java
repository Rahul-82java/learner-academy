package myfirsthibernatemaven._hibernateproject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.Metadata;
import org.hibernate.metamodel.MetadataSources;

import net.sf.ehcache.hibernate.HibernateUtil;

public class StoreData {
	public static void main(String[] args) {
		try {
			@SuppressWarnings("deprecation")
			SessionFactory factory = new Configuration().configure
			("/myfirsthibernatemaven/_hibernateproject/hibernate.cfg.xml").buildSessionFactory();
		Session session=factory.openSession();//open a sessions
		Transaction t= session.beginTransaction();
			
		MyfirstPersistance obj= new MyfirstPersistance();
		obj.setFirstName("Rama");
		obj.setId(12);
		obj.setLastName("prasad");
		session.save(obj);
		t.commit();
		factory.close();
		//session.close();
		}catch(

	Exception e)
	{
		e.printStackTrace();
	}
}}