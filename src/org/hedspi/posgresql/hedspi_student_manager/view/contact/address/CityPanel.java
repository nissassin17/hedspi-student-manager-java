package org.hedspi.posgresql.hedspi_student_manager.view.contact.address;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.hedspi.posgresql.hedspi_student_manager.model.contact.address.City;
import org.hedspi.posgresql.hedspi_student_manager.model.contact.address.District;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class CityPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private DefaultComboBoxModel<District> model;
	private City city;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
		textField_1.setText(city.getName());
		model.removeAllElements();
		for(District it : city.getDistricts().getSortedListIgnoreCase())
			model.addElement(it);
	}

	/**
	 * Create the panel.
	 */
	public CityPanel() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("top:4dlu"),
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("fill:max(30dlu;default):grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "2, 2, fill, fill");
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("56px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("86px:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),}));
		
		JLabel lblName = DefaultComponentFactory.getInstance().createLabel("City name");
		panel_1.add(lblName, "1, 2, left, center");
		
		textField_1 = new JTextField();
		panel_1.add(textField_1, "3, 2, fill, top");
		textField_1.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		panel_1.add(btnSave, "5, 2");
		
		JLabel lblDistrictList = DefaultComponentFactory.getInstance().createLabel("Districts list");
		add(lblDistrictList, "2, 4, left, top");
		
		JPanel panel_2 = new JPanel();
		add(panel_2, "2, 6, fill, fill");
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("444px:grow"),},
			new RowSpec[] {
				RowSpec.decode("92px:grow"),}));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, "1, 1, fill, fill");
		
		model = new DefaultComboBoxModel<>();
		JList<District> list = new JList<>(model);
		scrollPane.setViewportView(list);
		
		JRadioButton rdbtnAddFromExists = new JRadioButton("Add from exists");
		add(rdbtnAddFromExists, "2, 8");
		
		JComboBox comboBox = new JComboBox();
		add(comboBox, "2, 10, fill, default");
		
		JRadioButton rdbtnAddNew = new JRadioButton("Add new");
		add(rdbtnAddNew, "2, 12");
		
		textField = new JTextField();
		add(textField, "2, 14, fill, default");
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		add(panel, "2, 16, fill, fill");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAdd = new JButton("Add");
		panel.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		panel.add(btnRemove);

	}

}
