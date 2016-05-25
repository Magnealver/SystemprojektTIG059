package server.shared;

import java.util.ArrayList;

public class Safari{

protected String lake;
protected int minParticipants;
protected int maxParticipants;
protected String guide;
protected int price;

//public ArrayList<Safari> safarilist = new ArrayList<Safari>();
//public ArrayList<Safari> safarilistall = new ArrayList<Safari>();

public Safari() {

}

public Safari(String lake, int minParticipants, int maxParticipants, String guide, int price){
	this.lake=lake;
	this.minParticipants=minParticipants;
	this.maxParticipants=maxParticipants;
	this.guide=guide;
	this.price=price;

}

public String getLake() {
	return lake;
}

public void setLake(String lake) {
	this.lake=lake; 
}

public int getMinParticipants() {
	return minParticipants;

}  

public void setMinParticipants(int minParticipants) {
	this.minParticipants = minParticipants;
}

public int getMaxParticipants(){
	return maxParticipants;

} 

public void setMaxParticipants(int maxParticipants) {
	this.maxParticipants = maxParticipants;
}

public String getGuide(){
	return guide;

} 

public void setGuide(String guide) {
	this.guide = guide;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

/*public ArrayList<Safari> getList() {
	return safarilist;
}

public void addToList(Safari safari) {
	safarilist.add(safari);
}


public ArrayList<Safari> getSafariList() {
		return safarilist;
	}

	public ArrayList<Safari> getSafariListAll() {
		return safarilistall;
	}*/

public String toString() {
	return lake+" "+minParticipants+" "+maxParticipants+" "+guide+" "+price;
}

}