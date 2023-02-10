package com.labjdbc.librarymanagementsystem;

// import packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class App 
{
	
public void Add()
{
		   System.out.println("\nInsert Your Data into Table");
	   
		   try
	{
		   // Create connection with your Mysql database
		   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagement", "root", "Shivkanya$@17");
		
		   if(con.isClosed())
		{
			System.out.println("The Connection is Close");
		}
		   else
		{
			System.out.println("The Connection is Established");
		}
		
		   // Inserting data into database
		   String q ="insert into librarydata(\nbook_id,\nbook_name,\nbook_author,\nbook_edition) values(?,?,?,?)";
		  
		   // Create PrparedStatement object  
		   PreparedStatement pstmt = con.prepareCall(q);
		
		
		   // Create scanner class object
		   Scanner sc=new Scanner(System.in);

		   
		   // Taking data from the User using scanner class object
		   System.out.println("\nEnter your book_id :");
	       int Id=sc.nextInt();
	       System.out.println("\nEnter your book_name");
	       String Name = sc.next();
	       System.out.println("\nEnter your book_author");
           String Author = sc.next();
     	   System.out.println("\nEnter your book_edition");
	       String Edition = sc.next();       
		
	      
	       // Set the values in the query
		   pstmt.setInt(1,Id);
		   pstmt.setString(2,Name);
		   pstmt.setString(3,Author);
		   pstmt.setString(4,Edition);
		
		   // Executing the Query 
	       pstmt.executeUpdate();    	    
	       System.out.println("The Data is Inserted  Successfully");  
	   
	       
	       // closing the connection
           con.close();    
	       System.out.println("The Connection are Close");
 	 	
}  	
 	       catch(Exception e)
 	{
 		   System.out.println(e);	  
 	}	
}

public void Update()
{
	       System.out.println("\nUpdate your data into table");
	
	       try
	{
	  
		   // Create connection with your Mysql database
	       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagement", "root", "Shivkanya$@17");
	
	       if(con.isClosed())
	{
		   System.out.println("The Connection is Close");
	}
	       else
	{
		   System.out.println("The Connection is Established");
	}
	
	       // Update data in database
	       String q ="update librarydata set book_name = ? ,book_author = ?, book_edition = ? where book_id = ?";
	  
	      
	       // Create PrparedStatement object  
	       PreparedStatement pstmt = con.prepareCall(q);
	
	
	       // Create scanner class object
	       Scanner sc=new Scanner(System.in);

	   
	       // Taking data from the User using scanner class object
	       System.out.println("\nEnter your Change book_id :");
           int Id=sc.nextInt();
           System.out.println("\nEnter your Change book_name :");
           String Name = sc.next();
           System.out.println("\nEnter your Change book_author :");
           String Author = sc.next();
	       System.out.println("\nEnter your Change book_edition :");
           String Edition = sc.next();       
	
   
           // Set the values in the query
          
           pstmt.setInt(1,Id);
	       pstmt.setString(2,Name);
	       pstmt.setString(3,Author);
	       pstmt.setString(4,Edition);
	       
	
	       // Executing the Query 
           pstmt.executeUpdate();    	    
           System.out.println("The Data is Updated Successfully");  


           // closing the connection
           con.close();    
           System.out.println("The Connection are Close");
	
}  	
           catch(Exception e)
     {
	       System.out.println(e);	  
     }	
}
	

public void Delete()
{
	       System.out.println("\nDelete your data from table");
	
	       try
	{
		   // Create connection with your Mysql database
		   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagement", "root", "Shivkanya$@17");
		
		   if(con.isClosed())
		{
		   System.out.println("The Connection is Close");
		}
		   else
		{
		   System.out.println("The Connection is Established");
		}
		
		   // Delete data from database table
		   String q ="delete from librarydata where book_id = ?";
		 
		  
		   // Create PrparedStatement object and pass the string 
		   PreparedStatement pstmt = con.prepareCall(q);
		
		
		   // Create scanner class object
		   Scanner sc=new Scanner(System.in);

		   
		   // Taking data from the User using scanner class object
		   System.out.println("Enter your book_id you want to delete :");
	       int Id=sc.nextInt();
	       
	       
	       // Set the values in the query
		   pstmt.setInt(1,Id);
		 
		   
		   // Executing the Query 
	       pstmt.executeUpdate();    	    
	       System.out.println("\nThe Data is Deleted  Successfully");  
	   
	       
	       // closing the connection
           con.close();    
	       System.out.println("\nThe Connection are Close");
 	 	
}  	
 	       catch(Exception e)
 	   {
 		   System.out.println(e);	  
       }	
}


public void Display()
{
	       System.out.println("\nDisplay Databse");
	  
	       try
	{
		   // Create connection with your Mysql database
		   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagement", "root", "Shivkanya$@17");
		
		   if(con.isClosed())
		{
		   System.out.println("The Connection is Close");
		}
		   else
		{
		   System.out.println("The Connection is Established");
		}
	
		   
	       // Show all database
	       String q ="Select book_id,book_name,book_author,book_edition from librarydata";
           
	       // Create PrparedStatement object and pass the string 
	       PreparedStatement pstmt = con.prepareStatement(q);
	       
	       // Execute result query
	       ResultSet rset =pstmt.executeQuery();
	
	       while(rset.next())
	{
		   int id =rset.getInt(1);
		   String name =rset.getString(2);
		   String author = rset.getString(3);
		   String edition =rset.getString(4);
		  
		
		   System.out.println("\nId: "+id+" "+" \nName: "+name+" "+" \nauthor:"+author);
	}
    
           System.out.println("\nAll data display Sucessfully");
	
           // closing the connection
           con.close();   
           System.out.println("\nThe Connection are close");
}
           catch(Exception e)
     {
           System.out.println(e);
     }

}


public void Operation()
{
	       Scanner sc=new Scanner(System.in);
	       System.out.println("Enter your Choice : \n1: Add  \n2: Update  \n3: Delete  \n4: Display ");
	
	       int c = sc.nextInt();
	
	       switch(c)
    	{
	       case 1: Add();
	       break;
	
	       case 2: Update();
	       break;
	
	       case 3: Delete();
	       break;
	
	       case 4: Display();
	       break;
	
	       default : System.out.println("\nInvalid Choice");
	       break;
	   }
}
	
// Main function	
	
public static void main(String[] args) 
   
	{ 
		   App ap = new App();                                                     // Create object of class
		   ap.Operation();                                                         // Call the function or method

	}

}
