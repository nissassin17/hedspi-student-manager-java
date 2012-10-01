package org.hedspi.posgresql.hedspi_student_manager.view.contact;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.hedspi.posgresql.hedspi_student_manager.model.Model;
import org.hedspi.posgresql.hedspi_student_manager.model.contact.Contact;
import org.hedspi.posgresql.hedspi_student_manager.model.contact.address.City;
import org.hedspi.posgresql.hedspi_student_manager.model.contact.address.District;
import org.hedspi.posgresql.hedspi_student_manager.model.hedspi.HedspiObjects;
import org.hedspi.posgresql.hedspi_student_manager.view.util.list.ListEditor;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class ContactPane extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldHome;
	private JTextField textFieldLast;
	private JTextField textFieldFirst;
	private JDateChooser textFieldBrithday;
	private DefaultComboBoxModel<City> citiesModel;
	private DefaultComboBoxModel<District> districtModel;
	private ListEditor<String> listPhone;
	private ListEditor<String> listEmail;
	private ListEditor<String> listEditorImage;
	private JEditorPane editorPanelNote;
	private JComboBox<City> comboBox_1;
	private JComboBox<District> comboBox;
	private JToggleButton toggleButtonSex;

	public void setCities(HedspiObjects<City> cities) {
		citiesModel.removeAllElements();
		for(City it : cities.getSortedListIgnoreCase())
			citiesModel.addElement(it);
	}
	
	private void setCity(City currentCity) {
		getComboBox_1().setSelectedItem(currentCity);
		districtModel.removeAllElements();
		for(District it : currentCity.getDistricts().getSortedListIgnoreCase())
			districtModel.addElement(it);
	}


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
		
		districtModel = new DefaultComboBoxModel<>();
		comboBox = new JComboBox<>(districtModel);
		
		toggleButtonSex = new JToggleButton("Male");
		toggleButtonSex.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				JToggleButton btn = (JToggleButton)arg0.getSource();
				if (btn.isSelected())
					btn.setText("Female");
				else
					btn.setText("Male");
			}
		});
		
		textFieldHome = new JTextField();
		textFieldHome.setColumns(10);
		
		textFieldLast = new JTextField();
		textFieldLast.setColumns(10);
		
		textFieldFirst = new JTextField();
		textFieldFirst.setColumns(10);
		
		textFieldBrithday = new JDateChooser();
		
		citiesModel = new DefaultComboBoxModel<>();
		comboBox_1 = new JComboBox<>(citiesModel);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox<City> cities = (JComboBox<City>)arg0.getSource();
				City currentCity = cities.getItemAt(cities.getSelectedIndex());
				setCity(currentCity);
			}

		});
		setCities((HedspiObjects<City>)Model.getInstance().getData("getCitiesList"));
		setDefaultDistrict();
		
		listPhone = new ListEditor<String>();
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
				RowSpec.decode("21px"),
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
		add(textFieldFirst, "4, 5, fill, top");
		add(label_3, "3, 7, left, center");
		add(textFieldLast, "4, 7, fill, top");
		add(label_4, "3, 9, left, center");
		add(toggleButtonSex, "4, 9, left, top");
		add(label_5, "3, 11, left, center");
		add(textFieldBrithday, "4, 11, fill, top");
		add(label_9, "3, 13, left, top");
		add(label_7, "3, 15, left, center");
		add(comboBox_1, "4, 15, fill, top");
		add(label_8, "3, 19, left, center");
		
		JLabel lblPhones = new JLabel("Phones");
		add(lblPhones, "3, 20");
		add(listPhone, "4, 20, fill, fill");
		add(textFieldHome, "4, 19, fill, top");
		add(label_6, "3, 17, left, center");
		add(comboBox, "4, 17, fill, top");
		
		JLabel lblEmails = new JLabel("Emails");
		add(lblEmails, "3, 21");
		
		listEmail = new ListEditor<>();
		add(listEmail, "4, 21, fill, fill");
		
		JLabel lblImageUrls = DefaultComponentFactory.getInstance().createLabel("Image urls");
		add(lblImageUrls, "3, 22");
		
		listEditorImage = new ListEditor<>();
		add(listEditorImage, "4, 22, fill, fill");
		
		JLabel lblNotes = new JLabel("Notes");
		add(lblNotes, "3, 23");
		
		editorPanelNote = new JEditorPane();
		editorPanelNote.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(editorPanelNote, "4, 23, fill, fill");

	}

	public void setContact(Contact contact) {
		getTextFieldBrithday().setDate(contact.getDob());
		textFieldFirst.setText(contact.getFirstName());
		textFieldLast.setText(contact.getLastName());
		textFieldHome.setText(contact.getAddress().getHome());
		getListPhone().setValues(contact.getPhone());
		getListEmail().setValues(contact.getEmail());
		getListEditorImage().setValues(contact.getImage());
		getEditorPanelNote().setText(contact.getNote());
		setCity(contact.getAddress().getCity());
		District dt = contact.getAddress().getDistrict();
		if (dt.getMyCity() == contact.getAddress().getCity())
			getComboBox().setSelectedItem(dt);
		else
			setDefaultDistrict();
		
		getToggleButtonSex().setSelected(!contact.isMan());
	}
	private void setDefaultDistrict() {
		City def = null;
		for(int i = 0; i < citiesModel.getSize(); i++)
			if (citiesModel.getElementAt(i).getId().equals("0")){
				def = citiesModel.getElementAt(i);
				break;
			}
		if (def != null)
			setCity(def);

		
	}

	protected ListEditor<String> getListPhone() {
		return listPhone;
	}
	protected ListEditor<String> getListEmail() {
		return listEmail;
	}
	protected ListEditor<String> getListEditorImage() {
		return listEditorImage;
	}
	protected JEditorPane getEditorPanelNote() {
		return editorPanelNote;
	}
	protected JComboBox<City> getComboBox_1() {
		return comboBox_1;
	}
	protected JComboBox<District> getComboBox() {
		return comboBox;
	}
	protected JToggleButton getToggleButtonSex() {
		return toggleButtonSex;
	}
	protected JDateChooser getTextFieldBrithday() {
		return textFieldBrithday;
	}
}
