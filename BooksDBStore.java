package onlineBookStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BooksDBStore {
	
	static Connection connect=null;
	static Statement stmt = null;
	
	public static void InsertRecord() throws SQLException{
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		
		try {
			connect= SqlConnectionDB.getConnection();
			System.out.println("Insert the record");
			System.out.println("Enter the Book id");
			String bookid = br.readLine();
			System.out.println("Enter the Book Name");
			String bookname = br.readLine();
			System.out.println("Enter the Book Price");
			int bookprice = Integer.parseInt(br.readLine());
			String qry = "insert into onlinebooksshop values('"+bookid+"','"+bookname+"',"+bookprice+")";
			stmt = connect.createStatement();
			//ResultSet rs = stmt.executeQuery(qry);
			//if(rs.next()) {
			//	System.out.println(qry);
				int count = stmt.executeUpdate(qry);
				if(count>0) {
					System.out.println(count+ " rows inserted");
				}
				else {
					System.out.println("records not inserted");
				}
			
			
		}
		catch(Exception exp) {
			exp.printStackTrace();
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
			stmt = connect.createStatement();
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
	
	public static void UpdateRecord(){
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		try {
			connect = SqlConnectionDB.getConnection();
			System.out.println("Update Records by adding the fields or row..!");
			System.out.println("Enter the Book id");
			String bookid = br.readLine();
			System.out.println("Choose fields bookname or bookprice");
			System.out.println("enter the choice number: ");
			int choice = Integer.parseInt(br.readLine());
			if(choice == 1) {
				System.out.println("Update the bookName: ");
				String bookname = br.readLine();
				String qry2 = "update onlinebooksshop set Bookname = '"+bookname
						+"'where bookid ='"+bookid+"'";
				stmt = connect.createStatement();
				int updatebookname = stmt.executeUpdate(qry2);
				if(updatebookname>0) {
					System.out.println(updatebookname+ " book name has updated");
				}
			}
			else if(choice==2) {
				System.out.println("Update the bookprice: ");
				int bookprice = Integer.parseInt(br.readLine());
				String qry3 = "update onlinebooksshop set Bookname ='"+bookprice
						+"'where bookid = '"+bookid+"'";
				stmt = connect.createStatement();
				int updateprice = stmt.executeUpdate(qry3);
				if(updateprice>0) {
					System.out.println(updateprice+ " book price has updated");
				}
				
			}
			else {
				System.out.println("no records are updated..!!");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void DeleteRecord() {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		try {
			connect=SqlConnectionDB.getConnection();
			System.out.println("Deleting the record");
			System.out.println("enter the BOOK ID:");
			String bookid = br.readLine();
			String delqry = "delete from onlinebooksshop where bookid='"+bookid+"'";
			stmt= connect.createStatement();
			int delrow = stmt.executeUpdate(delqry);
			if(delrow>0) {
				System.out.println(delrow+" record/s is deleted");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("wlcm to online book store");
			System.out.println("1. Insert record");
			System.out.println("2. Fetch Record");
			System.out.println("3. Update Record");
			System.out.println("4. Delete Record");
			System.out.println("Enter your choice");
			int ch = Integer.parseInt(br1.readLine());
			switch(ch) {
			case 1:BooksDBStore.InsertRecord();
			break;
			case 2:BooksDBStore.FetchRecord();
			break;
			case 3:BooksDBStore.UpdateRecord();
			break;
			case 4: BooksDBStore.DeleteRecord();
			break;
			}
		}
	}

}
