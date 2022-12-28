//import all classes from sql package
import java.sql.*;
import java.io.*;

class UpdateJdbcApp{
	public static void main(String args[]){
		try{ //checked exception
			
			/* 1. load the driver*/
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			/* 2. create connection */
			String url = "jdbc:mysql://localhost:3306/youtube";
			String username = "root";
			String password = "";
			Connection con = DriverManager.getConnection(url,username,password);
			
			if(con.isClosed()){
				System.out.println("COnnection is Closed");
			}
			else{
				System.out.println("Connection Created...");
			}
			
			/* 3. Create Query */
			String q = "update table1 set tName=?, tCity=? where tId=?";
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter new name: ");
			String name = br.readLine();
			
			System.out.println("Enter new city name:");
			String city = br.readLine();
			
			System.out.println("Enter the student id:");
			int id = Integer.parseInt(br.readLine());
			
			
			/* 4. Create a statement*/
			PreparedStatement stmt = con.prepareStatement(q);
			
			stmt.setString(1,name);
			stmt.setString(2,city);
			stmt.setInt(3,id);
			
			stmt.executeUpdate();
			System.out.println("Updated the table in Database..");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}


