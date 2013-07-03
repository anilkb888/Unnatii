package com.unnatii.in.services;

import java.util.List;

import com.unnatii.in.model.Template;

public interface TemplateService {
	
	public void addTemplate(Template template);
	public List<Template> listTemplate();
	public void removeTemplate(Integer id);
	public List<Template> listSpecificTemplate(Integer templateId);
}
