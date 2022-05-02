package BookStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;

public class BookMain {
     //insert
	//upd
	//disp
	//dlt
	static Connection conn=null;
	static Statement st=null;
	
	public static void insert() {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		conn=DataBaseConnection.getConnection();

		try {
			System.out.println("Enter SNo: ");
			int SNo=Integer.parseInt(br.readLine());
			System.out.println("Enter BookId: ");
			int BookId=Integer.parseInt(br.readLine());
			System.out.println("Enter BookName: ");
			String BookName=br.readLine();
			System.out.println("Enter BookPrice: ");
			float BookPrice=Float.parseFloat(br.readLine());
			System.out.println("Remarks: ");
			String Remarks=br.readLine();
			System.out.println("Inserting Data");
			String Query1="Insert into BookStore values('"+SNo+"','"+BookId+"','"+BookName+"','"+BookPrice+"','"+Remarks+"')";
			st=conn.createStatement();
			int S=st.executeUpdate(Query1);
			if(S>0)
			{
				System.out.println(S+"Record Inserted");
			}else {
				System.out.println("Failed to Insert");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
		System.out.println("Enter your option");
		
		int ch=Integer.parseInt(sc.readLine());
		switch(ch) {
		case 1: BookMain.insert();
		break;
//		case 2: BookMain.deleteRecord();
//		break;
//		case 3:BookMain.updateRecord();
//		break;
		}
		System.out.println("Records");
		System.out.println("Do you want to continue Y/N");
		char choice=(char)sc.read();
		if(choice=='N' || choice=='n') {
			break;
		}
		}
	}
}