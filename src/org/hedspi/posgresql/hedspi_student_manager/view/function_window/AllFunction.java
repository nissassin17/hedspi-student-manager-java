package org.hedspi.posgresql.hedspi_student_manager.view.function_window;

import java.util.logging.Level;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.hedspi.posgresql.hedspi_student_manager.control.Control;
import org.hedspi.posgresql.hedspi_student_manager.view.IView;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;

public class AllFunction implements IView {

	private JFrame frame;
	private java.util.Properties loginInfo;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AllFunction window = new AllFunction();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	/**
	 * Create the application.
	 * @param loginInfo 
	 */
	public AllFunction(java.util.Properties loginInfo) {
		initialize();
		this.loginInfo = loginInfo;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane funcCategorytabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		funcCategorytabbedPane.setToolTipText("List of function categories");
		frame.getContentPane().add(funcCategorytabbedPane, BorderLayout.CENTER);
		
		JTabbedPane overviewTab = new JTabbedPane(JTabbedPane.TOP);
		overviewTab.setToolTipText("Overview function");
		funcCategorytabbedPane.addTab("Overview", null, overviewTab, "Overview function");
		
		JTabbedPane studentTab = new JTabbedPane(JTabbedPane.TOP);
		funcCategorytabbedPane.addTab("Student", null, studentTab, "Student control");
		
		JTabbedPane lecturerTab = new JTabbedPane(JTabbedPane.TOP);
		funcCategorytabbedPane.addTab("Lecturer", null, lecturerTab, "Lecturer management");
		
		JTabbedPane tabbedPane_5 = new JTabbedPane(JTabbedPane.TOP);
		funcCategorytabbedPane.addTab("New tab", null, tabbedPane_5, null);
	}
	
    @Override
    public void fire(String command, Object... data) {
        switch (command) {
            case "set-visible":
                frame.setVisible((boolean) data[0]);
                break;
            case "init-database-result":
                String message = (String) data[0];
                if ("".equals(message)) {
                    JOptionPane.showMessageDialog(frame, "Init database success", "Init successed", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Init database failed.\nMessage: " + message, "Init failed", JOptionPane.ERROR_MESSAGE);
                }
                break;

            default:
                Control.getInstance().getLogger().log(Level.WARNING, "You have called FunctionWindow an operation that is not supported.\nCommand: {0}", command);
                break;
        }
    }


}
