package com.sonata.DAO;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {

	public boolean verify(String username,String passWord) throws SQLException ;
	
	public int addUser(Object object) ;
	
	public  boolean changeAddress(Object object) ;
	
	public boolean addtoCustomerGroup(int custId,int groupId) ;
	
	public List getCustomerDetails(int custId) ;

}
