package org.hedspi.posgresql.hedspi_student_manager.model.contact;

import java.util.ArrayList;
import java.util.Date;

import org.hedspi.posgresql.hedspi_student_manager.model.contact.address.District;
import org.hedspi.posgresql.hedspi_student_manager.model.hedspi.HedspiObject;
import org.hedspi.posgresql.hedspi_student_manager.model.hedspi.HedspiObjects;

public class Contact extends HedspiObject {
	
	public static final String ID_CODE = "CT#"; 
	public static final String NAME_CODE = "Name";
	public static final String FIRSTNAME_CODE = "FirstName";
	public static final String LASTNAME_CODE = "LastName";
	public static final String SEX_CODE = "Sex";
	public static final String DOB_CODE = "DOB";
	public static final String EMAIL_CODE = "Email";
	public static final String PHONE_CODE = "Phone";
	public static final String IMAGE_CODE = "ImageUrl";
	public static final String NOTE_CODE = "Notes";
	public static final String HOME_CODE = "Home";
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ArrayList<String> getEmail() {
		return email;
	}

	public void setEmail(ArrayList<String> email) {
		this.email = email;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public ArrayList<String> getImage() {
		return image;
	}

	public void setImage(ArrayList<String> image) {
		this.image = image;
	}

	public ArrayList<String> getPhone() {
		return phone;
	}

	public void setPhone(ArrayList<String> phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getName(){
		return getFirstName() + " " + getLastName();
	}
	
	public Contact(String id, String note, ArrayList<String> image,
			ArrayList<String> phone, Date dob, boolean isMan,
			String firstName, String lastName, ArrayList<String> email,
			String home, District district) {
		super(id);
		this.note = note;
		this.image = image;
		this.phone = phone;
		this.dob = dob;
		this.isMan = isMan;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.home = home;
		this.district = district;
	}

	private String note;
	private ArrayList<String> image;
	private ArrayList<String> phone;
	private Date dob;
	private boolean isMan;//true if is man
	private String firstName; 
	private String lastName;
	private ArrayList<String> email;
	private String home;
	private District district;

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}
	
	private static HedspiObjects<Contact> contacts;

	public static void setContacts(HedspiObjects<Contact> contacts) {
		Contact.contacts = contacts;
	}

	public boolean isMan() {
		return isMan;
	}

	public void setMan(boolean isMan) {
		this.isMan = isMan;
	}

	public static HedspiObjects<Contact> getContacts() {
		return contacts;
	}

	public Contact(String id) {
		super(id);
	}

}
