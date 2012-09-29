package org.hedspi.posgresql.hedspi_student_manager.model;

import java.util.Properties;
import java.util.logging.Level;

import org.hedspi.posgresql.hedspi_student_manager.control.Control;
import org.hedspi.posgresql.hedspi_student_manager.model.contact.address.City;
import org.hedspi.posgresql.hedspi_student_manager.service.CoreService;

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
			Properties loginInfo = (Properties) data[0];
			return CoreService.isGoodLogin(loginInfo);
		
		case "fetchCitiesList":
			return City.getCities();
			
		default:
			Control.getInstance().getLogger().log(Level.WARNING, "Unsupported getData operation  - " + command + ". Return null");
			return null;
		}
	}

	public static Model getInstance() {
		if (instance == null)
			instance = new Model();
		return instance;
	}

}
