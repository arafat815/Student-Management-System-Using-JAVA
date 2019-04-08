package com.sms.login;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.sms.adminWindow.AdminWindow;
import com.sms.db.AccessDB;
import com.sms.studentWindow.StudentWindow;

public class LoginPanel extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	// DB Access
	AccessDB db = new AccessDB();

	// User Credentials
	private static int userID = 0;
	@SuppressWarnings("unused")
	private static String userPassword = "";

	// Check if Logged in
	public static boolean isLoggedIn = false;

	// Frame Size
	public static int WIDTH = 480;
	public static int HEIGHT = 400;

	// Swing Components
	JTabbedPane tabbedPane = new JTabbedPane();
	JPanel loginPanel = new JPanel();
	JLabel loginLabel = new JLabel("Enter User Details: ");
	JTextField userTextField = new JTextField(10);
	JTextField passTextField = new JTextField(10);
	JButton loginButton = new JButton("Login");

	public LoginPanel() {
		// Organizing, Positioning and Scaling Frame
		setTitle("Login Window");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());

		// Setting Tab and Panel, Adding and Organizing Components
		tabbedPane.addTab("Login", loginPanel);
		loginPanel.setLayout(new GridLayout(15, 10));
		loginPanel.add(loginLabel);
		loginLabel.setHorizontalAlignment(JLabel.CENTER);
		loginPanel.add(new JLabel("User ID: "));
		loginPanel.add(userTextField);
		loginPanel.add(new JLabel("User Password: "));
		loginPanel.add(passTextField);
		loginPanel.add(loginButton);

		// Registering Button to ActionListener
		loginButton.addActionListener(this);

		// Adding Tab to the Frame
		getContentPane().add(tabbedPane, "Center");
	}

	public static int getUserID() {
		return userID;
	}

	// Button Action
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		// If Login Button Pressed....
		if (actionEvent.getSource() == loginButton) {
			// AdminWindow
			AdminWindow adminWindow;

			// StudentWindow
			StudentWindow studentWindow;

			// Getting User Input
			String inputID = userTextField.getText();
			String inputPass = passTextField.getText();

			// Checking ID length for differentiating users
			if (inputID.length() == 5) {
				// Parsing ID into Integer from String
				int studentID = Integer.parseInt(inputID);

				// Checking if User Credential Matched
				if ((db.searchStudentID(studentID)) && (db.searchStudentPassword(inputPass))) {
					// Redirecting to StudentWindow
					System.out.println("Access Granted!\nRedirecting to Student Window...");
					isLoggedIn = true;
					userID = studentID;
					userPassword = inputPass;

					studentWindow = new StudentWindow("Student Window");
					studentWindow.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "Incorrect User Name or Password", "Login Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} else if (inputID.length() == 4) {
				// Parsing ID into Integer from String
				int adminID = Integer.parseInt(inputID);

				// Checking if User Credential Matched
				if ((adminID == db.getAdminID()) && (inputPass.equals(db.getAdminPassword()))) {
					System.out.println("Access Granted!\nRedirecting to Admin Window...");
					isLoggedIn = true;
					userID = adminID;
					userPassword = inputPass;

					// Redirecting to AdminWindow
					adminWindow = new AdminWindow("Admin Window");
					adminWindow.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "Incorrect User Name or Password", "Login Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "Incorrect User Name or Password", "Login Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
