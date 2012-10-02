package org.hedspi.posgresql.hedspi_student_manager.view.util.list;

import java.awt.FlowLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JScrollPane;

public class ObjectListPanel<T extends Object> extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IObjectViewPanel<T> viewPanel;

	/**
	 * Create the panel.
	 */
	public ObjectListPanel(IObjectViewPanel<T> viewPanelArg, DefaultListModel<T> model) {
		this.viewPanel = viewPanelArg;
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(91dlu;default):grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(97dlu;default):grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblCitiesList = DefaultComponentFactory.getInstance().createLabel("Values list");
		add(lblCitiesList, "2, 4");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "2, 6, fill, fill");
		JList<T> list_1 = new JList<>(model);
		scrollPane.setViewportView(list_1);
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (!arg0.getValueIsAdjusting()){
		            JList<T> list = (JList<T>)arg0.getSource();
		            if (list.getSelectedValue() != null)
		            	viewPanel.setObject(list.getSelectedValue());
				}
			}
		});
		
		SortBox<T> panel_1 = new SortBox<>(model);
		add(panel_1, "2, 2, fill, top");
		
		JPanel panel = new JPanel();
		add(panel, "2, 8, center, top");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAdd = new JButton("Add");
		panel.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		panel.add(btnRemove);

	}

}
