package org.hedspi.posgresql.hedspi_student_manager.view.login;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.hedspi.posgresql.hedspi_student_manager.control.Control;
import org.hedspi.posgresql.hedspi_student_manager.view.IView;
import org.hedspi.posgresql.hedspi_student_manager.view.util.CancelButton;
import org.hedspi.posgresql.hedspi_student_manager.view.util.Closable;
import org.hedspi.posgresql.hedspi_student_manager.view.util.InputField;


public class LoginWindow extends JFrame implements IView, Closable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Dimension DEFAULT_LOGIN_SIZE = new Dimension(300, 170);
	private InputField username;
	private InputField password;
	private InputField host;
	private FlowLayout fl;
	private static final String DEFAULT_HOST = "localhost";
	
	public LoginWindow(){
		setUIBase();
		setWindowOperation();
	}


	private void setUIBase() {
		//base info
		super.setTitle("Hedspi student manager - login");
		super.setSize(DEFAULT_LOGIN_SIZE);
		super.setResizable(false);
		
		//add components
		fl = new FlowLayout(FlowLayout.CENTER);
		super.getContentPane().setLayout(fl);
		
		//input field
		addInputField();
		addOkCancel();
	}

	private void addOkCancel() {
		JButton loginButton = new LoginButton(this);
		super.getContentPane().add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Control.getInstance().fireByView(((LoginButton)e.getSource()).getLoginWindow(), "try-login", host.getValue(), username.getValue(), password.getValue());
			}
		});

		super.getContentPane().add(new CancelButton(this));
	}


	private void addInputField() {
		//host
		host = new InputField("Host address: ", DEFAULT_HOST);
		host.setMnemonic('h');
		super.getContentPane().add(host);
		
		//username
		username = new InputField("User name");
		username.setMnemonic('u');
		super.getContentPane().add(username);
		
		//password
		password = new InputField("Password", true);
		password.setMnemonic('p');
		super.getContentPane().add(password);

	}

	@Override
	public void fire(String command, Object... data) {
		switch (command){
		case "open":
			super.setVisible(true);
			break;
			
			default:
				Control.getInstance().getLogger().log(Level.WARNING, "You have called LoginWindow an operation that is not supported.\nCommand: " + command);
		}
	}
	
	private void setWindowOperation() {
		super.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		super.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
				Control.getInstance().getLogger().log(Level.INFO, "Open login window");
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				Control.getInstance().getLogger().log(Level.INFO, "Iconify login window");
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				Control.getInstance().getLogger().log(Level.INFO, "Deiconify login window");
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				Control.getInstance().getLogger().log(Level.INFO, "Deactivate login window");
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				((LoginWindow)e.getComponent()).close();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				Control.getInstance().getLogger().log(Level.INFO, "Close login window");
				Control.getInstance().fire("exit");
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				Control.getInstance().getLogger().log(Level.INFO, "Activate login window");
			}
		});
	}


	public void close() {
		Control.getInstance().getLogger().log(Level.INFO, "Ask to quit program when close login form");
		if (JOptionPane.showConfirmDialog(this, "Are you sure want to quit?", "Quit?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			Control.getInstance().getLogger().log(Level.INFO, "Yes, close login window and quit program now");
			super.setVisible(false);
			super.dispose();
		} else Control.getInstance().getLogger().log(Level.INFO, "No, keep program running");
	}

}