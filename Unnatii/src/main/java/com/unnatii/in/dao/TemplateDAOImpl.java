package com.unnatii.in.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unnatii.in.model.Template;

@Repository
public class TemplateDAOImpl implements TemplateDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addTemplate(Template template) {
		sessionFactory.getCurrentSession().save(template);
		//sessionFactory.getCurrentSession().getTransaction().commit();
	}

	public List<Template> listTemplate() {
		
		Query qry;
		qry=sessionFactory.getCurrentSession().createQuery("from Template ORDER BY ID DESC");
		//qry.setFirstResult(startPoint);
		//qry.setMaxResults();
		return qry.list();
		//return sessionFactory.getCurrentSession().createQuery("from Template")
			//	.list();
		
				//return sessionFactory.getCurrentSession().createQuery("").list();
	}

public List<Template> listSpecificTemplate(Integer templateId) {
		
		Query qry;
		qry=sessionFactory.getCurrentSession().createQuery("from Template where ID =" + templateId );
		//qry.setFirstResult(startPoint);
		//qry.setMaxResults();
		return qry.list();
		//return sessionFactory.getCurrentSession().createQuery("from Template")
			//	.list();
		
				//return sessionFactory.getCurrentSession().createQuery("").list();
	}
	
	public void removeTemplate(Integer id) {
		Template template = (Template) sessionFactory.getCurrentSession().load(
				Template.class, id);
		if (null != template) {
			sessionFactory.getCurrentSession().delete(template);
		}

	}
}
