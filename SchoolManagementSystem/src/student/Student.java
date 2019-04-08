package com.sms.student;

public class Student {
	private String name;
	private int id;
	private String sClass;
	private String shift;
	private String contact;

	public Student() {
		this.name = "";
		this.id = 0;
		this.sClass = "";
		this.shift = "";
		this.contact = "";
	}

	public Student(String name, int id, String sClass, String shift, String contact) {
		this.name = name;
		this.id = id;
		this.sClass = sClass;
		this.shift = shift;
		this.contact = contact;
	}

	// Setting and Getting Student Info
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getsClass() {
		return sClass;
	}

	public void setsClass(String sClass) {
		this.sClass = sClass;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void getStudentInfo() {
		System.out.println("Name: " + this.name);
		System.out.println("ID: " + this.id);
		System.out.println("Class: " + this.sClass);
		System.out.println("Shift: " + this.shift);
		System.out.println("Contact: " + this.contact);
	}

	// Setting and Getting Student Result
	public void setResult(Result result,int bengaliMarks, int englishMarks, int mathMarks, int generalScienceMarks,
			int socialScienceMarks) {
		result.setBengaliMarks(bengaliMarks);
		result.setEnglishMarks(englishMarks);
		result.setMathMarks(mathMarks);
		result.setGeneralScienceMarks(generalScienceMarks);
		result.setSocialScienceMarks(socialScienceMarks);
	}
	
	public void getResult(Result result) {
		result.showResult();
	}
	
	// Setting and Getting Student Payment
	public void setPaymentInfo(Payment payment, int admissionFee, int tutionFee, int transportationFee) {
		payment.setAdmissionFee(admissionFee);
		payment.setTutionFee(tutionFee);
		payment.setTransportationFee(transportationFee);
	}
	
	public void getPaymentInfo(Payment payment) {
		payment.showPayment();
	}
	
	// Show Student Details
	public void showDetails(Result term1st, Result term2nd, Payment payment) {
		// Basic Info
		System.out.println("Student Info: ");
		this.getStudentInfo();
		
		// Result
		System.out.println("\n1st Term Result: ");
		this.getResult(term1st);
		System.out.println("\n2nd Term Result: ");
		this.getResult(term2nd);
		
		// Payment
		//this.getPaymentInfo(payment);
	}
}
