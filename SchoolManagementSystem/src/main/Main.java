package com.sms.main;

import javax.swing.JOptionPane;

import com.sms.login.LoginPanel;

public class Main {

	public static LoginPanel login;

	public static void main(String args[]) {
		// Login Panel
		try {
			login = new LoginPanel();
			login.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}
}
