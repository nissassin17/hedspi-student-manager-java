package org.hedspi.posgresql.hedspi_student_manager.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

import org.hedspi.posgresql.hedspi_student_manager.control.Control;

public class Model implements IModel{
	
	private static Model instance;
	private Model(){}

	@Override
	public void setData(String command, Object... data) {
		switch (command){
		default:
			Control.getInstance().getLogger().log(Level.WARNING, "Unsupported setData operation  - " + command);
		}
	}

	@Override
	public Object getData(String command, Object... data) {
		switch(command){
		case "check-login":
			LoginInfo loginInfo = (LoginInfo) data[0];
			return Service.getInstance().isGoodLogin(loginInfo);
		case "init-database":
			/**
			 * @return "" if only if success
			 */
			return initDatabase((LoginInfo)data[0]);
			
		default:
			Control.getInstance().getLogger().log(Level.WARNING, "Unsupported getData operation  - " + command + ". Return null");
			return null;
		}
	}

	private String initDatabase(LoginInfo loginInfo) {
		String url = loginInfo.getUrl(Service.DATABASE);
		Connection con = null;
		try {
			con = DriverManager.getConnection(url);
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (Throwable e){}
		}

		return "";
	}

	public static Model getInstance() {
		if (instance == null)
			instance = new Model();
		return instance;
	}

}
