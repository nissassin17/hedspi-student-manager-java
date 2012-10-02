package org.hedspi.posgresql.hedspi_student_manager.view.util;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class AssociatedTextField <T extends Object> extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ITextFieldUpdater<T> textFieldUpdater;
	private AssociatedTextField<T> cloned;
	
	public AssociatedTextField(ITextFieldUpdater<T> textFieldUpdaterArg, T objectArg) {
		super();
		cloned = this;
		this.textFieldUpdater = textFieldUpdaterArg;
		this.object = objectArg;
		super.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				changedUpdate(arg0);
			}
			
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				changedUpdate(arg0);
			}
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				if (textFieldUpdater != null && object != null)
					textFieldUpdater.setText(object, cloned.getText());
			}
		});
	}
	
	public AssociatedTextField(ITextFieldUpdater<T> textFieldUpdaterArg){
		this(textFieldUpdaterArg, null);
	}

	private T object;

	public void setObject(T object) {
		this.object = object;
		super.setText(textFieldUpdater.getText(object));
	}
	
}
