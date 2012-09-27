package org.hedspi.posgresql.hedspi_student_manager.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

import org.hedspi.posgresql.hedspi_student_manager.control.Control;

public class Service {
	private static Service instance;
	public static Service getInstance(){
		if (instance == null){
			instance = new Service();
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				Control.getInstance().getLogger().log(Level.SEVERE, "Init postgresql driver failed.\nMessage: " + e.getMessage());
				return null;
			}
		}
		return instance;
	}
	public static final String DATABASE = "testdb";
	
	public boolean isGoodLogin(LoginInfo loginInfo){
			String url = loginInfo.getUrl(DATABASE);
			try {
				Connection con = DriverManager.getConnection(url);
				con.close();
			} catch (SQLException e) {
				return false;
			}
			return true;
	}

}
