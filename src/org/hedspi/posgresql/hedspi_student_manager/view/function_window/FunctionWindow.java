package org.hedspi.posgresql.hedspi_student_manager.view.function_window;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.logging.Level;

import javax.swing.JOptionPane;

import org.hedspi.posgresql.hedspi_student_manager.control.Control;
import org.hedspi.posgresql.hedspi_student_manager.model.LoginInfo;
import org.hedspi.posgresql.hedspi_student_manager.view.IView;
import org.hedspi.posgresql.hedspi_student_manager.view.util.CancelButton;
import org.hedspi.posgresql.hedspi_student_manager.view.util.IFrameAskToClose;

public class FunctionWindow extends IFrameAskToClose implements IView {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Dimension WINDOW_SIZE = new Dimension(500, 500);
	private IView view;
	
	LoginInfo loginInfo;
	public FunctionWindow(LoginInfo loginInfo){
		super();
		view = this;
		this.loginInfo = loginInfo;
		setUIBase();
	}
	private void setUIBase() {
		super.setSize(WINDOW_SIZE);
		super.setLayout(new FlowLayout(FlowLayout.CENTER));
		super.getContentPane().add(new FunctionButton("Init database", 'i', new IActionContainer() {
			
			@Override
			public void doAction() {
				Control.getInstance().fireByView(view, "init-database", loginInfo);
			}
		}));
		super.getContentPane().add(new CancelButton(this));
	}
	
	@Override
	public void fire(String command, Object... data) {
		switch(command){
		case "set-visible":
			this.setVisible((boolean)data[0]);
			break;
		case "init-database-result":
			String message = (String)data[0];
			if (message == "")
				JOptionPane.showMessageDialog(this, "Init database success", "Init successed", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(this, "Init database failed.\nMessage: " + message, "Init failed", JOptionPane.ERROR_MESSAGE);
			break;

		default:
			Control.getInstance().getLogger().log(Level.WARNING, "You have called FunctionWindow an operation that is not supported.\nCommand: " + command);
			break;
		}
	}
	
	public void close() {
		if (JOptionPane.showConfirmDialog(this, "Are you sure want to quit?", "Quit?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			super.setVisible(false);
			super.dispose();
		};
	}

}
