package com.sms.adminWindow;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.sms.db.AccessDB;
import com.sms.login.LoginPanel;

public class AdminWindow extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	// DB Access
	AccessDB db = new AccessDB();

	// Swing Components
	// Tab and Panels
	JTabbedPane tabbedPane = new JTabbedPane();
	JLabel titleLabel = new JLabel("Admin Portal");
	JPanel homePanel = new JPanel();
	JPanel registrationPanel = new JPanel();
	JPanel studentsPanel = new JPanel();
	JPanel submitResultPanel = new JPanel();
	JPanel viewResultPanel = new JPanel();
	JPanel financialPanel = new JPanel();

	// Home Tab

	// Registration Tab
	JLabel registrationLabel = new JLabel("Enter Student Details: ");
	JLabel nameLabel = new JLabel("Name: ");
	JTextField nameTextField = new JTextField(10);
	JLabel regIdLabel = new JLabel("ID: ");
	JTextField idTextField = new JTextField(10);
	JLabel classLabel = new JLabel("Class: ");
	JTextField classTextField = new JTextField(10);
	JLabel shiftLabel = new JLabel("Shift: ");
	JTextField shiftTextField = new JTextField(10);
	JLabel contactLabel = new JLabel("Contact: ");
	JTextField contactTextField = new JTextField(10);
	JLabel passLabel = new JLabel("Password: ");
	JTextField passTextField = new JTextField(10);
	JButton registerButton = new JButton("Register");

	// Student Tab
	JLabel idLabel = new JLabel("Enter Student ID: ");
	JTextField searchTextField = new JTextField(10);
	JButton searchButton = new JButton("Search");
	JLabel infoLabel = new JLabel("Student Details: ");
	JTextArea infoTextArea = new JTextArea();
	JScrollPane infoScrollPane = new JScrollPane(infoTextArea);

	// SubmitResult Tab
	JLabel submitResultLabel = new JLabel("Enter Student Result");
	JLabel studentIdLabel = new JLabel("ID: ");
	JTextField studentIdTextField = new JTextField(10);
	JLabel termLabel = new JLabel("Term: ");
	JTextField termTextField = new JTextField(10);
	JLabel bengaliLabel = new JLabel("Bengali: ");
	JTextField bengaliTextField = new JTextField(10);
	JLabel englishLabel = new JLabel("English: ");
	JTextField englishTextField = new JTextField(10);
	JLabel mathLabel = new JLabel("Math: ");
	JTextField mathTextField = new JTextField(10);
	JLabel generalSciLabel = new JLabel("General Science: ");
	JTextField generalSciTextField = new JTextField(10);
	JLabel socialSciLabel = new JLabel("Social Science: ");
	JTextField socialSciTextField = new JTextField(10);
	JButton submitButton = new JButton("Submit");

	// ViewResult Tab
	JLabel viewResultIdLabel = new JLabel("Enter Student ID: ");
	JTextField viewResultTextField = new JTextField(10);
	JButton viewResultButton = new JButton("View Result");
	JLabel viewResultLabel = new JLabel("Exam Result: ");
	JTextArea viewResultTextArea = new JTextArea();
	JScrollPane viewResultScrollPane = new JScrollPane(viewResultTextArea);

	// Financial Tab
	JLabel financialLabel = new JLabel("Financial Status");
	JTextArea financialTextArea = new JTextArea();

	// Constructor
	public AdminWindow(String windowTitle) {
		// Organizing, Positioning and Scaling Frame
		super(windowTitle);
		setSize(LoginPanel.WIDTH, LoginPanel.HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(titleLabel, "North");

		// Registering Buttons to ActionListener
		registerButton.addActionListener(this);
		searchButton.addActionListener(this);
		submitButton.addActionListener(this);
		viewResultButton.addActionListener(this);

		// Adding Home Tab
		tabbedPane.addTab("Home", homePanel);

		// Adding Registration Tab
		tabbedPane.addTab("Registration", registrationPanel);
		registrationPanel.setLayout(new GridLayout(15, 10));
		registrationPanel.add(registrationLabel);
		registrationLabel.setHorizontalAlignment(JLabel.CENTER);
		registrationLabel.add(new JLabel(""));
		registrationPanel.add(nameLabel);
		registrationPanel.add(nameTextField);
		registrationPanel.add(regIdLabel);
		registrationPanel.add(idTextField);
		registrationPanel.add(classLabel);
		registrationPanel.add(classTextField);
		registrationPanel.add(shiftLabel);
		registrationPanel.add(shiftTextField);
		registrationPanel.add(contactLabel);
		registrationPanel.add(contactTextField);
		registrationPanel.add(passLabel);
		registrationPanel.add(passTextField);
		registrationPanel.add(registerButton);

		// Adding Student Tab
		tabbedPane.addTab("Student", studentsPanel);
		// studentsPanel.setLayout(new GridLayout(15, 10));
		studentsPanel.add(idLabel);
		idLabel.setHorizontalAlignment(JLabel.CENTER);
		studentsPanel.add(new JLabel(""));
		studentsPanel.add(searchTextField);
		studentsPanel.add(searchButton);
		studentsPanel.add(new JLabel(""));
		infoLabel.setHorizontalAlignment(JLabel.CENTER);
		studentsPanel.add(infoTextArea);
		infoTextArea.setEditable(false);

		// Adding SubmitResult Tab
		tabbedPane.addTab("SubmitResult", submitResultPanel);
		submitResultPanel.setLayout(new GridLayout(15, 10));
		submitResultPanel.add(submitResultLabel);
		submitResultLabel.setHorizontalAlignment(JLabel.CENTER);
		submitResultPanel.add(new JLabel(""));
		submitResultPanel.add(studentIdLabel);
		submitResultPanel.add(studentIdTextField);
		submitResultPanel.add(termLabel);
		submitResultPanel.add(termTextField);
		submitResultPanel.add(bengaliLabel);
		submitResultPanel.add(bengaliTextField);
		submitResultPanel.add(englishLabel);
		submitResultPanel.add(englishTextField);
		submitResultPanel.add(mathLabel);
		submitResultPanel.add(mathTextField);
		submitResultPanel.add(generalSciLabel);
		submitResultPanel.add(generalSciTextField);
		submitResultPanel.add(socialSciLabel);
		submitResultPanel.add(socialSciTextField);
		submitResultPanel.add(submitButton);

		// Adding ViewResult Tab
		tabbedPane.addTab("ViewResult", viewResultPanel);
		viewResultPanel.add(viewResultIdLabel);
		viewResultPanel.add(viewResultTextField);
		viewResultPanel.add(viewResultButton);
		viewResultLabel.setHorizontalAlignment(JLabel.CENTER);
		viewResultPanel.add(new JLabel(""));
		viewResultPanel.add(viewResultTextArea);
		viewResultTextArea.setEditable(false);

		// Adding Financial Tab
		tabbedPane.addTab("Financial", financialPanel);
		financialPanel.setLayout(new GridLayout(15, 10));
		financialPanel.add(financialLabel);
		financialLabel.setHorizontalAlignment(JLabel.CENTER);
		financialPanel.add(new JLabel(""));
		financialPanel.add(financialTextArea);
		financialTextArea.setEditable(false);

		// Adding Tab to the Frame
		getContentPane().add(tabbedPane, "Center");
	}

	// Button Action
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() == registerButton) {
			System.out.println("Register Button Pressed");

			// Getting User Input
			int id = Integer.parseInt(idTextField.getText());
			String name = nameTextField.getText();
			String sClass = classTextField.getText();
			String shift = shiftTextField.getText();
			String contact = contactTextField.getText();
			String studentPassword = passTextField.getText();

			// Registering Student into DB
			db.insertToStudentDB(id, name, sClass, shift, contact, studentPassword);

		} else if (actionEvent.getSource() == searchButton) {
			System.out.println("Search Button Pressed");

			// Getting Student ID and Details from DB
			int studentID = Integer.parseInt(searchTextField.getText());
			infoTextArea.setText(db.getStudentDetails(studentID));
		} else if (actionEvent.getSource() == submitButton) {
			System.out.println("Submit Button Pressed");

			// Getting User Input
			int id = Integer.parseInt(studentIdTextField.getText());
			String term = termTextField.getText();
			String bengali = bengaliTextField.getText();
			String english = englishTextField.getText();
			String math = mathTextField.getText();
			String generalScience = generalSciTextField.getText();
			String socialScience = socialSciTextField.getText();

			// Inserting Term wise Result to DB
			if (term.equals("mid") || term.equals("Mid")) {
				db.insertToMidResultDB(id, bengali, english, math, generalScience, socialScience);
			} else if (term.equals("final") || term.equals("Final")) {
				db.insertToFinalResultDB(id, bengali, english, math, generalScience, socialScience);
			} else {
				JOptionPane.showMessageDialog(this, "Invalid Exam Term", "Invalid Term Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (actionEvent.getSource() == viewResultButton) {
			System.out.println("View Result Button Pressed");

			// Getting Student Result from DB
			int studentID = Integer.parseInt(viewResultTextField.getText());
			System.out.println(studentID);
			viewResultTextArea.setText(db.getMidResult(studentID) + db.getFinalResult(studentID));
		}
	}
}
