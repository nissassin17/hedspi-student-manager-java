package org.hedspi.posgresql.hedspi_student_manager.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;

import org.hedspi.posgresql.hedspi_student_manager.control.Control;
import org.hedspi.posgresql.hedspi_student_manager.model.contact.address.City;
import org.hedspi.posgresql.hedspi_student_manager.model.contact.address.District;
import org.hedspi.posgresql.hedspi_student_manager.model.hedspi.HedspiObjects;
import org.javatuples.Pair;

public class AddressService {
	public static Pair<HedspiObjects<City>, HedspiObjects<District>> getAddresses() {
		Control.getInstance().getLogger().log(Level.INFO, "Fetch list of cities from database");

		//list of cities
		HedspiObjects<City> cities = new HedspiObjects<>();
		String query = "SELECT \"CY#\", \"Name\" FROM \"City\"";
		ArrayList<HashMap<String, Object>> rs = CoreService.getInstance().query(query);
		for(HashMap<String, Object> it : rs){
			City city = new City((String)it.get("CY#"), (String)it.get("Name"));
			cities.put(city);
		}
		
		//list of district
		HedspiObjects<District> districts = new HedspiObjects<>();
		query = "SELECT \"DT#\", \"Name\" FROM \"District\"";
		rs = CoreService.getInstance().query(query);
		for(HashMap<String, Object> it : rs){
			District district = new District((String)it.get("DT#"), (String)it.get("Name"));
			districts.put(district);
		}
		
		//connect
		query = "select \"HasDistrict\".\"DT#\", \"HasDistrict\".\"CY#\" \n" + 
				"from \"City\", \"District\", \"HasDistrict\" \n" +
				"where \n" +
				"\"City\".\"CY#\" = \"HasDistrict\".\"CY#\" AND \n" +
				"\"District\".\"DT#\" = \"HasDistrict\".\"DT#\"";
		rs = CoreService.getInstance().query(query);
		for(HashMap<String, Object> it : rs){
			String ct = (String)it.get("CY#");
			String dt = (String)it.get("DT#");
			City city = cities.get(ct);
			District district = districts.get(dt);
			if (city != null && district != null){
				city.addDistrict(district);
				district.setMyCity(city);
			}
		}
		
		return new Pair<HedspiObjects<City>, HedspiObjects<District>>(cities, districts);
	}

}
