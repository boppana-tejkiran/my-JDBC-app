//import all classes from sql package
import java.sql.*;
import java.io.*;

class SelectJdbcApp{
	public static void main(String args[]){
		try{ //checked exception
			
			/* 1. load the driver*/
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			/* 2. create connection */
			String url = "jdbc:mysql://localhost:3306/youtube";
			String username = "root";
			String password = "abccbaabc1";
			Connection con = DriverManager.getConnection(url,username,password);
			
			if(con.isClosed()){
				System.out.println("COnnection is Closed");
			}
			else{
				System.out.println("Connection Created...");
			}
			
			/* 3. Create Query */
			String q = "select * from table1";
			
			/* 4. Create a statement*/
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next())
			{
				int id = set.getInt(1);
				String name = set.getString(2);
				String city = set.getString(3);
				System.out.println("Name:"+ name + " City: "+ city);
			}
			
			System.out.println("Fetched the table from Database..");
			con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}


