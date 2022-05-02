package BookStore;

import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookStore {

	static Connection conn=null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;
	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
		try {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("*********MENU***********");
			System.out.println("WELCOME TO ONLINE BOOK STORE");
			System.out.println("SELECT THE OPTION......");
			System.out.println("1.SELL A BOOK(S)");
			System.out.println("2.BUY A BOOK(B)");
			char ch=br.readLine().toUpperCase().charAt(0);
			if(ch=='S') {
				System.out.println("***WELCOME TO SELLING POINT***");
				System.out.println("Books Already IN Stock");
				BookSeller.Seller(conn,pst,rs);
				System.out.println("Enter Your Name");
				String sellername=br.readLine().trim();
				System.out.println("Enter Your Phone NO");
				long sellerPhoneNo=Long.parseLong(br.readLine());
				System.out.println("Enter Your Email Address");
				String sellerEmail = br.readLine().trim();
				if(!sellerEmail.Bookseller(conn,pst,rs,sellerEmail)) {
			    seller.assseller(conn,pst,rs,sellername,sellerPhoneNo,sellerEmail);
				int sid = sellerEmail.getId(conn,pst,rs, sellerEmail);
				System.out.println("Enter Your Book Name");
				String BookName=br.readLine().trim();
				System.out.println("Author Name");
				String AuthName=br.readLine();
				System.out.println("Book(s) Actual Price (in MRP");
				float BookPrice=Float.parseFloat(br.readLine());
				System.out.println("Book Stocks");
				int BookStocks=Integer.parseInt(br.readLine());
				Book.addBook(conn,pst,rs,BookName,AuthName,BookPrice,BookStock,sid);
			}
			else if(ch=='B') {
				System.out.println("*****WELCOME TO OUR BOOK STORE*****");
				System.out.println("YOU CAN BUY YOUR BOOK AT AFFORDABLE COST HERE");
				System.out.println("Kindly be Patient Your Books are Loading........");
				Book.display(conn,pst,rs);
				System.out.println("Please Enter How Many Copie(s) You Want");
				int Copies = Integer.parseInt(br.readLine());
				int id = Book.checkAvailability(conn,pst,rs,Book,Copies);
				if(id==0)
				System.out.println("Book Stock is Low or Unavailable");
				else {
					System.out.println("Please Enter Your Name");
					String buyerName = br.readLine().trim();
				} 
			}
		}
			System.out.println("Do you want to continue Y/N");
			char choice=br.readLine().charAt(0);
			if(choice=='N' || choice=='n') {
				System.out.println("Thanks For Shopping");
				System.out.println("Welcome Again");
			}
		}
	}
}
		
