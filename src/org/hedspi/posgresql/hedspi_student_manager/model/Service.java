package org.hedspi.posgresql.hedspi_student_manager.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
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
	
	public boolean isGoodLogin(Properties loginInfo){
			String url = getUrl(loginInfo);
			try {
				Connection con = DriverManager.getConnection(url);
				con.close();
			} catch (SQLException e) {
				Control.getInstance().getLogger().log(Level.WARNING, "Login failed: {0}", e.getMessage());
				return false;
			}
			return true;
	}

	private String getUrl(Properties loginInfo) {
		String url = "jdbc:postgresql://"+ loginInfo.getProperty("host", "localhost") +
				":" + loginInfo.getProperty("port", "5432") +
				"/" + loginInfo.getProperty("dbname", "hedspi") +
				"?user="+ loginInfo.getProperty("username", "Admin") +
				"&password="+loginInfo.getProperty("password", "hedspi");
//				+ "&ssl=" + loginInfo.getProperty("ssl", "false");
//		Control.getInstance().getLogger().log(Level.INFO, url);
		return url;
	}

}
