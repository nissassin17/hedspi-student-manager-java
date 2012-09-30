package org.hedspi.posgresql.hedspi_student_manager.view.contact.address;

import javax.swing.JSplitPane;
import javax.swing.JScrollPane;

import org.hedspi.posgresql.hedspi_student_manager.model.contact.address.City;

public class AddressPanel extends JSplitPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CityPanel panel;

	/**
	 * Create the panel.
	 */
	public AddressPanel() {
		
		JScrollPane scrollPane = new JScrollPane();
		setLeftComponent(scrollPane);
		
		CityListPanel panel_1 = new CityListPanel(this);
		scrollPane.setViewportView(panel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		setRightComponent(scrollPane_1);
		
		panel = new CityPanel();
		scrollPane_1.setViewportView(panel);

	}

	public void setCity(City source) {
		panel.setCity(source);
	}

}
