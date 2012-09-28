/**
 * 
 */
package org.hedspi.posgresql.hedspi_student_manager.control;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JOptionPane;

import org.hedspi.posgresql.hedspi_student_manager.model.LoginInfo;
import org.hedspi.posgresql.hedspi_student_manager.model.Model;
import org.hedspi.posgresql.hedspi_student_manager.view.IView;
import org.hedspi.posgresql.hedspi_student_manager.view.function_window.FunctionWindow;
import org.hedspi.posgresql.hedspi_student_manager.view.login.LoginWindow;

/**
 * Thanh phan control trong mo hinh MVC.
 * Control de dang single skeleton, goi getInstance() de lay instance.
 * @author haidang-ubuntu
 *
 */
public class Control implements IControl{
	private static final String LOG_DIR = "log";
	private static final String LOG_FILE_NAME = LOG_DIR + "/"+(new SimpleDateFormat("yyyy-MM-dd--HH-mm-ss").format(Calendar.getInstance().getTime()))+".log";
	private static Control instance = null;
	private Logger logger;
	private FileHandler logFileHandler;
	private FunctionWindow functionWindow;
	
	/**
	 * init and open log
	 */
	private Control(){
		logger = Logger.getLogger("hedspi-student-manager");
		try {
			if (!(new File(LOG_DIR)).exists())
				(new File(LOG_DIR)).mkdir();
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
	/**
	 * triggered by any
	 */
	@Override
	public void fire(String command, Object... data) {
		switch(command){
		case "start":
			start();
			break;
		case "exit":
			logger.log(Level.INFO, "System exits");
			System.exit(0);
			
		default:
			logger.log(Level.WARNING, "You have called Control an operation that is not supported.\nCommand: " + command);
		}
		
	}
	
	/**
	 * Triggered by view
	 */
	@Override
	public void fireByView(IView view, String command, Object... data) {
		switch(command){
		case "try-login":
			tryLogin(view, (LoginInfo)data[0]);
			break;
		case "init-database":
			initDatabase(view, data[0]);
			break;
		default:
			logger.log(Level.WARNING, "A view has fired Control an operation that is not supported.\nCommand: " + command);
		}
		
	}

	private void initDatabase(IView view, Object data) {
		logger.log(Level.INFO, "Init database");
		String message = (String)Model.getInstance().getData("init-database", data);
		if (message == "")
			logger.log(Level.INFO, "Init database successed");
		else
			logger.log(Level.WARNING, "Init database failed.\nMessage: " + message);
		view.fire("init-database-result", message);
	}

	private void start() {
		try{
			logger.log(Level.INFO, "System starts");
			logger.log(Level.INFO, "Open login window");
			login = new LoginWindow();
			login.fire("set-visible", true);
		} catch (Throwable e){
			logger.log(Level.SEVERE, "An error has occured when try to start program.\nMessage: " + e.getMessage());
			JOptionPane.showMessageDialog(null, "An error has occured when try to start program.\nMessage: " + e.getMessage(), "Starting program errors", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void tryLogin(IView view, LoginInfo loginInfo) {
		logger.log(Level.INFO, "Try login");
		boolean ok = (boolean)Model.getInstance().getData("check-login", loginInfo);
		if (!ok){
			view.fire("login-fail");
			logger.log(Level.INFO, "Login failed");
		} else{
			logger.log(Level.INFO, "Login success");
			//hide current login
			view.fire("set-visible", false);
			//show function list
			functionWindow = new FunctionWindow(loginInfo);
			logger.log(Level.INFO, "Show main function window");
			functionWindow.fire("set-visible", true);
		}
	}

	@Override
	public Logger getLogger() {
		return logger;
	}
}
