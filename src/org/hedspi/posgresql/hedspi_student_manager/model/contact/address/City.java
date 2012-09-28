package org.hedspi.posgresql.hedspi_student_manager.model.contact.address;

import org.hedspi.posgresql.hedspi_student_manager.model.hedspi.HedspiObject;
import org.hedspi.posgresql.hedspi_student_manager.model.hedspi.HedspiObjects;

public class City extends HedspiObject {
	
	public static final String ID_CODE = "CY#";
	public static final String NAME_CODE = "Name";
	
	private String Name;

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
