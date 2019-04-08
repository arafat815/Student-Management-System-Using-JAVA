package com.sms.student;

public class Payment {
	private int admissionFee;
	private int tutionFee;
	private int transportationFee;

	public Payment() {
		this.admissionFee = 0;
		this.tutionFee = 0;
		this.transportationFee = 0;
	}

	public Payment(int admissionFee, int tutionFee, int transportationFee) {
		this.admissionFee = admissionFee;
		this.tutionFee = tutionFee;
		this.transportationFee = transportationFee;
	}

	public int getAdmissionFee() {
		return admissionFee;
	}

	public void setAdmissionFee(int admissionFee) {
		this.admissionFee = admissionFee;
	}

	public int getTutionFee() {
		return tutionFee;
	}

	public void setTutionFee(int tutionFee) {
		this.tutionFee = tutionFee;
	}

	public int getTransportationFee() {
		return transportationFee;
	}

	public void setTransportationFee(int transportationFee) {
		this.transportationFee = transportationFee;
	}

	public void showPayment() {
		System.out.println("Admission Fee: " + this.admissionFee + "Tk.");
		System.out.println("tution Fee: " + this.tutionFee + "Tk.");
		System.out.println("Transportation Fee: " + this.transportationFee + "Tk.");
	}
}
