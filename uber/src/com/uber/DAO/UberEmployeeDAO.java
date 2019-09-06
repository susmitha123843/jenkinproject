package com.uber.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.uber.entity.UberEmployee;

public class UberEmployeeDAO  implements UberEmployeeDAOInterface{



	public static UberEmployeeDAOInterface createObject() {

		return new UberEmployeeDAO();
	}

	@Override
	public int createProfileDAO(UberEmployee ue) {
		int i=0;
		//Connection con=null;
		try
		{
	     Context inictx=new InitialContext();
	     DataSource ds=(DataSource)  inictx.lookup("java:/zensar");
		Connection con=ds.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into uberEmployee values (?,?,?,?)");
		ps.setString(1, ue.getName());
		ps.setString(2, ue.getPassword());
		ps.setString(3, ue.getEmail());
		ps.setString(4, ue.getAddress());
		i=ps.executeUpdate();
		System.out.println(i);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}

	

}
