package server.shared;

import java.util.*;

public class Customer{

private int id;
private String firstName;
private String lastName;
private String address;
private String phonenumber;
private String email;


//public ArrayList<Customer> customerlist = new ArrayList<Customer>();
//public ArrayList<Customer> customerlistall = new ArrayList<Customer>();

public Customer() {

}

public Customer(int id, String fn,String ln,
			String addr,String phone, String email) {
	this.id=id;
	this.firstName=fn;
	this.lastName=ln;
	this.address=addr;
	this.phonenumber=phone;
	this.email=email;

}
public void setID(int id) {
	this.id=id;
}

public int getID(){
	return id;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getFirstName(){
	return firstName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getLastName(){
	return lastName;
}

public void setAddress(String address) {
	this.address = address;
}

public String getAddress(){
	return address;
}

public void setPhoneNumber(String phonenumber) {
	this.phonenumber = phonenumber;
}

public String getPhoneNumber(){
	return phonenumber;
}

public void setEmail(String email) {
	this.email=email;
}

public String getEmail(){
	return email;
}


/*public boolean checkCustomerID (int id) {
		for (Customer cust : customerlistall) {
  			if (cust.getID() == id) {
   			return true; 
  			}
		}
	return false;
}*/

/*	public ArrayList<Customer> getCustomerList() {
		return customerlist;
	}

	public ArrayList<Customer> getCustomerListAll() {
		return customerlistall;
	}
*/

public String toString() {
	return id+" "+firstName+" "+lastName+" "+address+" "+phonenumber+" "+email;
}


}