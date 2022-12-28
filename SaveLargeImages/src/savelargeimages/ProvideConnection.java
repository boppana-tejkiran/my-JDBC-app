package savelargeimages;
import java.sql.*;
public class ProvideConnection {
    private static Connection con;
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        try{
            if(con==null){
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube","root","");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
