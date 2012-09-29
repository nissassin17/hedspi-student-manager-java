package org.hedspi.posgresql.hedspi_student_manager.view.student;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import org.hedspi.posgresql.hedspi_student_manager.view.student.add.AddStudentPane;

public class StudentPanel extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public StudentPanel() {
		
		JScrollPane scrollPane = new JScrollPane();
		addTab("Add", null, scrollPane, null);
		
		AddStudentPane addStudentPane = new AddStudentPane();
		addStudentPane.setAutoscrolls(false);
		addStudentPane.setAlignmentY(0.0f);
		addStudentPane.setAlignmentX(0.0f);
		scrollPane.setViewportView(addStudentPane);

	}

}
