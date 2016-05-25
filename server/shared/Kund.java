package server.shared;

public class Kund{

private int id;
private String firstName;
private String lastName;
private String address;
private int phonenumber;
private String email;

/*public Kund(int id,String fn,String ln,
			String adr,int tfn, String epost){
	this.id=id;
	this.firstName=fn;
	this.lastName=ln;
	this.adress=adr;
	this.telefonnummer=tfn;
	this.epost=epost;

}*/
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

public int getPhoneNumber(){
	return telefonnummer;
}

public void setEmail(String email) {
	this.email=email;
}

public String getEmail(){
	return email;
}

public String toString() {
	return id+" "+firstName+" "+lastName+" "+address+" "+phonenumber+" "+email;
}


}