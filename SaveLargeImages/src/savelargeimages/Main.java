package savelargeimages;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {
        try{
            Connection con = ProvideConnection.getConnection();

            String q = "insert into images(pic) values(?)";

            PreparedStatement pstmt = con.prepareStatement(q);
            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);

            File file = jfc.getSelectedFile();
            FileInputStream fis = new FileInputStream(file);
            pstmt.setBinaryStream(1,fis,fis.available());
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "success!!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
