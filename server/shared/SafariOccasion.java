package server.shared;

import java.util.*;

public class SafariOccasion {

private String date;
private String lake;

/*private ArrayList<SafariOccasion> occasionlist = new ArrayList<SafariOccasion>();
private ArrayList<SafariOccasion> occasionlistall = new ArrayList<SafariOccasion>();*/

public SafariOccasion() {

}

public SafariOccasion(String lake, String date){
	
	//super(lake, minParticipants, maxParticipants, guide, price);
	this.lake=lake;
	this.date=date;
	/*this.lake=lake;
	this.minParticipants=minParticipants;
	this.maxParticipants=maxParticipants;
	this.guide=guide;
	this.price=price;*/

}

public void setDate(String date) {
	this.date=date;
}

public String getDate() {
	return date;
}

public void setLake(String lake) {
	this.lake=lake;
}

public String getLake() {
	return lake;
}

/*	public ArrayList<SafariOccasion> getOccasionListAll() {
		return occasionlistall;
	}
	
	public ArrayList<SafariOccasion> getOccasionList() {
		return occasionlist;
	}*/

public String toString() {
	return lake + date;
}

}