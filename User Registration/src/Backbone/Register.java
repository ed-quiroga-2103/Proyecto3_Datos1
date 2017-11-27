package Backbone;

import java.io.File;

public class Register {

	private String path;
	
	Register(){
		
		this.path = path;
		
	}
	
	public boolean verification(String email, String pass, String userid, String first, String last) {
		
		if(!new File(System.getProperty("user.dir")+"/"+userid+".xml").exists()){
			
			User newUser = new User(email,pass,userid,first,last);
			
			System.out.println("done");
			
			return true;
		
		}
		
		else{
			
			System.out.println("User exists!");
			
			return false;
		
		}
		
	}
	
	public void login(String userid, String pass){
		
		if(new File(System.getProperty("user.dir")+"/"+userid+".xml").exists()){
			
			String[] data = new XMLManager().readXML(userid);
			
			if(data[3].equals(userid) & data[4].equals(pass)){
				
				
				System.out.println("Login successful!");
				
				for(int i = 0; i < data.length; i++){
					
					System.out.println(data[i]);
					
				}
			}
			
			else{
				
				System.out.println("User or password dont match!");
			}
				
			
		
		}
		
		else{
			
			System.out.println("User or password dont match!");
		
		}
		
		
	}
	
	

}
