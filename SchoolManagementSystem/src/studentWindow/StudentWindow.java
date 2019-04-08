package com.sms.studentWindow;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import com.sms.db.AccessDB;
import com.sms.login.LoginPanel;

public class StudentWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	// DB Access
	AccessDB db = new AccessDB();

	// Swing Components
	// Tab and Panels
	JTabbedPane tabbedPane = new JTabbedPane();
	JLabel titleLabel = new JLabel("Student Portal");
	JPanel homePanel = new JPanel();
	JPanel profilePanel = new JPanel();
	JPanel resultPanel = new JPanel();
	JPanel financialPanel = new JPanel();

	// Home Tab

	// Profile Tab
	JLabel profileLabel = new JLabel("Student Profile");
	JTextArea profileTextArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(profileTextArea);

	// Result Tab
	JLabel resultLabel = new JLabel("Exam Result");
	JLabel midLabel = new JLabel("Mid Term Exam Result");
	JTextArea midTextArea = new JTextArea();
	JScrollPane midScrollPane = new JScrollPane(midTextArea);
	JLabel finalLabel = new JLabel("Final Term Exam Result");
	JTextArea finalTextArea = new JTextArea();
	JScrollPane finalScrollPane = new JScrollPane(finalTextArea);

	// Financial Tab
	JLabel financialLabel = new JLabel("Financial Status");
	JTextArea financialTextArea = new JTextArea();

	// Constructor
	public StudentWindow(String windowTitle) {
		// Organizing, Positioning and Scaling Frame
		super(windowTitle);
		setSize(LoginPanel.WIDTH, LoginPanel.HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(titleLabel, "North");

		// Adding Home Tab
		tabbedPane.addTab("Home", homePanel);

		// Adding Profile Tab
		tabbedPane.addTab("Profile", profilePanel);
		// profilePanel.setLayout(new GridLayout(15, 10));
		profilePanel.add(profileLabel);
		profileLabel.setHorizontalAlignment(JLabel.CENTER);
		profilePanel.add(new JLabel(""));
		profilePanel.add(scrollPane);
		// profilePanel.add(profileTextArea);
		profileTextArea.setText(db.getStudentDetails());
		profileTextArea.setEditable(false);

		// Adding Result Tab
		tabbedPane.addTab("Result", resultPanel);
		// resultPanel.setLayout(new GridLayout(15, 10));
		resultPanel.add(new JLabel(""));
		resultPanel.add(midLabel);
		midLabel.setHorizontalAlignment(JLabel.CENTER);
		resultPanel.add(midScrollPane);
		midTextArea.setText(db.getMidResult());
		midTextArea.setEditable(false);
		resultPanel.add(new JLabel(""));
		resultPanel.add(finalLabel);
		finalLabel.setHorizontalAlignment(JLabel.CENTER);
		resultPanel.add(finalScrollPane);
		finalTextArea.setText(db.getFinalResult());
		finalTextArea.setEditable(false);

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
}
