//import all classes from sql package
import java.sql.*;
import java.io.*;

class DynamicSatement{
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
			String q = "insert into table1(tName,tCity) values (?,?)";
			
			/* 4. Get PreparedStatement object */
			PreparedStatement pstmt = con.prepareStatement(q);
			
			/* 5. Set values to Query */
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Name: ");
			String name  = br.readLine();
			
			System.out.println("Enter city: ");
			String city = br.readLine();
			
			pstmt.setString(1, name); //setting 1st column in table
			pstmt.setString(2, city); //setting 2nd column in table
			
			pstmt.executeUpdate();
	
			System.out.println("Values inserted into the table..");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}




