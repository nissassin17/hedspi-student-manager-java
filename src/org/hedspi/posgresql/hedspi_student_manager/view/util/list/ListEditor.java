package org.hedspi.posgresql.hedspi_student_manager.view.util.list;

import java.awt.Component;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

public class ListEditor<T extends Object> extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private DefaultListModel<T> listModel;
	private JList<T> list;
	private IElementGetter<T> elementGetter;

	public ListEditor(IElementGetter<T> elementGetter) {
		this();
		this.elementGetter = elementGetter;
	}

	/**
	 * Create the panel.
	 */
	public ListEditor() {
		elementGetter = new IElementGetter<T>() {

			@Override
			public T getElement(String val) {
				return (T)val;
			}
		};
		setLayout(new MigLayout("", "[82.00px:211.00px:100.00%,grow][49.00:52.00:423.00]", "[:24.00px:33.00px][241.00,grow]"));

		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				JTextField textField = (JTextField) arg0.getComponent();
				textField.selectAll();
			}

			@Override
			public void focusLost(FocusEvent e) {
				JTextField textField = (JTextField) e.getComponent();
				textField.select(0, 0);
			}
		});
		add(textField, "cell 0 0,grow");
		textField.setColumns(10);

		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String val = textField.getText();
				if (val.equals(""))
					return;
				listModel.addElement(elementGetter.getElement(val));
				textField.setText("");
			}
		});
		add(btnAdd, "cell 1 0,growx,aligny center");

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 1,grow");

		listModel = new DefaultListModel<>();
		list = new JList<>(listModel);
		scrollPane.setViewportView(list);

		JPanel panel = new JPanel();
		add(panel, "flowx,cell 1 1,grow");
		panel.setLayout(new FormLayout(new ColumnSpec[] { ColumnSpec
				.decode("39px:grow"), }, new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, }));

		JButton button = new JButton("{}");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.setSelectionInterval(0, list.getModel().getSize() - 1);
			}
		});
		panel.add(button, "1, 2, fill, top");

		JButton btnRemove = new JButton("-");
		panel.add(btnRemove, "1, 4, fill, top");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selected = list.getSelectedIndices();
				ArrayList<T> arr = new ArrayList<>();
				boolean[] mark = new boolean[listModel.getSize()];
				for (int i = 0; i < listModel.getSize(); i++)
					mark[i] = false;
				for (int i = 0; i < selected.length; i++)
					mark[selected[i]] = true;
				for (int i = 0; i < listModel.getSize(); i++)
					if (!mark[i])
						arr.add(listModel.getElementAt(i));
				listModel.removeAllElements();
				for (T it : arr)
					listModel.addElement(it);
			}
		});
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {
				textField, btnAdd, btnRemove, scrollPane }));

	}

	public void setValues(Collection<T> collection) {
		listModel.clear();
		for(T it : collection)
			listModel.addElement(it);
	}
	
	public ArrayList<T> getValues(){
		ArrayList<T> val = new ArrayList<>();
		for(int i = 0; i < listModel.getSize(); i ++)
			val.add(listModel.get(i));
		return val;
	}

}
