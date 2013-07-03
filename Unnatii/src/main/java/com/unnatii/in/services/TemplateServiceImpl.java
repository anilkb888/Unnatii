package com.unnatii.in.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unnatii.in.dao.TemplateDAO;
import com.unnatii.in.model.Template;

@Service
@Transactional
public class TemplateServiceImpl implements TemplateService {

	@Autowired
	private TemplateDAO templateDAO;
	
	@Required
	public void addTemplate(Template template) {
		templateDAO.addTemplate(template);
	}
	
	
	@Required
	public List<Template> listTemplate() {

		return templateDAO.listTemplate();
	}

	@Required
	public void removeTemplate(Integer id) {
		templateDAO.removeTemplate(id);
	}
	
	@Required
	public List<Template> listSpecificTemplate(Integer templateId) {

		return templateDAO.listSpecificTemplate(templateId);
	}
}
