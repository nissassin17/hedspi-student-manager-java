package org.hedspi.posgresql.hedspi_student_manager.view.student.add;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class StudentOtherInfoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		
		textField_2 = new JTextField();
		add(textField_2, "4, 2, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblClass = DefaultComponentFactory.getInstance().createLabel("Class*");
		lblClass.setDisplayedMnemonic('c');
		add(lblClass, "2, 4, right, default");
		
		JComboBox comboBox = new JComboBox();
		add(comboBox, "4, 4, fill, default");
		
		JLabel lblEntrollPoint = DefaultComponentFactory.getInstance().createLabel("Entroll point*");
		add(lblEntrollPoint, "2, 6, right, default");
		
		textField = new JTextField();
		add(textField, "4, 6, fill, default");
		textField.setColumns(10);
		
		JLabel lblEntrollYear = DefaultComponentFactory.getInstance().createLabel("Entroll year*");
		add(lblEntrollYear, "2, 8, right, default");
		
		textField_1 = new JTextField();
		add(textField_1, "4, 8, fill, default");
		textField_1.setColumns(10);

	}

}
