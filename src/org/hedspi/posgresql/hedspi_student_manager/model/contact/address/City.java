package org.hedspi.posgresql.hedspi_student_manager.model.contact.address;

import java.util.ArrayList;

import org.hedspi.posgresql.hedspi_student_manager.model.hedspi.HedspiObject;

public class City extends HedspiObject {
	
	public static final String ID_CODE = "CY#";
	public static final String NAME_CODE = "Name";
	
	private String Name;
	private ArrayList<District> districts;

	public ArrayList<District> getDistricts() {
		return districts;
	}

	public void setDistricts(ArrayList<District> districts) {
		this.districts = districts;
	}

	public City(String id) {
		super(id);
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String toString(){
		return getName();
	}
	
}
