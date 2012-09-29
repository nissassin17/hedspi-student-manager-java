package org.hedspi.posgresql.hedspi_student_manager.view.util.list;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class ListEditor extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public ListEditor() {
		setLayout(new MigLayout("", "[82.00px:216.00px:669.00px,grow][49.00:56.00:423.00]", "[:24.00px:33.00px][241.00]"));
		
		textField = new JTextField();
		add(textField, "cell 0 0,grow");
		textField.setColumns(10);
		
		JButton btnAdd = new JButton("+");
		btnAdd.setMnemonic('+');
		add(btnAdd, "cell 1 0,alignx right,aligny center");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 1,grow");
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JButton btnRemove = new JButton("-");
		btnRemove.setMnemonic('-');
		add(btnRemove, "cell 1 1,alignx right,aligny center");
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, btnAdd, btnRemove, scrollPane}));

	}

}
