  package library;
  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class Main {
	
	Database con=new Database();
	
	public void init() {
		System.out.println("1.Add Book");
		System.out.println("2.Display Book");
		System.out.println("3.Update Book");
		System.out.println("4.Dlete Book");

			for(int i=0;i<1000;i++) {
		Scanner sc = new Scanner(System.in);
				
		int choose = sc.nextInt();
			
			switch(choose) {
			case 1 :
				
				    add();
				 
			    	break;
			case 2 :
				
					display();
				
			     	break;
			case 3 :
				
			      update();
				
		        	break; 
			case 4 :
			    
			      delete();
		        	break;
			}

		}
	}
	
	public void add() {
	try {
		
		Scanner sc = new Scanner(System.in);
		
		 PreparedStatement ps=con.con.prepareStatement("insert into book values(?,?,?,?)");
		
	    System.out.println("enter id");
				int bookid=sc.nextInt();
		System.out.println("enter book name");
		       String name=sc.next();
		System.out.println("enter author name");
		       String AuthorName=sc.next();
		System.out.println("enter book price");
	         	int bookprice=sc.nextInt();

		ps.setInt(1, bookid);
		ps.setString(2,name);
		ps.setString(3,AuthorName);
		ps.setInt(4, bookprice);
		
		int i=ps.executeUpdate();
		System.out.println("added successfully");
		
		System.out.println("Enter options"+"  "+"1-add"+"  "+"2-display"+"  "+"3-update"+"  "+"4-delete");
	}catch(Exception e) {
	System.out.println(e);	
	}
	}
	
	public void display() {
	try {
		  Scanner sc = new Scanner(System.in);
	      PreparedStatement ps=con.con.prepareStatement("select*from lib.book");
	
          ResultSet rs=ps.executeQuery();
	
	while(rs.next()) {
		
	     System.out.println(rs.getInt(1)+"  "+rs.getString(2) +"  "+rs.getString(3)+"  "+rs.getInt(4));	
	  
	}
	}catch(Exception e) {
		 System.out.println(e);
	}
	   System.out.println("Enter options"+"  "+"1-add"+"  "+"2-display"+"  "+"3-update"+"  "+"4-delete");
	}
	
	
	public void update() {
		
	try {	
		Scanner sc = new Scanner(System.in);
		
	
		PreparedStatement ps=con.con.prepareStatement("update book set bookname=?"+",authorName=?,bookPrice=? where id=?");  
		
		System.out.println("Enter id");
		ps.setInt(4, sc.nextInt());
		
		System.out.println("book name");
		ps.setString(1,sc.next());  
		
		System.out.println("author name");
		ps.setString(2, sc.next());
		
		System.out.println("price");
		ps.setInt(3,sc.nextInt());
		  
		 ps.executeUpdate();   
		  
		
		System.out.println(" records updated");
		System.out.println("Enter options"+"  "+"1-add"+"  "+"2-display"+"  "+"3-update"+"  "+"4-delete");
	}catch(Exception e) {
		System.out.println(e);
	}
	}
public void delete()  {
	try {	
		Scanner sc = new Scanner(System.in);
	
		PreparedStatement ps=con.con.prepareStatement("delete from book where id=?");  
		
		System.out.println("enter book id");
		ps.setInt(1,sc.nextInt());  
		  
		ps.executeUpdate();  
		System.out.println(" records deleted"); 
		System.out.println("Enter options"+"  "+"1-add"+"  "+"2-display"+"  "+"3-update"+"  "+"4-delete");
	}catch(Exception e) {
		System.out.println(e);
	}	
	}
	
   public static void main(String[] args) {

	    Main col  = new Main();
		col.init();
	}
}
