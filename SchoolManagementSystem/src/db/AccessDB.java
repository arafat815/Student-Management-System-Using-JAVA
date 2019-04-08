package com.sms.db;

import java.sql.*;
import java.util.Scanner;

import com.sms.login.LoginPanel;

public class AccessDB {
	// JDBC Driver name and DB URL
	String JDBC_DRIVER;
	String DB_URL;

	Connection conn;
	Statement stmt;

	// DataBase Credential
	String USER;
	String PASS;

	public AccessDB() {
		JDBC_DRIVER = "com.mysql.jdbc.Driver";
		DB_URL = "jdbc:mysql://localhost:3306/schoolmanagement";

		// Database Credentials
		USER = "root";
		PASS = "minhaz068117";

		try {
			// Registering JDBC Driver
			Class.forName(JDBC_DRIVER);
			// Opening a Connection
			System.out.println("Connecting to Database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected!\n");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Getting admin ID
	public int getAdminID() {
		int adminID = 0;

		try {
			// Executing query
			System.out.println("Getting Admin ID...");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT admin_id FROM admin");

			// Extracting data from ResultSet
			while (rs.next()) {
				// Retrieve by column name
				adminID = rs.getInt("admin_id");
			}
			// Cleaning up environment
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return adminID;
	}

	// Getting admin Password
	public String getAdminPassword() {
		String adminPassword = "";

		try {
			// Executing query
			System.out.println("Getting Admin Password...");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT admin_password FROM admin");

			// Extracting data from ResultSet
			while (rs.next()) {
				// Retrieve by column name
				adminPassword = rs.getString("admin_password");
			}
			// Cleaning up environment
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return adminPassword;
	}

	// Searching Student ID
	public boolean searchStudentID(int studentID) {
		int id = 0;

		try {
			// Executing query
			System.out.println("Searching Student ID...");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id FROM student");

			// Extracting data from ResultSet
			while (rs.next()) {
				// Retrieve by column name
				id = rs.getInt("id");
				if (studentID == id) {
					return true;
				}
			}
			// Cleaning up environment
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return false;
	}

	// Searching Student Password
	public boolean searchStudentPassword(String studentPass) {
		String password = "";

		try {
			// Executing query
			System.out.println("Searching Student Password...");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT student_pass FROM student");

			// Extracting data from ResultSet
			while (rs.next()) {
				// Retrieve by column name
				password = rs.getString("student_pass");
				if (studentPass.equals(password)) {
					return true;
				}
			}
			// Cleaning up environment
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return false;
	}

	// Getting Student Details from DB
	public String getStudentDetails() {
		int inputID = 0;
		String line = "-------------------------------------";

		try {
			// Executing query
			System.out.println("Showing Student Profile...");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM student");
			inputID = LoginPanel.getUserID();

			// Extracting data from ResultSet
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");

				if (id == inputID) {
					String name = rs.getString("name");
					String sClass = rs.getString("class");
					String shift = rs.getString("shift");
					String contact = rs.getString("contact");

					return (" " + line + "Student Details" + line + "\nName: " + " " + name + " " + "\nID: " + " " + id
							+ " " + "\nClass: " + " " + sClass + " " + "\nShift: " + " " + shift + " " + "\nContact:"
							+ " " + contact + " \n" + "            " + line + line);
				}
			}
			// Cleaning up environment
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return "No Records Found!";
	}

	// Getting Student Details from DB Overloaded
	public String getStudentDetails(int studentID) {
		String line = "-------------------------------------";

		try {
			// Executing query
			System.out.println("Searching Student Profile...");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM student");

			// Extracting data from ResultSet
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");

				if (id == studentID) {
					String name = rs.getString("name");
					String sClass = rs.getString("class");
					String shift = rs.getString("shift");
					String contact = rs.getString("contact");

					return (" " + line + "Student Details" + line + "\nName: " + " " + name + " " + "\nID: " + " " + id
							+ " " + "\nClass: " + " " + sClass + " " + "\nShift: " + " " + shift + " " + "\nContact:"
							+ " " + contact + " \n" + "            " + line + line);
				}
			}
			// Cleaning up environment
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return "No Records Found!";
	}

	// Inserting Data into Student DB
	public void insertToStudentDB(int id, String name, String sClass, String shift, String contact,
			String studentPassword) {
		// Inserting into student DB
		try {
			stmt = conn.createStatement();
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT into student(id, name, class, shift, contact, student_pass) values(" + id + ",'" + name
					+ "','" + sClass + "','" + shift + "', '" + contact + "', '" + studentPassword + "')");
			int num = stmt.executeUpdate(sql.toString());
			System.out.println(num + " rows updated");
			stmt.close();
			// conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Updating Student DB
	public void updateStudentDB() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		int id = 0;
		String name = "";
		String sClass = "";
		String shift = "";
		String contact = "";

		// User Input
		System.out.println("Enter ID : ");
		id = input.nextInt();
		System.out.println("Enter Name : ");
		name = input.next();
		System.out.println("Enter Class : ");
		sClass = input.next();
		System.out.println("Enter Shift : ");
		shift = input.next();
		System.out.println("Enter Contact : ");
		contact = input.next();

		try {
			stmt = conn.createStatement();
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE student SET name='" + name + "',class='" + sClass + "',shift='" + shift + "',contact='"
					+ contact + "'Where id='" + id + "'");
			int num = stmt.executeUpdate(sql.toString());
			System.out.println(num + " rows updated");
			stmt.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Showing Student Record from DB
	public void showRecord(String query) {
		try {
			// Executing query
			System.out.println("Creating Statement...");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			int num = 0;
			// Extracting data from ResultSet
			while (rs.next()) {
				System.out.println("\nStudent Details " + ++num + ": ");
				// Retrieve by column name
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String sClass = rs.getString("class");
				String shift = rs.getString("shift");
				String contact = rs.getString("contact");

				// Display values
				System.out.println("Name: " + name);
				System.out.println("ID: " + id);
				System.out.println("Class: " + sClass);
				System.out.println("Shift: " + shift);
				System.out.println("Contact: " + contact);
			}
			// Cleaning up environment
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Inserting Data into Term1st DB
	public void insertToMidResultDB(int id, String bengali, String english, String math, String generalScience,
			String socialScience) {
		// Inserting into student DB
		try {
			stmt = conn.createStatement();
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT into term1st(id, bengali, english, math, general_science, social_science) values(" + id
					+ ",'" + bengali + "','" + english + "','" + math + "', '" + generalScience + "', '" + socialScience
					+ "')");
			int num = stmt.executeUpdate(sql.toString());
			System.out.println(num + " row updated");
			stmt.close();
			// conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Inserting Data into Term2nd DB
	public void insertToFinalResultDB(int id, String bengali, String english, String math, String generalScience,
			String socialScience) {
		// Inserting into student DB
		try {
			stmt = conn.createStatement();
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT into term2nd(id, bengali, english, math, general_science, social_science) values(" + id
					+ ",'" + bengali + "','" + english + "','" + math + "', '" + generalScience + "', '" + socialScience
					+ "')");
			int num = stmt.executeUpdate(sql.toString());
			System.out.println(num + " row updated");
			stmt.close();
			// conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Getting Mid Result from DB
	public String getMidResult() {
		int inputID = 0;
		String line = "-----------------------------------";

		try {
			// Executing query
			System.out.println("Showing Mid Term Result...");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM term1st");
			inputID = LoginPanel.getUserID();
			;

			// Extracting data from ResultSet
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");

				if (id == inputID) {
					String bengali = rs.getString("bengali");
					String english = rs.getString("english");
					String math = rs.getString("math");
					String generalScience = rs.getString("general_science");
					String socialScience = rs.getString("social_science");

					return (" " + line + "Mid Term Result" + line + "\nBengali: " + " " + bengali + " " + "\nEnglish: "
							+ " " + english + " " + "\nMath: " + " " + math + " " + "\nGeneral Science: " + " "
							+ generalScience + " " + "\nSocial Science:" + " " + socialScience + " \n" + "            "
							+ line + line);
				}
			}
			// Cleaning up environment
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return "No Records Found!";
	}

	// Getting Mid Result from DB Overloaded
	public String getMidResult(int studentID) {
		String line = "-----------------------------------";

		try {
			// Executing query
			System.out.println("Showing Mid Term Result...");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM term1st");

			// Extracting data from ResultSet
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");

				if (id == studentID) {
					String bengali = rs.getString("bengali");
					String english = rs.getString("english");
					String math = rs.getString("math");
					String generalScience = rs.getString("general_science");
					String socialScience = rs.getString("social_science");

					return (" " + line + "Mid Term Result" + line + "\nBengali: " + " " + bengali + " " + "\nEnglish: "
							+ " " + english + " " + "\nMath: " + " " + math + " " + "\nGeneral Science: " + " "
							+ generalScience + " " + "\nSocial Science:" + " " + socialScience + " \n" + "            "
							+ line + line + "\n");
				}
			}
			// Cleaning up environment
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return "No Records Found!";
	}

	// Getting Final Result from DB
	public String getFinalResult() {
		int inputID = 0;
		String line = "-----------------------------------";

		try {
			// Executing query
			System.out.println("Showing Final Term Result...");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM term2nd");
			inputID = LoginPanel.getUserID();

			// Extracting data from ResultSet
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");

				if (id == inputID) {
					String bengali = rs.getString("bengali");
					String english = rs.getString("english");
					String math = rs.getString("math");
					String generalScience = rs.getString("general_science");
					String socialScience = rs.getString("social_science");

					return (" " + line + "Final Term Result" + line + "\nBengali: " + " " + bengali + " "
							+ "\nEnglish: " + " " + english + " " + "\nMath: " + " " + math + " "
							+ "\nGeneral Science: " + " " + generalScience + " " + "\nSocial Science:" + " "
							+ socialScience + " \n" + "            " + line + line);
				}
			}
			// Cleaning up environment
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return "No Records Found!";
	}

	// Getting Final Result from DB Overloaded
	public String getFinalResult(int studentID) {
		String line = "-----------------------------------";

		try {
			// Executing query
			System.out.println("Showing Final Term Result...");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM term2nd");

			// Extracting data from ResultSet
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");

				if (id == studentID) {
					String bengali = rs.getString("bengali");
					String english = rs.getString("english");
					String math = rs.getString("math");
					String generalScience = rs.getString("general_science");
					String socialScience = rs.getString("social_science");

					return (" " + line + "Final Term Result" + line + "\nBengali: " + " " + bengali + " "
							+ "\nEnglish: " + " " + english + " " + "\nMath: " + " " + math + " "
							+ "\nGeneral Science: " + " " + generalScience + " " + "\nSocial Science:" + " "
							+ socialScience + " \n" + "            " + line + line + "\n");
				}
			}
			// Cleaning up environment
			rs.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "No Records Found!";
	}
}
