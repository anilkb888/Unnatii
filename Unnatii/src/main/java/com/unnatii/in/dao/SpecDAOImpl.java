package com.unnatii.in.dao;

import java.util.List;

import com.unnatii.in.model.SpecSheet;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SpecDAOImpl implements SpecDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addSpec(SpecSheet specsheet) {
		
		sessionFactory.getCurrentSession().save(specsheet);
	}

	public List<SpecSheet> listSpecSheet() {
		return sessionFactory.getCurrentSession().createQuery("from quoteRequest").list();
	}

	public void removeSpec(Integer id) {
		SpecSheet specsheet = (SpecSheet) sessionFactory.getCurrentSession().load(
				SpecSheet.class, id);
		if (null != specsheet) {
			sessionFactory.getCurrentSession().delete(specsheet);
		}

	}
}
