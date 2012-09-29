package org.hedspi.posgresql.hedspi_student_manager.view.contact.address;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JList;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CityListPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public CityListPanel() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(91dlu;default):grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(97dlu;default):grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblCitiesList = DefaultComponentFactory.getInstance().createLabel("Cities list");
		add(lblCitiesList, "2, 2");
		
		JList list = new JList();
		add(list, "2, 4, fill, fill");
		
		textField = new JTextField();
		add(textField, "2, 6, fill, top");
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		add(panel, "2, 8, center, top");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAdd = new JButton("Add");
		panel.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		panel.add(btnRemove);

	}

}
