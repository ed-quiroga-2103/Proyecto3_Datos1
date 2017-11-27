package Backbone;

import java.io.File;

public class User {
	
	private String email;
	private String first;
	private String lastName;
	private String pass;
	private String userid;
	
	
	User(String email, String pass, String user, String name, String last){
		
		this.email = email;
		this.first = name;
		this.lastName = last;
		this.pass = pass;
		this.userid = user;
		
		if(!new File(System.getProperty("user.dir")+"/"+userid+".xml").exists()){
			
			this.createXML();
		
		}
		
	}
	
	
	private void createXML(){
		
		XMLManager manager = new XMLManager();
		
		manager.saveToXML(this.email, this.pass, this.userid, this.first, this.lastName);
		
		System.out.println("done");
		
	}
	
	public static void main(String[] args) {
		
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirst() {
		return first;
	}


	public void setFirst(String first) {
		this.first = first;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
//--------------------------------------------------------------------------------------------------
	
	
	
	


	




	

}
