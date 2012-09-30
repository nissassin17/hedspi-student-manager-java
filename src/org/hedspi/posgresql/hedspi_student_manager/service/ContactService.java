package org.hedspi.posgresql.hedspi_student_manager.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;

import org.hedspi.posgresql.hedspi_student_manager.control.Control;
import org.hedspi.posgresql.hedspi_student_manager.model.contact.Contact;
import org.hedspi.posgresql.hedspi_student_manager.model.contact.address.Address;
import org.hedspi.posgresql.hedspi_student_manager.model.contact.address.City;
import org.hedspi.posgresql.hedspi_student_manager.model.contact.address.District;
import org.hedspi.posgresql.hedspi_student_manager.model.hedspi.HedspiObjects;
import org.hedspi.posgresql.hedspi_student_manager.model.hedspi.NewLineListManipulator;

public class ContactService {

	public static HedspiObjects<Contact> getContacts() {
		HedspiObjects<Contact> contacts = new HedspiObjects<>();
		//get raw contact
		Control.getInstance().getLogger().log(Level.INFO, "Fetch raw data of contacts");
		String query = "select \"FirstName\", \"LastName\", \"Sex\", \"DOB\", \"Email\", \"Phone\", \"ImageUrl\", \"Notes\", \"Home\", \"CT#\"\n" + 
				"from \"Contact\"";
		ArrayList<HashMap<String, Object>> rs = CoreService.getInstance().query(query);
		for(HashMap<String, Object> it : rs){
			String id = String.valueOf((int)it.get("CT#"));
			Contact ct = new Contact(id);
			ct.setNote((String)it.get("Notes"));
			ct.setImage(new NewLineListManipulator((String)it.get("ImageUrl")));
			ct.setPhone(new NewLineListManipulator((String)it.get("Phone")));
			ct.setFirstName((String)it.get("FirstName"));
			ct.setLastName((String)it.get("LastName"));
			ct.setEmail(new NewLineListManipulator((String)it.get("Email")));
			ct.setDob((Date)it.get("DOB"));
			ct.setAddress(new Address((String)it.get("Home"), null, null));
			ct.setMan((boolean)it.get("Sex"));

			contacts.put(ct);
		}
		
		//get address
		//get city
		Control.getInstance().getLogger().log(Level.INFO, "Fetch address (city and district) of contact");
		Control.getInstance().getLogger().log(Level.INFO, "Fetch get city of contact");
		HedspiObjects<City> cities = City.getCities();
		query = "select \"CT#\", \"CY#\" from \"AtCity\"";
		rs = CoreService.getInstance().query(query);
		for(HashMap<String, Object> it : rs){
			String cont = String.valueOf((int)it.get("CT#"));
			String cit = String.valueOf((int)it.get("CY#"));
			contacts.get(cont).getAddress().setCity(cities.get(cit));
		}
		
		//get district
		Control.getInstance().getLogger().log(Level.INFO, "Fetch district of contact");
		HedspiObjects<District> districts = District.getDistricts();
		query = "select \"DT#\", \"CT#\" from \"AtDistrict\"";
		rs = CoreService.getInstance().query(query);
		for(HashMap<String, Object> it : rs){
			String dist = String.valueOf((int)it.get("DT#"));
			String cont = String.valueOf((int)it.get("CT#"));
			contacts.get(cont).getAddress().setDistrict(districts.get(dist));
		}
		
		return contacts;
	}

}
