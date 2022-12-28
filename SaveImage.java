import java.io.*;
import java.sql.*;

class SaveImage{
	public static void main(String[] args){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/youtube","root","");
			
			String q = "insert into images(pic) values(?)"; //pic is column name
			
			PreparedStatement pstmt = con.prepareStatement(q);
			
			//pstmt.setString(1,"<value>"); //this is applicable only to strings 
			FileInputStream fis = new FileInputStream("samplepic.jpeg");
			pstmt.setBinaryStream(1, fis, fis.available());
			pstmt.executeUpdate();
			
			System.out.println("Image saved to the table");
			
		}catch(Exception e){
			System.out.println("Error!!");
			e.printStackTrace();
		}
	}
}
