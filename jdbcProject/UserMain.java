package jdbcProject;

import java.util.Scanner;

public class UserMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		UserCRUD crud=new UserCRUD();
	    boolean flag=true;
	    
	do {
		System.out.println("Select one option:");
		System.out.println("1: Sign Up");
		System.out.println("2: Login");
		System.out.println("3: Exit");
		int choice =scanner.nextInt();
		  
		User user=new User();
		 
		switch(choice) {
		  
// SIGN IN
		  case 1:{
			  
				System.out.println("enter the id");
				int id=scanner.nextInt();
				System.out.println("enter the username");
				String username=scanner.next();
				System.out.println("enter the email");
				String email=scanner.next();
				System.out.println("enter the password");
				String password=scanner.next();
				System.out.println("enter the address");
				String address=scanner.next();	
				
				user.setId(id);
				user.setUsername(username);
				user.setEmail(email);
				user.setPassword(password);
				user.setAddress(address);	
				
			    try {
					crud.signUser(user);
				} 
			    catch (Exception e) {
					System.out.println("Handled in sign in");
				}
		  }
		  break;

//LOGIN  
		  case 2:{
			 
			   System.out.println("enter the email");
			   String email=scanner.next();
			   System.out.println("enter the password");
			   String password=scanner.next();
			   
			   user.setEmail(email);
			   user.setPassword(password);
			   
			   try {
				boolean logic = crud.loginUser(user);
				
				if(logic==true) {
					System.out.println("Login Successfull!!!");
					System.out.println("Press 1 - New User");
					System.out.println("press 2 - Existing User");
					
					switch(scanner.nextInt()) {
			
			// NEW USER	
					case 1:{
						   System.out.println("Enter the Facebook password: ");
		            	   String facebookpwd=scanner.next();
		            	   System.out.println("Enter the Instagram password: ");
		            	   String instagrampwd=scanner.next();
		            	   System.out.println("Enter the Snapchat password: ");
		            	   String snapchatpwd=scanner.next();
		            	   System.out.println("Enter the Whatsapp password: ");
		            	   String whatsappwd=scanner.next();
		            	   System.out.println("Enter the Twitter password: ");
		            	   String twitterpwd=scanner.next();
		            	   
		            	   user.setFacebookpwd(facebookpwd);
		            	   user.setWhatsapppwd(whatsappwd);
		            	   user.setInstagrampwd(instagrampwd);
		            	   user.setSnapchatpwd(snapchatpwd);
		            	   user.setTwitterpwd(twitterpwd);
		            	   crud.setPwd(user);
					}
					break;
					
		   // EXISTING USER
					case 2:{
						   System.out.println("your details are");
						   crud.displayPwd(user);
						   System.out.println("press 1 to change the password");
						   System.out.println("press 2 to delete this account");
						   System.out.println("press 3 for no changes  ");
						   
						   switch(scanner.nextInt()) {
						   
				    // CHANGE THE PASSWORD
						   case 1:{
							   System.out.println("Select one option: ");
							   System.out.println("1: to change Facebook password ");
							   System.out.println("2: to change Instagram password");
							   System.out.println("3: to change Snapchat password");
							   System.out.println("4: to change Whatsapp password");
							   System.out.println("5: to change Twitter password");
							   System.out.println("6: if you dont want to change ");
							   int passchoice=scanner.nextInt();
							   
							   switch(passchoice) {
							   case 1:{
								   System.out.println("Enter new Facebook password");
								   String facebookpassword=scanner.next();
								   user.setFacebookpwd(facebookpassword);
								   crud.updateFacebookPwd(user);
							   }
							   break;
							   
							   case 2:{
								   System.out.println("Enter new Instagram password");
								   String instapassword=scanner.next();
								   user.setInstagrampwd(instapassword);
								   crud.updateInstagramPwd(user);
							   }
							   break;
							   
							   case 3: {
								   System.out.println("Enter new Snapchat password");
								   String snappassword=scanner.next();
								   user.setSnapchatpwd(snappassword);
								   crud.updateSnapchatpwd(user);
							   }
							   break;
							   
							   case 4:{
								   System.out.println("Enter new Whatsapp password");
								   String whatsapppassword=scanner.next();
								   user.setSnapchatpwd(whatsapppassword);
								   crud.updateWhatsappPwd(user);
							   }
							   break;
							   
							   case 5:{
								   System.out.println("Enter new Twitter password");
								   String twitterpassword=scanner.next();
								   user.setSnapchatpwd(twitterpassword);
								   crud.updateTwitterPwd(user);
							   }
							   break;
							   
							   case 6:{
								   System.out.println("Thank you for updating");
							   }
							   break;
					
							   }
						   }
						   break;
						   
				// DELETE THE ACCOUNT	   
						   case 2:{
							   System.out.println("Are you sure to delete this account");
							   System.out.println("1: Yes");
							   System.out.println("2: No");
							   
							   switch (scanner.nextInt()) {
							   case 1:{
								   System.out.println("Enter your ID: ");
								   crud.deleteUser(scanner.nextInt());
								   
							   }
							   break;
							   
							   case 2:{
								   System.out.println("Thank you!!!");
								   flag=false;
							   }
							   break;
							
							   default:{
								   System.out.println("Enter valid option");
							   }
								break;
							}
						   }
						   break;
						   
						   case 3:{
							   System.out.println("Thank you!!!");
						   }
						   break;
						   
						   }
					    }
					}
				}
				
				else {
					System.out.println("Invalid password");
				}
				
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		  }
		  break;
		  
// EXIT
		  case 3:{
			  System.out.println("Thank you!!!");
			  flag=false;
		  }
			
		}//end of switch
		  
	}//end of do
	
	while(flag);
	scanner.close();
	}	
}
