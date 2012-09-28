package org.hedspi.posgresql.hedspi_student_manager.view.function_window;

import java.awt.BorderLayout;
import java.util.Properties;
import java.util.logging.Level;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.hedspi.posgresql.hedspi_student_manager.control.Control;
import org.hedspi.posgresql.hedspi_student_manager.view.IView;
import org.hedspi.posgresql.hedspi_student_manager.view.contact.ContactPane;
import org.hedspi.posgresql.hedspi_student_manager.view.student.add.StudentOtherInfoPanel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JSeparator;
import java.awt.Dimension;
import javax.swing.JLayeredPane;
import java.awt.Component;
import javax.swing.border.TitledBorder;
import com.jgoodies.forms.factories.FormFactory;

public class AllFunction extends JFrame implements IView{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPaneMain;
	private Properties loginInfo;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AllFunction frame = new AllFunction();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @param loginInfo 
	 */
	public AllFunction(Properties loginInfo) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
		        if (JOptionPane.showConfirmDialog(arg0.getWindow(), "Are you sure want to quit?", "Quit?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
		            arg0.getWindow().setVisible(false);
		            arg0.getWindow().dispose();
		        };
			}
			@Override
			public void windowClosed(WindowEvent e) {
				Control.getInstance().fire("exit");
			}
		});
		this.loginInfo = loginInfo;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 774, 478);
		contentPaneMain = new JPanel();
		contentPaneMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPaneMain.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPaneMain);
		
		JTabbedPane tabbedPaneAll = new JTabbedPane(JTabbedPane.LEFT);
		contentPaneMain.add(tabbedPaneAll, BorderLayout.CENTER);
		
		JTabbedPane tabbedPaneStudent = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneAll.addTab("Student", null, tabbedPaneStudent, null);
		
		JScrollPane scrollPaneViewStudent = new JScrollPane();
		tabbedPaneStudent.addTab("View", null, scrollPaneViewStudent, null);
		
		JScrollPane scrollPaneAddStudent = new JScrollPane();
		tabbedPaneStudent.addTab("Add", null, scrollPaneAddStudent, null);
		
		JPanel panel = new JPanel();
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		scrollPaneAddStudent.setViewportView(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("712px:grow"),}));
		
		ContactPane panel_1 = new ContactPane();
		panel.add(panel_1, "2, 2, fill, fill");
		
		StudentOtherInfoPanel panel_2 = new StudentOtherInfoPanel();
		panel.add(panel_2, "4, 2, fill, top");
		
		JScrollPane scrollPaneEditStudent = new JScrollPane();
		tabbedPaneStudent.addTab("Edit", null, scrollPaneEditStudent, null);
		
		JTabbedPane tabbedPaneLecturer = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneAll.addTab("Lecturer", null, tabbedPaneLecturer, null);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPaneLecturer.addTab("View", null, scrollPane, null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPaneLecturer.addTab("Add", null, scrollPane_1, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		tabbedPaneLecturer.addTab("Edit", null, scrollPane_2, null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneAll.addTab("Class", null, tabbedPane, null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneAll.addTab("Course", null, tabbedPane_1, null);
	}
	
    @Override
    public void fire(String command, Object... data) {
        switch (command) {
            case "set-visible":
                super.setVisible((boolean) data[0]);
                break;
            case "init-database-result":
                String message = (String) data[0];
                if ("".equals(message)) {
                    JOptionPane.showMessageDialog(this, "Init database success", "Init successed", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Init database failed.\nMessage: " + message, "Init failed", JOptionPane.ERROR_MESSAGE);
                }
                break;

            default:
                Control.getInstance().getLogger().log(Level.WARNING, "You have called FunctionWindow an operation that is not supported.\nCommand: {0}", command);
                break;
        }
    }
}
