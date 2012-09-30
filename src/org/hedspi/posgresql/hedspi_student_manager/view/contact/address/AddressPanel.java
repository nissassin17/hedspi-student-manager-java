package org.hedspi.posgresql.hedspi_student_manager.view.contact.address;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import org.hedspi.posgresql.hedspi_student_manager.model.Model;
import org.hedspi.posgresql.hedspi_student_manager.model.contact.address.City;
import org.hedspi.posgresql.hedspi_student_manager.model.hedspi.HedspiObjects;
import org.hedspi.posgresql.hedspi_student_manager.view.util.list.ObjectListPanel;

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
		
		panel = new CityPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		setLeftComponent(scrollPane);
		
		ObjectListPanel<City> panel_1 = new ObjectListPanel<City>(panel);
		panel_1.setList(((HedspiObjects<City>)Model.getInstance().getData("getCitiesList")).getSortedListIgnoreCase());
		scrollPane.setViewportView(panel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		setRightComponent(scrollPane_1);
		
		scrollPane_1.setViewportView(panel);

	}

}
