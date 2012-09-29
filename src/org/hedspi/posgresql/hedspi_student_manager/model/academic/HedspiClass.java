package org.hedspi.posgresql.hedspi_student_manager.model.academic;

import java.util.ArrayList;

import org.hedspi.posgresql.hedspi_student_manager.model.contact.Lecturer;
import org.hedspi.posgresql.hedspi_student_manager.model.contact.Student;
import org.hedspi.posgresql.hedspi_student_manager.model.hedspi.HedspiObject;

public class HedspiClass extends HedspiObject {
	
	public static final String ID_CODE = "CL#";
	public static final String NAME_CODE = "Name";
	
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public HedspiClass(String id, String name) {
		super(id);
		this.name = name;
	}

	private Lecturer lecturer;
	private ArrayList<Student> students;

	public HedspiClass(String id) {
		super(id);
	}

	@Override
	public String toString() {
		return getName();
	}
}
