package org.hedspi.posgresql.hedspi_student_manager.view.classview;

import javax.swing.JPanel;

import org.hedspi.posgresql.hedspi_student_manager.model.academic.HedspiClass;
import org.hedspi.posgresql.hedspi_student_manager.model.contact.Student;
import org.hedspi.posgresql.hedspi_student_manager.view.util.list.IObjectViewPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

public class ClassViewPanel extends JPanel implements IObjectViewPanel<HedspiClass> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldClassName;
	private DefaultListModel<Student> modelClass;
	private JList<Student> listClass;

	/**
	 * Create the panel.
	 */
	public ClassViewPanel() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JPanel panel = new JPanel();
		add(panel, "2, 2, fill, fill");
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("71px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("86px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),}));
		
		JLabel lblClassName = DefaultComponentFactory.getInstance().createLabel("Class name");
		panel.add(lblClassName, "1, 2, left, center");
		
		textFieldClassName = new JTextField();
		panel.add(textFieldClassName, "3, 2, fill, top");
		textFieldClassName.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		panel.add(btnSave, "5, 2");
		
		JLabel lblStudentsList = DefaultComponentFactory.getInstance().createLabel("Students list");
		add(lblStudentsList, "2, 4");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "2, 6, fill, fill");
		
		modelClass = new DefaultListModel<>();
		listClass = new JList<Student>(modelClass);
		scrollPane.setViewportView(listClass);

	}

	@Override
	public void setObject(HedspiClass obj) {
		getTextFieldClassName().setText(obj.getName());
		
		modelClass.removeAllElements();
		for(Student it : obj.getStudents().getSortedListIgnoreCase())
			modelClass.addElement(it);
	}

	protected JList<Student> getListClass() {
		return listClass;
	}
	protected JTextField getTextFieldClassName() {
		return textFieldClassName;
	}
}
