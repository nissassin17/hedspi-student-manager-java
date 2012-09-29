package org.hedspi.posgresql.hedspi_student_manager.model.hedspi;

import java.util.HashMap;

import org.hedspi.posgresql.hedspi_student_manager.model.contact.address.City;

public class HedspiObjects<T extends HedspiObject> extends HashMap<String, T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ID_CODE = "DT#";
	public static final String NAME_CODE = "Name";
	
	private String name;
	private City myCity;

	public void put(T value){
		super.put(value.getId(), value);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getMyCity() {
		return myCity;
	}

	public void setMyCity(City myCity) {
		this.myCity = myCity;
	}
	
}
