package com.unnatii.in.dao;

import java.util.List;

import com.unnatii.in.model.SpecSheet;

public interface SpecDAO {
	
	public void addSpec(SpecSheet specsheet);
	public List<SpecSheet> listSpecSheet();
	public void removeSpec(Integer id);
}
