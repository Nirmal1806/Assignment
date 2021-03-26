package com.EightK.assignment.dataaccess;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class MysqlDataAccess {
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired(required=false)
	EntityManagerFactory entityManagerFactory; 
	
	public Session getSession()
	{
		return (Session)em.getDelegate();
	}
	
	public void saveEntities(List<?> personData)
	{
		Session session = getSession();
		for(Object object : personData)
		{
			session.save(object);
		}
	}
	
	public Timestamp getTime()
	{
		List<Timestamp> currenTime = getSession().createSQLQuery("select sysdate() from dual").list();
		return currenTime.get(0);
	}

}
