package mainPkg;

import java.sql.*;
import java.util.ArrayList;

public class DataBase {
	
	public static String Pass;
	
	public static String getPswrd(String mail) {
		String sql = "SELECT * FROM `ADMIN` WHERE `Email` = '"+ mail +"' OR `Phone Number` = '"+ mail +"'";
		try {
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Pass = rs.getString("Password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Pass;
	}
	
	public static String getPswrd() {
		return Pass;
	}
	
	public static Statement st = MakeStatement();
	
	private static Connection MakeConnection() {
		try {
			String url = "jdbc:ucanaccess://Gardener.accdb";
			Connection con = DriverManager.getConnection(url);
			return con;			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Statement MakeStatement() {
		try {
			return MakeConnection().createStatement();			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
