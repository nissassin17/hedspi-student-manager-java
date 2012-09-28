package org.hedspi.posgresql.hedspi_student_manager.model.contact;

import java.util.Date;

import org.hedspi.posgresql.hedspi_student_manager.model.contact.address.Address;
import org.hedspi.posgresql.hedspi_student_manager.model.hedspi.HedspiObject;
import org.hedspi.posgresql.hedspi_student_manager.model.hedspi.NewLineListManipulator;

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

	public NewLineListManipulator getEmail() {
		return email;
	}

	public void setEmail(NewLineListManipulator email) {
		this.email = email;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public NewLineListManipulator getImage() {
		return image;
	}

	public void setImage(NewLineListManipulator image) {
		this.image = image;
	}

	public NewLineListManipulator getPhone() {
		return phone;
	}

	public void setPhone(NewLineListManipulator phone) {
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
	
	private String firstName; 
	private String lastName;
	private NewLineListManipulator email;
	private Address address;
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	private String note;
	private NewLineListManipulator image;
	private NewLineListManipulator phone;
	private Date dob;

	public Contact(String id) {
		super(id);
	}

}
