//import all classes from sql package
import java.sql.*;

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
			pstmt.setString(1, "Bike"); //setting 1st column in table
			pstmt.setString(2, "Honda"); //setting 2nd column in table
			
			pstmt.executeUpdate();
	
			System.out.println("Values inserted into the table..");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}




