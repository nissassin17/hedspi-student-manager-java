package org.hedspi.posgresql.hedspi_student_manager.view.contact;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.hedspi.posgresql.hedspi_student_manager.model.contact.Contact;
import org.hedspi.posgresql.hedspi_student_manager.model.contact.address.City;
import org.hedspi.posgresql.hedspi_student_manager.model.contact.address.District;
import org.hedspi.posgresql.hedspi_student_manager.model.hedspi.SortedHedspiObjectsComboModel;
import org.hedspi.posgresql.hedspi_student_manager.view.util.AssociatedTextField;
import org.hedspi.posgresql.hedspi_student_manager.view.util.ITextFieldUpdater;
import org.hedspi.posgresql.hedspi_student_manager.view.util.list.DefaultListEditor;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.toedter.calendar.JDateChooser;

public class ContactPane extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AssociatedTextField<Contact> textFieldHome;
	private AssociatedTextField<Contact> textFieldLast;
	private AssociatedTextField<Contact> textFieldFirst;
	private JDateChooser textFieldBrithday;
	private SortedHedspiObjectsComboModel<District> districtModel;
	private DefaultListEditor listPhone;
	public DefaultListEditor getListPhone() {
		return listPhone;
	}


	public void setListPhone(DefaultListEditor listPhone) {
		this.listPhone = listPhone;
	}


	public DefaultListEditor getListEmail() {
		return listEmail;
	}


	public void setListEmail(DefaultListEditor listEmail) {
		this.listEmail = listEmail;
	}


	public DefaultListEditor getListImage() {
		return listImage;
	}


	public void setListImage(DefaultListEditor listImage) {
		this.listImage = listImage;
	}

	private DefaultListEditor listEmail;
	private DefaultListEditor listImage;
	private JEditorPane editorPanelNote;
	private JComboBox<City> comboBoxCity;
	private JComboBox<District> comboBoxDistrict;
	private JToggleButton toggleButtonSex;

	private void setCity(City currentCity) {
		getComboBox_1().setSelectedItem(currentCity);
		getComboBox().setModel(currentCity.getDistricts().getComboBoxModel());
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
		
		districtModel = new SortedHedspiObjectsComboModel<District>();
		comboBoxDistrict = new JComboBox<>(districtModel);
		
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
		
		textFieldHome = new AssociatedTextField<>(new ITextFieldUpdater<Contact>() {

			@Override
			public void setText(Contact obj, String text) {
				obj.setHome(text);
			}

			@Override
			public String getText(Contact obj) {
				return obj.getHome();
			}
		});
		textFieldHome.setColumns(10);
		
		textFieldLast = new AssociatedTextField<>(new ITextFieldUpdater<Contact>() {

			@Override
			public void setText(Contact obj, String text) {
				obj.setLastName(text);
			}

			@Override
			public String getText(Contact obj) {
				return obj.getLastName();
			}
		});
		textFieldLast.setColumns(10);
		
		textFieldFirst = new AssociatedTextField<Contact>(new ITextFieldUpdater<Contact>() {

			@Override
			public void setText(Contact obj, String text) {
				obj.setFirstName(text);
				
			}

			@Override
			public String getText(Contact obj) {
				return obj.getFirstName();
			}
		});
		textFieldFirst.setColumns(10);
		
		textFieldBrithday = new JDateChooser();
		
		comboBoxCity = new JComboBox<>(City.getCities().getComboBoxModel());
		comboBoxCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox<City> cities = (JComboBox<City>)arg0.getSource();
				City currentCity = cities.getItemAt(cities.getSelectedIndex());
				setCity(currentCity);
			}

		});
		
		listPhone = new DefaultListEditor();
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
		add(comboBoxCity, "4, 15, fill, top");
		add(label_8, "3, 19, left, center");
		
		JLabel lblPhones = new JLabel("Phones");
		add(lblPhones, "3, 20");
		add(listPhone, "4, 20, fill, fill");
		add(textFieldHome, "4, 19, fill, top");
		add(label_6, "3, 17, left, center");
		add(comboBoxDistrict, "4, 17, fill, top");
		
		JLabel lblEmails = new JLabel("Emails");
		add(lblEmails, "3, 21");
		
		listEmail = new DefaultListEditor();
		add(listEmail, "4, 21, fill, fill");
		
		JLabel lblImageUrls = DefaultComponentFactory.getInstance().createLabel("Image urls");
		add(lblImageUrls, "3, 22");
		
		listImage = new DefaultListEditor();
		add(listImage, "4, 22, fill, fill");
		
		JLabel lblNotes = new JLabel("Notes");
		add(lblNotes, "3, 23");
		
		editorPanelNote = new JEditorPane();
		editorPanelNote.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(editorPanelNote, "4, 23, fill, fill");

	}
	
	private Contact contact;

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
		getTextFieldBrithday().setDate(contact.getDob());
		textFieldFirst.setObject(contact);
		textFieldLast.setObject(contact);
		textFieldHome.setObject(contact);
		getListPhone().setHedspiObject(contact.getPhone());
		getListEmail().setHedspiObject(contact.getEmail());
		getListImage().setHedspiObject(contact.getImage());
		getEditorPanelNote().setText(contact.getNote());
		setCity(contact.getDistrict().getCity());
		District dt = contact.getDistrict();
		if (dt.getMyCity() == contact.getDistrict().getCity())
			getComboBox().setSelectedItem(dt);
		
		getToggleButtonSex().setSelected(!contact.isMan());
	}

	protected JEditorPane getEditorPanelNote() {
		return editorPanelNote;
	}
	protected JComboBox<City> getComboBox_1() {
		return comboBoxCity;
	}
	protected JComboBox<District> getComboBox() {
		return comboBoxDistrict;
	}
	protected JToggleButton getToggleButtonSex() {
		return toggleButtonSex;
	}
	protected JDateChooser getTextFieldBrithday() {
		return textFieldBrithday;
	}
	
//	public Contact getCurrentContact(){
//		Date dob = getTextFieldBrithday().getDate();
//		boolean isMan = toggleButtonSex.isSelected();
//		String last = textFieldLast.getText();
//		String first = textFieldFirst.getText();
//		District district = (District)comboBoxDistrict.getSelectedItem();
//		ArrayList<String> phone = listPhone.getValues();
//		ArrayList<String> emails = listEmail.getValues();
//		ArrayList<String> images = listEditorImage.getValues();
//		String home = textFieldHome.getText();
//		String note = editorPanelNote.getText();
//		
//		Contact contact = new Contact(getContact().getId(), note, images, phone, dob, isMan, first, last, emails, home, district);
//		
//		return contact;
//	}
}
