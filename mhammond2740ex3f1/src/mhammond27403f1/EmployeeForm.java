package mhammond27403f1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class EmployeeForm extends JFrame {

	private JPanel contentPane;
	private JTextField positionTextField;
	private DefaultListModel employeeListModel;
	private JList employeeList;
	private JComboBox deptComboBox;
	private JTextField empIdTextField;
	private JTextField empNameTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeForm frame = new EmployeeForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeForm() {
		setTitle("mhammond COMC2740 Ex3f");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 146);
		contentPane.add(scrollPane);
		
		employeeListModel = new DefaultListModel(); 	//add manually
		employeeList = new JList(employeeListModel);
		scrollPane.setViewportView(employeeList);
		
		JLabel lblEmployeeId = new JLabel("Employee Id:");
		lblEmployeeId.setBounds(10, 172, 94, 14);
		contentPane.add(lblEmployeeId);
		
		JLabel lblEmployeeName = new JLabel("Employee name:");
		lblEmployeeName.setBounds(10, 197, 86, 14);
		contentPane.add(lblEmployeeName);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(10, 223, 86, 14);
		contentPane.add(lblDepartment);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(10, 247, 60, 14);
		contentPane.add(lblPosition);
		
		empIdTextField = new JTextField();
		empIdTextField.setText("101");
		lblEmployeeId.setLabelFor(empIdTextField);
		empIdTextField.setBounds(120, 169, 86, 20);
		contentPane.add(empIdTextField);
		empIdTextField.setColumns(10);
		
		empNameTextField = new JTextField();
		empNameTextField.setText("Mike Hammond");
		lblEmployeeName.setLabelFor(empNameTextField);
		empNameTextField.setBounds(120, 194, 132, 20);
		contentPane.add(empNameTextField);
		empNameTextField.setColumns(10);
		
		deptComboBox = new JComboBox();
		deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"Bussiness Office", "Human Resources", "Manufacturing", "Shipping", "Maintentance"}));
		lblDepartment.setLabelFor(deptComboBox);
		deptComboBox.setBounds(119, 220, 150, 20);
		contentPane.add(deptComboBox);
		
		positionTextField = new JTextField();
		positionTextField.setText("Software Engineer");
		lblPosition.setLabelFor(positionTextField);
		positionTextField.setBounds(120, 244, 132, 20);
		contentPane.add(positionTextField);
		positionTextField.setColumns(10);
		
		JButton noArgContructorButton = new JButton("No Arg");
		noArgContructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_noArgContructorButton_actionPerformed(arg0);
			}
		});
		noArgContructorButton.setBounds(81, 275, 89, 23);
		contentPane.add(noArgContructorButton);
		
		JButton twoArgContructorButton = new JButton("2 Arg");
		twoArgContructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_twoArgContructorButton_actionPerformed(e);
			}
		});
		twoArgContructorButton.setBounds(180, 275, 89, 23);
		contentPane.add(twoArgContructorButton);
		
		JButton fourArgContructorButton = new JButton("4 Arg");
		fourArgContructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_fourArgContructorButton_actionPerformed(e);
			}
		});
		fourArgContructorButton.setBounds(279, 275, 89, 23);
		contentPane.add(fourArgContructorButton);
	}
	protected void do_noArgContructorButton_actionPerformed(ActionEvent arg0) {
		//Call appropriate constructor
		Employee emp = new Employee();
		//Add employee to employeeListModel
		employeeListModel.addElement(emp);
	}
	protected void do_twoArgContructorButton_actionPerformed(ActionEvent e) {
		String name = empNameTextField.getText();
		//Get empID from empIdTextField, convert int
		int id = Integer.parseInt(empIdTextField.getText());
		//Call appropriate constructor
		Employee emp = new Employee(name, id);
		//Add employee to employeeListModel
		employeeListModel.addElement(emp);
	}
	protected void do_fourArgContructorButton_actionPerformed(ActionEvent e) {
		String name = empNameTextField.getText();
		//Get empID from empIdTextField, convert to int
		int id = Integer.parseInt(empIdTextField.getText());
		//Get selected string from deptComboBox:
		String dept = (String) deptComboBox.getSelectedItem();
		//Get position from textField
		String position = positionTextField.getText();
		//Create employee object, and call 4 Arg Constructor by passing four arguments
		Employee emp = new Employee(name, id, dept, position);
				
		// Add employee to employeeListModel
		employeeListModel.addElement(emp);
	}
}
