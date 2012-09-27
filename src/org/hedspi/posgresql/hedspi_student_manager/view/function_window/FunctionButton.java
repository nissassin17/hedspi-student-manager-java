package org.hedspi.posgresql.hedspi_student_manager.view.function_window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class FunctionButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IActionContainer actionContainer;

	public FunctionButton(String funcName, char mnemonic, IActionContainer actionContainer){
		this(funcName, actionContainer);
		super.setMnemonic(mnemonic);
	}
	
	public FunctionButton(String funcName, IActionContainer actionContainer){
		super();
		super.setText(funcName);
		this.actionContainer = actionContainer;
		super.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				IActionContainer actionContainer = ((FunctionButton)e.getSource()).getActionContainer();
				if (actionContainer != null)
					actionContainer.doAction();
			}
		});
	}
	
	public IActionContainer getActionContainer(){
		return actionContainer;
	}
}
