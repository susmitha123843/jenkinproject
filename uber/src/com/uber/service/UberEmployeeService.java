package com.uber.service;

import com.uber.DAO.UberEmployeeDAO;
import com.uber.DAO.UberEmployeeDAOInterface;
import com.uber.entity.UberEmployee;

public class UberEmployeeService implements UberEmployeeServiceInterface  {

	public static UberEmployeeServiceInterface createObject(UberEmployee ue) {
		
		return new UberEmployeeService();
	}

	@Override
	public int createProfile(UberEmployee ue) {
		UberEmployeeDAOInterface ud=UberEmployeeDAO.createObject();
		int i=ud.createProfileDAO(ue);
		return i;
	}


}
