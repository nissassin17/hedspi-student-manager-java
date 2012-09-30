package org.hedspi.posgresql.hedspi_student_manager.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;

import org.hedspi.posgresql.hedspi_student_manager.control.Control;
import org.hedspi.posgresql.hedspi_student_manager.model.academic.HedspiClass;
import org.hedspi.posgresql.hedspi_student_manager.model.contact.Contact;
import org.hedspi.posgresql.hedspi_student_manager.model.contact.Student;
import org.hedspi.posgresql.hedspi_student_manager.model.hedspi.HedspiObjects;

public class StudentService {

	public static HedspiObjects<Student> getStudentList() {
		HedspiObjects<Student> students = new HedspiObjects<>();
		
		//raw student
		Control.getInstance().getLogger().log(Level.INFO, "Fetch raw data of students' list");
		String query = "select \"ST#\", \"EnrollPoint\", \"EnrollYear\" from \"Student\"";
		ArrayList<HashMap<String, Object>> rs = CoreService.getInstance().query(query);
		for(HashMap<String, Object> it : rs){
			Student st = new Student((String)it.get("ST#"));
			st.setEnrollPoint((double)it.get("EnrollPoint"));
			st.setEnrollYear((int)it.get("EnrollYear"));
			students.put(st);
		}
		
		//add contact detali
		Control.getInstance().getLogger().log(Level.INFO, "Fetch students' contact detail");
		HedspiObjects<Contact> contacts = Contact.getContacts();
		query = "select \"CT#\", \"ST#\" from \"InfoOfStudent\"";
		rs = CoreService.getInstance().query(query);
		for(HashMap<String, Object> it : rs){
			String cont = String.valueOf((int)it.get("CT#"));
			String stu = (String)it.get("ST#");
			students.get(stu).setContact(contacts.get(cont));
		}

		//get class
		Control.getInstance().getLogger().log(Level.INFO, "Fetch classes of students");
		HedspiObjects<HedspiClass> hedspiClasses = HedspiClass.getClasses();
		query = "select \"ST#\", \"CL#\" from \"IsStudentOf\"";
		rs = CoreService.getInstance().query(query);
		for(HashMap<String, Object> it : rs){
			String st = (String)it.get("ST#");
			String cl = (String)it.get("CL#");
			HedspiClass hcl = hedspiClasses.get(cl);
			Student std = students.get(st);
			std.setMyClass(hcl);
			hcl.getStudents().put(std);
		}

		return students;
	}

}
