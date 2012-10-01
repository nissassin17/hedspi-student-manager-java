package org.hedspi.posgresql.hedspi_student_manager.view.student;

import java.util.ArrayList;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.toedter.calendar.JYearChooser;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.hedspi.posgresql.hedspi_student_manager.model.Model;
import org.hedspi.posgresql.hedspi_student_manager.model.academic.HedspiClass;
import org.hedspi.posgresql.hedspi_student_manager.model.contact.Student;
import org.hedspi.posgresql.hedspi_student_manager.model.hedspi.HedspiObjects;

import javax.swing.JSpinner;

public class StudentOtherInfoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldEnrollPoint;
	private JTextField textFieldID;
	private JYearChooser spinnerEnrollYear;
	private JComboBox<HedspiClass> comboBoxClass;
	private DefaultComboBoxModel<HedspiClass> classModel;

	/**
	 * Create the panel.
	 */
	public StudentOtherInfoPanel() {
		setBorder(new TitledBorder(null, "Student other information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(9dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblStudentIdentity = DefaultComponentFactory.getInstance().createLabel("ID (8 chars)*");
		lblStudentIdentity.setDisplayedMnemonic('i');
		add(lblStudentIdentity, "2, 2, right, default");
		
		textFieldID = new JTextField();
		add(textFieldID, "4, 2, fill, default");
		textFieldID.setColumns(10);
		
		JLabel lblClass = DefaultComponentFactory.getInstance().createLabel("Class*");
		lblClass.setDisplayedMnemonic('c');
		add(lblClass, "2, 4, right, default");
		
		classModel = new DefaultComboBoxModel<HedspiClass>();
		comboBoxClass = new JComboBox<>(classModel);
		setClasses(((HedspiObjects<HedspiClass>)Model.getInstance().getData("getClassList")).getSortedListIgnoreCase());
		add(comboBoxClass, "4, 4, fill, default");
		
		JLabel lblEntrollPoint = DefaultComponentFactory.getInstance().createLabel("Entroll point*");
		add(lblEntrollPoint, "2, 6, right, default");
		
		textFieldEnrollPoint = new JTextField();
		add(textFieldEnrollPoint, "4, 6, fill, default");
		textFieldEnrollPoint.setColumns(10);
		
		JLabel lblEntrollYear = DefaultComponentFactory.getInstance().createLabel("Entroll year*");
		add(lblEntrollYear, "2, 8, right, default");
		
		spinnerEnrollYear = new JYearChooser();
		add(spinnerEnrollYear, "4, 8");

	}

	private void setClasses(ArrayList<HedspiClass> sortedListIgnoreCase) {
		classModel.removeAllElements();
		for(HedspiClass it : sortedListIgnoreCase)
			classModel.addElement(it);
	}

	public void setStudent(Student obj) {
		textFieldID.setText(obj.getId());
		textFieldEnrollPoint.setText(String.valueOf(obj.getEnrollPoint()));
		spinnerEnrollYear.setYear(obj.getEnrollYear());
		getComboBoxClass().setSelectedItem(obj.getMyClass());
	}

	protected JComboBox<HedspiClass> getComboBoxClass() {
		return comboBoxClass;
	}
	
	public void setClass(HedspiClass cl){
		getComboBoxClass().setSelectedItem(cl);
	}
}
