package com.unnatii.in.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unnatii.in.dao.SpecDAO;
import com.unnatii.in.model.SpecSheet;

@Service
@Transactional
public class SpecServiceImpl implements SpecService {

	@Autowired
	private SpecDAO specDAO;
	
	@Required
	public void addSpec(SpecSheet specsheet) {
		specDAO.addSpec(specsheet);
	}

	@Required
	public List<SpecSheet> listSpecSheet() {

		return specDAO.listSpecSheet();
	}

	@Required
	public void removeSpec(Integer id) {
		specDAO.removeSpec(id);
	}

	
}
