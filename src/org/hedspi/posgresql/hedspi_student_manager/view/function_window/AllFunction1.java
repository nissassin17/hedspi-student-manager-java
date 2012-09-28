package org.hedspi.posgresql.hedspi_student_manager.view.function_window;

import java.util.logging.Level;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.hedspi.posgresql.hedspi_student_manager.control.Control;
import org.hedspi.posgresql.hedspi_student_manager.view.IView;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class AllFunction1 implements IView {

	private JFrame frame;
	private java.util.Properties loginInfo;
	private AllFunction1 view;
	private JTextField txtFirst;
	private JTextField txtLast;
	private JTextField txtDOB;

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
	public AllFunction1(java.util.Properties loginInfo) {
		initialize();
		this.loginInfo = loginInfo;
		view = this;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
		        if (JOptionPane.showConfirmDialog(frame, "Are you sure want to quit?", "Quit?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
		            frame.setVisible(false);
		            frame.dispose();
		        };

			}
			@Override
			public void windowClosed(WindowEvent e) {
				Control.getInstance().fire("exit");
			}
		});
		frame.setBounds(100, 100, 674, 461);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{442, 0};
		gridBagLayout.rowHeights = new int[]{273, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JTabbedPane funcCategorytabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		funcCategorytabbedPane.setToolTipText("List of function categories");
		GridBagConstraints gbc_funcCategorytabbedPane = new GridBagConstraints();
		gbc_funcCategorytabbedPane.fill = GridBagConstraints.BOTH;
		gbc_funcCategorytabbedPane.gridx = 0;
		gbc_funcCategorytabbedPane.gridy = 0;
		frame.getContentPane().add(funcCategorytabbedPane, gbc_funcCategorytabbedPane);
		
		JTabbedPane studentPane = new JTabbedPane(JTabbedPane.TOP);
		funcCategorytabbedPane.addTab("Student", null, studentPane, "Student management");
		
		JScrollPane viewStudentScrollPane = new JScrollPane();
		studentPane.addTab("View", null, viewStudentScrollPane, "To view student list");
		
		JScrollPane addStudentScrollPane = new JScrollPane();
		studentPane.addTab("Add", null, addStudentScrollPane, "To add new student");
		
		JPanel panel = new JPanel();
		addStudentScrollPane.setViewportView(panel);
		
		JLabel lblName = new JLabel("Name");
		
		JLabel lblFirst = new JLabel("First*");
		
		txtFirst = new JTextField();
		lblFirst.setLabelFor(txtFirst);
		txtFirst.setColumns(10);
		
		JLabel lblLast = new JLabel("Last*");
		
		txtLast = new JTextField();
		lblLast.setLabelFor(txtLast);
		txtLast.setColumns(10);
		
		JLabel lblSex = new JLabel("Sex*");
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		lblSex.setLabelFor(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		
		JLabel lblBirthday = new JLabel("Birthday*");
		
		txtDOB = new JTextField();
		lblBirthday.setLabelFor(txtDOB);
		txtDOB.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		
		JLabel lblCity = new JLabel("City*");
		
		JLabel lblDistrict = new JLabel("District*");
		
		JLabel lblHome = new JLabel("Home");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAddress)
						.addComponent(lblName)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFirst)
										.addComponent(lblLast)))
								.addComponent(lblSex)
								.addComponent(lblBirthday))
							.addGap(109)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(rdbtnMale)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnFemale))
								.addComponent(txtLast)
								.addComponent(txtFirst, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
								.addComponent(txtDOB)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDistrict)
								.addComponent(lblCity)
								.addComponent(lblHome))))
					.addContainerGap(278, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(lblName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFirst)
						.addComponent(txtFirst, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLast)
						.addComponent(txtLast, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnMale)
						.addComponent(rdbtnFemale)
						.addComponent(lblSex))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDOB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBirthday))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAddress)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCity)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDistrict)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblHome)
					.addContainerGap(205, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane editStudentScrollPane = new JScrollPane();
		studentPane.addTab("Edit", null, editStudentScrollPane, "To edit student");
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
