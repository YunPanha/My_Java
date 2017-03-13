package ClassSource;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class MySqlConnection {

	public static Connection ConnectDB(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrdatabase?verifyServerCertificate=false&useSSL=true","root","");
		    JOptionPane.showMessageDialog(null,"Database Connection is Successful.");
		    return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}	
}
