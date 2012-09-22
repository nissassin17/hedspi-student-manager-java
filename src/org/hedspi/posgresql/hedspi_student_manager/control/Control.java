/**
 * 
 */
package org.hedspi.posgresql.hedspi_student_manager.control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JOptionPane;

import org.hedspi.posgresql.hedspi_student_manager.view.IView;
import org.hedspi.posgresql.hedspi_student_manager.view.login.LoginWindow;

/**
 * Thanh phan control trong mo hinh MVC.
 * Control de dang single skeleton, goi getInstance() de lay instance.
 * @author haidang-ubuntu
 *
 */
public class Control implements IControl{
	private static final String LOG_FILE_NAME = "log/"+(new SimpleDateFormat("yyyy-MM-dd--HH-mm-ss").format(Calendar.getInstance().getTime()))+".log";
	private static Control instance = null;
	private Logger logger;
	private FileHandler logFileHandler;
	private Control(){
		logger = Logger.getLogger("hedspi-student-manager");
		try {
			logFileHandler = new FileHandler(LOG_FILE_NAME);
		} catch (SecurityException | IOException e) {
			JOptionPane.showMessageDialog(null, "An error has occured while opening log file with name: " + LOG_FILE_NAME + "\nMessage: " + e.getMessage(), "Opening log file failed", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		logFileHandler.setFormatter(new SimpleFormatter());
		logger.addHandler(logFileHandler);
	}

	public static Control getInstance(){
		if (instance == null)
			instance= new Control();
		return instance;
	}
	
	private IView login;
	@Override
	public void fire(String command, Object... data) {
		switch(command){
		case "start":
			try{
				logger.log(Level.INFO, "System starts");
				login = new LoginWindow();
				login.fire("open");
			} catch (Exception e){
				logger.log(Level.SEVERE, "An error has occured when try to start program.\nMessage: " + e.getMessage());
				JOptionPane.showMessageDialog(null, "An error has occured when try to start program.\nMessage: " + e.getMessage(), "Starting program errors", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case "exit":
			logger.log(Level.INFO, "System exits");
			System.exit(0);
			
		default:
			logger.log(Level.WARNING, "You have called Control an operation that is not supported.\nCommand: " + command);
		}
		
	}
	@Override
	public void fireByView(IView view, String command, Object... data) {
		switch(command){
		default:
			logger.log(Level.WARNING, "A view has fired Control an operation that is not supported.\nCommand: " + command);
		}
		
	}

	@Override
	public Logger getLogger() {
		return logger;
	}
}
