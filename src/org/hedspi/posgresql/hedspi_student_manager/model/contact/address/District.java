package org.hedspi.posgresql.hedspi_student_manager.model.contact.address;

import org.hedspi.posgresql.hedspi_student_manager.model.hedspi.HedspiObject;

public class District extends HedspiObject {
	
	public static final String ID_CODE = "DT#";
	public static final String NAME_CODE = "Name";
	
	public District(String id, City myCity, String name) {
		super(id);
		this.myCity = myCity;
		this.name = name;
	}

	private String name;
	private City myCity;
	
	public District(String id) {
		super(id);
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
	
	public String toString(){
		return getName();
	}

}
