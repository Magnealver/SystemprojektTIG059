package server.sql;

import java.sql.*;
import java.awt.event.*;
import java.util.*;
import server.shared.*;
import server.util.*;


public class SQL {
	Statement s;
	PreparedStatement sm; 
	ResultSet rs;
	Connection c;
	DatabaseHandler database = new DatabaseHandler();
	Safari safari = new Safari();
	Customer customer = new Customer();
	Safaribooking booking = new Safaribooking();
	SafariOccasion occasion = new SafariOccasion();

	public ArrayList<Safari> safarilist = new ArrayList<Safari>();
	public ArrayList<Safari> safarilistall = new ArrayList<Safari>();
	public ArrayList<Customer> customerlist = new ArrayList<Customer>();
	public ArrayList<Customer> customerlistall = new ArrayList<Customer>();
	public ArrayList<SafariOccasion> occasionlist = new ArrayList<SafariOccasion>();
	public ArrayList<SafariOccasion> occasionlistall = new ArrayList<SafariOccasion>();
	public ArrayList<Safaribooking> bookinglist = new ArrayList<Safaribooking>();
	public ArrayList<Safaribooking> bookinglistall = new ArrayList<Safaribooking>();
	


	public void addSafari(String lake, int minparticipants, int maxparticipants, String guide, int price) {
		try {
		PreparedStatement sql = database.c.prepareStatement("INSERT INTO safari VALUES (?,?,?,?,?)");

   		sql.setString(1, lake);
   		sql.setInt(2, minparticipants);
  		sql.setInt(3, maxparticipants);
   		sql.setString(4, guide);     
   		sql.setInt(5, price);      	
		sql.executeUpdate();

   		} catch (SQLException sqle) {
   			System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}

	public void addSafaribooking(String lake, String date, int customerID, int bookingID) {
		try {
		PreparedStatement sql = database.c.prepareStatement("INSERT INTO safaribooking VALUES (?,?,?,?)");

   		sql.setString(1, lake);
   		sql.setString(2, date);
  		sql.setInt(3, customerID);
   		sql.setInt(4, bookingID);          	
		sql.executeUpdate();

   		} catch (SQLException sqle) {
   			System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}

	public void addSafariOccasion(String lake, String date) {
		try {
		PreparedStatement sql = database.c.prepareStatement("INSERT INTO safarioccasion VALUES (?,?)");
		sql.setString(1, lake);
		sql.setString(2, date);
		sql.executeUpdate();
		} catch (SQLException sqle) {
   			System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}

	public void removeSafariOccasion(String lake, String date) {
		try {
		PreparedStatement sql = database.c.prepareStatement("DELETE FROM safarioccasion WHERE lake = ? AND date = ?");
		sql.setString(1, lake);
		sql.setString(2, date);
		sql.executeUpdate();
		} catch (SQLException sqle) {
   			System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}

	public int createBookingID() throws SQLException {
		String sqlid = "SELECT max(bookingid) FROM safaribokning";
       	Statement stmtid = database.c.createStatement();
       	ResultSet idmax = stmtid.executeQuery( sqlid );
       	int id = 0;
		if (idmax.next()) {
  			id = idmax.getInt(1);  
		}
		id = id+1;
		return id;
	}

	public int createCustomerID() throws SQLException {
		String sqlid = "select max(id) from customer";
        Statement stmtid = database.c.createStatement();
        ResultSet idmax = stmtid.executeQuery( sqlid );
		int id = 0;
		if (idmax.next()) {
  			id = idmax.getInt(1);  
			}
		id = id+1;
		return id;
	}


	public void addSafariBooking(String lake, String date, int memberID, int bookingID) {
        try {
        PreparedStatement sql = database.c.prepareStatement("INSERT INTO safaribokning VALUES (?,?,?,?)");

        sql.setString(1, lake);
        sql.setString(2, date);
        sql.setInt(3, memberID);
        sql.setInt(4, bookingID);
        sql.executeUpdate();	
        } catch (SQLException sqle) {
   			System.out.println("SQL Error: "+sqle.getMessage());
   		}	
	}

	public void searchAllSafari() {
		try {
		safarilistall.clear();
		PreparedStatement sql = database.c.prepareStatement("SELECT * FROM safari");
      	ResultSet rs = sql.executeQuery();
      	while (rs.next()) {

      		safarilistall.add(new Safari(rs.getString("lake"), rs.getInt("minparticipants"),
      		 rs.getInt("maxparticipants"), rs.getString("guide"), rs.getInt("price")));
      	}
      	} catch (SQLException sqle) {
   			System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}

	public void searchAllOccasions() {
		try {
		occasionlistall.clear();
		PreparedStatement sql = database.c.prepareStatement("SELECT distinct lake, date FROM safarioccasion GROUP BY lake");
      	ResultSet rs = sql.executeQuery();
      	while (rs.next()) {

      		occasionlistall.add(new SafariOccasion(rs.getString("lake"), rs.getString("date")));
      	}
      	} catch (SQLException sqle) {
   			System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}


	public void searchOccasion(String lake) {
		try {
		occasionlist.clear();
		PreparedStatement sql = database.c.prepareStatement("SELECT distinct lake, date FROM safarioccasion WHERE lake = ?");
      	sql.setString(1, lake);
      	ResultSet rs = sql.executeQuery();
      	while (rs.next()) {

      		occasionlist.add(new SafariOccasion(rs.getString("lake"), rs.getString("date")));
      	}

      	} catch (SQLException sqle) {
      		System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}

	public void searchBooking(int customerID) {
		try {
		bookinglist.clear();
		PreparedStatement sql = database.c.prepareStatement("SELECT * FROM safaribokning WHERE customerid = ?");
      	sql.setInt(1, customerID);
      	ResultSet rs = sql.executeQuery();
      	while (rs.next()) {

      		bookinglist.add(new Safaribooking(rs.getString("lake"), rs.getString("date"), rs.getInt("customerid"), rs.getInt("bookingid")));
      	}

      	} catch (SQLException sqle) {
      		System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}


	public void searchSafari(String lake) {
		try {
		safarilist.clear();
		PreparedStatement sql = database.c.prepareStatement("SELECT * FROM safari WHERE lake = ?");
      	sql.setString(1, lake);
      	ResultSet rs = sql.executeQuery();
      	while (rs.next()) {

      		safarilist.add(new Safari(rs.getString("lake"),
      		 rs.getInt("minparticipants"), rs.getInt("maxparticipants"), rs.getString("guide"), rs.getInt("price")));
      	}

      	} catch (SQLException sqle) {
      		System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}

	public void removeBooking(int bookingid) {
		try {
		PreparedStatement sql = database.c.prepareStatement("DELETE FROM safaribokning WHERE bookingid = ?");
		sql.setInt(1, bookingid);
		sql.executeUpdate();
		} catch (SQLException sqle) {
   			System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}


	public void removeCustomer(int id) {
		try {
		PreparedStatement sql = database.c.prepareStatement("DELETE FROM customer WHERE id = ?");
		sql.setInt(1, id);
		sql.executeUpdate();
		} catch (SQLException sqle) {
   			System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}

	public void removeCustomer(String fname, String lname) {
		try {
		PreparedStatement sql = database.c.prepareStatement("DELETE FROM customer WHERE firstName = ? AND lastName = ?");
		sql.setString(1, fname);
		sql.setString(2, lname);
		sql.executeUpdate();
		} catch (SQLException sqle) {
   			System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}




	public void removeSafari(String lake) {
		try {
		PreparedStatement sql = database.c.prepareStatement("DELETE FROM safari WHERE lake = ?");
		sql.setString(1, lake);
		sql.executeUpdate();
		} catch (SQLException sqle) {
   			System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}




	public void addCustomer(int id, String fn,String ln,
			String addr,String phone, String email) {
		try {

		PreparedStatement sql = database.c.prepareStatement("INSERT INTO customer VALUES (?,?,?,?,?,?)");

		sql.setInt(1, id);
   		sql.setString(2, fn);
   		sql.setString(3, ln);
  		sql.setString(4, addr);
   		sql.setString(5, phone);     
   		sql.setString(6, email);      	
		sql.executeUpdate();

   		} catch (SQLException sqle) {
   			System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}

	public void searchCustomer(int id) {
		try {
		customerlist.clear();
		PreparedStatement sql = database.c.prepareStatement("SELECT * FROM customer WHERE id = ?");
      	sql.setInt(1, id);
      	ResultSet rs = sql.executeQuery();
      	while (rs.next()) {

      		customerlist.add(new Customer(rs.getInt("id"), rs.getString("firstName"), 
      			rs.getString("lastName"), rs.getString("address"), rs.getString("phonenumber"), rs.getString("email")));
      	}

      	} catch (SQLException sqle) {
      		System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}

	public void searchCustomer(String firstName, String lastName) {
		try {
		customerlist.clear();
		PreparedStatement sql = database.c.prepareStatement("SELECT * FROM customer WHERE firstName = ? AND lastName = ?");
      	sql.setString(1, firstName);
      	sql.setString(2, lastName);
      	ResultSet rs = sql.executeQuery();
      	while (rs.next()) {

      		customerlist.add(new Customer(rs.getInt("id"), rs.getString("firstName"), 
      			rs.getString("lastName"), rs.getString("address"), rs.getString("phonenumber"), rs.getString("email")));
      	}

      	} catch (SQLException sqle) {
      		System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}

	public void searchAllCustomers() {
		try {
		customerlistall.clear();
		PreparedStatement sql = database.c.prepareStatement("SELECT * FROM customer");
      	
      	ResultSet rs = sql.executeQuery();
      	while (rs.next()) {

      		customerlistall.add(new Customer(rs.getInt("id"), rs.getString("firstName"), 
      			rs.getString("lastName"), rs.getString("address"), rs.getString("phonenumber"), rs.getString("email")));
      	}

      	} catch (SQLException sqle) {
      		System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}

	public boolean checkCustomerID (int id) {
		for (Customer cust : customerlistall) {
  			if (cust.getID() == id) {
   			return true; 
  			}
		}
	return false;
	}

	public void updateSafariMinParticipants(int minparticipants, String lake) {
		try {
			PreparedStatement sql = database.c.prepareStatement("UPDATE safari SET minParticipants = ? WHERE lake = ?");
			sql.setInt(1, minparticipants);
			sql.setString(2, lake);
			sql.executeUpdate();
		} catch (SQLException sqle) {
   			System.out.println("SQL Error: "+sqle.getMessage());
   		}

	}

	public void updateSafariMaxParticipants(int maxparticipants, String lake) {
		try {
			PreparedStatement sql = database.c.prepareStatement("UPDATE safari SET maxParticipants = ? WHERE lake = ?");
			sql.setInt(1, maxparticipants);
			sql.setString(2, lake);
			sql.executeUpdate();
		} catch (SQLException sqle) {
   			System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}

	public void updateSafariGuide(String guide, String lake) {
		try {
			PreparedStatement sql = database.c.prepareStatement("UPDATE safari SET guide = ? WHERE lake = ?");
			sql.setString(1, guide);
			sql.setString(2, lake);
			sql.executeUpdate();
		} catch (SQLException sqle) {
   			System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}

	public void updateSafariPrice(int price, String lake) {
		try {
			PreparedStatement sql = database.c.prepareStatement("UPDATE safari SET price = ? WHERE lake = ?");
			sql.setInt(1, price);
			sql.setString(2, lake);
			sql.executeUpdate();
		} catch (SQLException sqle) {
   			System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}

	public void updateCustomerFName(String fname, int id) {
		try {
			PreparedStatement sql = database.c.prepareStatement("UPDATE customer SET firstName = ? WHERE id = ?");
			sql.setString(1, fname);
			sql.setInt(2, id);
			sql.executeUpdate();
		} catch (SQLException sqle) {
   			System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}

	public void updateCustomerLName(String lname, int id) {
		try {
			PreparedStatement sql = database.c.prepareStatement("UPDATE customer SET lastName = ? WHERE id = ?");
			sql.setString(1, lname);
			sql.setInt(2, id);
			sql.executeUpdate();
		} catch (SQLException sqle) {
   			System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}

	public void updateCustomerAddress(String address, int id) {
		try {
			PreparedStatement sql = database.c.prepareStatement("UPDATE customer SET address = ? WHERE id = ?");
			sql.setString(1, address);
			sql.setInt(2, id);
			sql.executeUpdate();
		} catch (SQLException sqle) {
   			System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}

	public void updateCustomerPhone(String phonenumber, int id) {
		try {
			PreparedStatement sql = database.c.prepareStatement("UPDATE customer SET phonenumber = ? WHERE id = ?");
			sql.setString(1, phonenumber);
			sql.setInt(2, id);
			sql.executeUpdate();
		} catch (SQLException sqle) {
   			System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}

	public void updateCustomerEmail(String email, int id) {
		try {
			PreparedStatement sql = database.c.prepareStatement("UPDATE customer SET email = ? WHERE id = ?");
			sql.setString(1, email);
			sql.setInt(2, id);
			sql.executeUpdate();
		} catch (SQLException sqle) {
   			System.out.println("SQL Error: "+sqle.getMessage());
   		}
	}

	public ArrayList<Safari> getSafariList() {
		return safarilist;
	}

	public ArrayList<Safari> getSafariListAll() {
		return safarilistall;
	}
	public ArrayList<Customer> getCustomerList() {
		return customerlist;
	}

	public ArrayList<Customer> getCustomerListAll() {
		return customerlistall;
	}

	public ArrayList<SafariOccasion> getOccasionListAll() {
		return occasionlistall;
	}

	public ArrayList<SafariOccasion> getOccasionList() {
		return occasionlist;
	}

	public ArrayList<Safaribooking> getBookingList() {
		return bookinglist;
	}


}
