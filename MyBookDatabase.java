package onlineBookStore;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class MyBookDatabase {
	static  Connection connect = null;
	static	PreparedStatement stmt = null;

//	static	Scanner sc;
	
	public static void selectRecord() throws SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//sc = new Scanner(System.in);
		try {
			 connect = SqlConnectionDB.getConnection();
			//select				
			System.out.println("Database connected..!");
			System.out.println("please Admin Enter the book id:");
			String bookid = br.readLine();
			System.out.println("Enter Bookname:");
			String bookname = br.readLine();
			System.out.println("enter price of the book:");
			int bookPrice = Integer.parseInt(br.readLine());
//			String Pid = "select * from onlinebooksshop where bookid=?";
//			stmt = connect.prepareStatement(Pid);
//			stmt.setString(1,bookid);
//			ResultSet rs= stmt.executeUpdate(); 
			//if(!rs.next()) {
				String s="insert into onlinebooksshop(bookid,bookname,bookPrice) values (?,?,?)";
				System.out.println(s);
				stmt = connect.prepareStatement(s);
				stmt.setString(1,bookid);
				stmt.setString(2,bookname);
				stmt.setInt(3, bookPrice);
				int i=stmt.executeUpdate(); 
				if(i>0) {
					System.out.println("Record is inserted successfully");
				}
				else {
					System.out.println("Not inserted");
					System.out.println(bookid+" already exists");
				}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			connect.close();
		}
	}
	
public static void FetchRecord() {
		
		try {
			connect = SqlConnectionDB.getConnection();
			System.out.println("fetching the records in BOOK DB");
			String qry1 = "select * from onlinebooksshop";
			stmt = connect.prepareStatement(qry1);
			ResultSet rs = stmt.executeQuery(qry1);
			while(rs.next()) {
				String s1 = rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3);
				System.out.println(s1);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("welcome");
			System.out.println("1. Insert Record");
			System.out.println("2. Fetch Record");
			sc=new Scanner(System.in);
			System.out.println("Enter your option");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:MyBookDatabase.selectRecord();
			break;  
			case 2:MyBookDatabase.FetchRecord();
			break;
			
			}
			System.out.println("continue to changes Y/N");
			char choice=sc.next().charAt(0);
			if(ch=='N' || ch=='n') {
				break;
			}
			}
	}
}
