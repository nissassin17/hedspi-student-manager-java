package org.hedspi.posgresql.hedspi_student_manager.model.contact;

import org.hedspi.posgresql.hedspi_student_manager.model.academic.HedspiClass;
import org.hedspi.posgresql.hedspi_student_manager.model.hedspi.HedspiObject;

public class Student extends HedspiObject {
	
	public static final String ID_CODE = "ST#";
	public static final String ENROLL_POINT_CODE = "EnrollPoint";
	public static final String ENROLL_YEAR_CODE = "EnrollYear";
	
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public double getEnrollPoint() {
		return enrollPoint;
	}

	public void setEnrollPoint(double enrollPoint) {
		this.enrollPoint = enrollPoint;
	}

	public int getEnrollYear() {
		return enrollYear;
	}

	public void setEnrollYear(int enrollYear) {
		this.enrollYear = enrollYear;
	}

	public HedspiClass getMyClass() {
		return myClass;
	}

	public void setMyClass(HedspiClass myClass) {
		this.myClass = myClass;
	}

	public Student(String id, Contact contact, double enrollPoint,
			int enrollYear, HedspiClass myClass) {
		super(id);
		this.contact = contact;
		this.enrollPoint = enrollPoint;
		this.enrollYear = enrollYear;
		this.myClass = myClass;
	}

	private Contact contact;
	private double enrollPoint;
	private int enrollYear;
	private HedspiClass myClass;

	public Student(String id) {
		super(id);
	}
	
	public String getName(){
		return getContact().getName();
	}

	@Override
	public String toString() {
		return getName();
	}

}
