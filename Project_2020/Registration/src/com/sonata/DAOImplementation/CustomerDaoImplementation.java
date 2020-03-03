package com.sonata.DAOImplementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.sonata.DAO.CustomerDAO;
import com.sonata.Model.CustomerModel;

public class CustomerDaoImplementation  implements CustomerDAO  {
	/* static List<CustomerModel> reg=new LinkedList<CustomerModel>();
	private String password;
	private String username;
*/
	@Override
	public int addUser(Object object) {
		int row=0;
		try {
		CustomerModel cust=(CustomerModel)object;
		DBConnection db=new DBConnection ();
		PreparedStatement ps=db.getconnection().prepareStatement("insert into customer values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
	    ps.setInt(1,cust.getCustId());
	    ps.setString(2,cust.getFirstname());
	    ps.setString(3, cust.getLastname());
	    ps.setString(4, cust.getUsername());
	    ps.setString(5, cust.getPassword());
	   
	    ps.setInt(6, cust.getMobileno());
	    ps.setInt(7, cust.getAlternateMobNo());
	    
	    ps.setString(8, cust.getEmailId());
	    ps.setString(9, cust.getCountry());
	    ps.setString(10, cust.getState());
	    ps.setString(11, cust.getCity());
	    ps.setString(12, cust.getStreet());
	    ps.setInt(13, cust.getPinCode());
	   	 row=ps.executeUpdate();
		db.closeConnection();
	}catch(SQLException e) {System.out.println(e);}
		return row;
		}

    	@Override
	public boolean verify(String username, String passWord) throws SQLException  {
	try{
	CustomerModel cust=new CustomerModel();
	DBConnection db=new DBConnection ();
	PreparedStatement ps=db.getconnection().prepareStatement("");
	ps.setString(1, cust.getUsername());
    ps.setString(2, cust.getPassword());
	if(cust.getUsername()==username &&  cust.getPassword()==passWord)
	{System.out.println("Login successful");}
	else {System.out.println("invalid credentials");}
	     db.closeConnection();
	     }catch(SQLException e1) {System.out.println(e1);}
	return true;}

	@Override
	public boolean changeAddress(Object object) {
		
		try {
		CustomerModel cust=(CustomerModel)object;
		DBConnection db=new DBConnection ();
		PreparedStatement ps=db.getconnection().prepareStatement("update customer set country=(?) where custId=(?)");
		ps.setString(1,"America");
		ps.setInt(2, 101);
		int row = ps.executeUpdate();
		db.closeConnection();
		}catch(SQLException e1) {System.out.println(e1);}	
		return false;}

	@Override
	public boolean addtoCustomerGroup(int custId, int groupId) {
		try {
			CustomerModel cust=(CustomerModel)object;
			DBConnection db=new DBConnection ();
			
		
		return false;
	}

	@Override
	public List getCustomerDetails(int custId) {
		List <CustomerModel> b=new LinkedList<>();
		try {
		   
			DBConnection db=new DBConnection();
			PreparedStatement ps=db.getconnection().prepareStatement("select * from customer where custid=(?) ");
		     ps.setInt(1, 101);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				 CustomerModel cust=new CustomerModel();
	           int custid=rs.getInt(1);
				String Fname=rs.getString(2);
				String Lname= rs.getString(3);
				String uname=rs.getString(4);
				String pwd=rs.getString(5);
				int mobno=rs.getInt(6);
				int altno=rs.getInt(7);
				String mail=rs.getString(8);
				String country=rs.getString(9);
				String state=rs.getString(10);
				String city=rs.getString(11);
				String street=rs.getString(12);
				
				int pincode=rs.getInt(13);
				cust.setCustId(custid);
				cust.setFirst_name(Fname);
				cust.setLast_name(Lname);
				cust.setUsername(uname);
				cust.setPassword(pwd);
				cust.setMobileno(mobno);
				cust.setAlternateMobNo(altno);
				
				cust.setEmailId(mail);
				cust.setCountry(country);
				cust.setState(state);
				cust.setCity(city);
				cust.setStreet(street);
				cust.setPinCode(pincode);
				b.add(cust);}
				db.closeConnection();
				
			}catch(SQLException e1) {System.out.println(e1);
			}
			
			return b;
	
	}



	@Override
	public String toString() {
		return "CustomerDaoImplementation [toString()=" + super.toString() + "]";
	}
}


	