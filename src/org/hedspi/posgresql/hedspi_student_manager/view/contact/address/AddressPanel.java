package org.hedspi.posgresql.hedspi_student_manager.view.contact.address;

import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JPanel;

public class AddressPanel extends JSplitPane {

	/**
	 * Create the panel.
	 */
	public AddressPanel() {
		
		JScrollPane scrollPane = new JScrollPane();
		setLeftComponent(scrollPane);
		
		CityListPanel panel_1 = new CityListPanel();
		scrollPane.setViewportView(panel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		setRightComponent(scrollPane_1);
		
		CityPanel panel = new CityPanel();
		scrollPane_1.setViewportView(panel);

	}

}
