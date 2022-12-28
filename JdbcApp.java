//import all classes from sql package
import java.sql.*;

class JdbcApp{
	public static void main(String args[]){
		try{ //checked exception
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create connection
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
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}


