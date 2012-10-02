package org.hedspi.posgresql.hedspi_student_manager.model.contact.address;

import org.hedspi.posgresql.hedspi_student_manager.model.hedspi.HedspiObject;
import org.hedspi.posgresql.hedspi_student_manager.model.hedspi.HedspiObjects;
import org.hedspi.posgresql.hedspi_student_manager.service.AddressService;
import org.javatuples.Pair;

public class District extends HedspiObject {
	
	public static final String ID_CODE = "DT#";
	public static final String NAME_CODE = "Name";
	private static HedspiObjects<District> districts;
	
	public static void setDistricts(HedspiObjects<District> districts) {
		District.districts = districts;
	}

	public static HedspiObjects<District> getDistricts() {
		if (districts == null){
			Pair<HedspiObjects<City>, HedspiObjects<District>> val = AddressService.getAddresses();
			City.setCities(val.getValue0());
			setDistricts(val.getValue1());
		}
		return districts;
	}

	public District(String id, City myCity, String name) {
		super(id);
		this.city = myCity;
		this.name = name;
	}

	public District(String id, String name, City myCity) {
		super(id);
		this.name = name;
		this.city = myCity;
	}

	private String name;
	private City city;
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

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
		return city;
	}

	public void setMyCity(City myCity) {
		this.city = myCity;
	}
	
	public String toString(){
		return getName();
	}

}
