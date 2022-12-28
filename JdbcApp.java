//import all classes from sql package
import java.sql.*;

class JdbcApp{
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
			String q = "create table table1(tId int(20) primary key auto_increment, tName varchar(200) not null, tCity varchar(400))";
			
			/* 4. Create a statement*/
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate(q);
			System.out.println("Table created in Database..");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}


