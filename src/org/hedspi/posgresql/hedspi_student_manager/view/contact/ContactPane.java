package org.hedspi.posgresql.hedspi_student_manager.view.contact;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

import org.hedspi.posgresql.hedspi_student_manager.view.util.list.ListEditor;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class ContactPane extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public ContactPane() {
		setBorder(new TitledBorder(null, "Contact information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel label_1 = new JLabel("Name");
		
		JLabel label_2 = new JLabel("First*");
		
		JLabel label_3 = new JLabel("Last*");
		
		JLabel label_4 = new JLabel("Sex*");
		
		JLabel label_5 = new JLabel("Birthday*");
		
		JLabel label_6 = new JLabel("District*");
		
		JLabel label_7 = new JLabel("City*");
		
		JLabel label_8 = new JLabel("Home");
		
		JLabel label_9 = new JLabel("Address");
		
		JComboBox comboBox = new JComboBox();
		
		JToggleButton toggleButton = new JToggleButton("Male");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		
		ListEditor panel = new ListEditor();
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(5dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:64px"),
				ColumnSpec.decode("113px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(6dlu;default)"),},
			new RowSpec[] {
				RowSpec.decode("max(1dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("22px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("22px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				RowSpec.decode("114px"),
				RowSpec.decode("max(122px;default)"),
				RowSpec.decode("81dlu"),
				RowSpec.decode("53px:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(7dlu;default)"),}));
		add(label_1, "3, 3, left, top");
		add(label_2, "3, 5, left, center");
		add(textField_2, "4, 5, fill, top");
		add(label_3, "3, 7, left, center");
		add(textField_1, "4, 7, fill, top");
		add(label_4, "3, 9, left, center");
		add(toggleButton, "4, 9, left, top");
		add(label_5, "3, 11, left, center");
		add(textField_3, "4, 11, fill, top");
		add(label_9, "3, 13, left, top");
		add(label_7, "3, 15, left, center");
		add(comboBox_1, "4, 15, fill, top");
		add(label_8, "3, 19, left, center");
		
		JLabel lblPhones = new JLabel("Phones");
		add(lblPhones, "3, 20");
		add(panel, "4, 20, fill, fill");
		add(textField, "4, 19, fill, top");
		add(label_6, "3, 17, left, center");
		add(comboBox, "4, 17, fill, top");
		
		JLabel lblEmails = new JLabel("Emails");
		add(lblEmails, "3, 21");
		
		ListEditor listEditor = new ListEditor();
		add(listEditor, "4, 21, fill, fill");
		
		JLabel lblImageUrls = DefaultComponentFactory.getInstance().createLabel("Image urls");
		add(lblImageUrls, "3, 22");
		
		ListEditor listEditor_1 = new ListEditor();
		add(listEditor_1, "4, 22, fill, fill");
		
		JLabel lblNotes = new JLabel("Notes");
		add(lblNotes, "3, 23");
		
		JEditorPane editorPane = new JEditorPane();
		add(editorPane, "4, 23, fill, fill");

	}
}
