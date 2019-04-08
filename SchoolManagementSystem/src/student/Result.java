package com.sms.student;

public class Result extends Student {
	private int bengaliMarks;
	private int englishMarks;
	private int mathMarks;
	private int generalScienceMarks;
	private int socialScienceMarks;

	public Result() {
		this.bengaliMarks = 0;
		this.englishMarks = 0;
		this.mathMarks = 0;
		this.generalScienceMarks = 0;
		this.socialScienceMarks = 0;
	}

	public Result(int bengaliMarks, int englishMarks, int mathMarks, int generalScienceMarks, int socialScienceMarks) {
		this.bengaliMarks = bengaliMarks;
		this.englishMarks = englishMarks;
		this.mathMarks = mathMarks;
		this.generalScienceMarks = generalScienceMarks;
		this.socialScienceMarks = socialScienceMarks;
	}

	public int getBengaliMarks() {
		return bengaliMarks;
	}

	public void setBengaliMarks(int bengaliMarks) {
		this.bengaliMarks = bengaliMarks;
	}

	public int getEnglishMarks() {
		return englishMarks;
	}

	public void setEnglishMarks(int englishMarks) {
		this.englishMarks = englishMarks;
	}

	public int getMathMarks() {
		return mathMarks;
	}

	public void setMathMarks(int mathMarks) {
		this.mathMarks = mathMarks;
	}

	public int getGeneralScienceMarks() {
		return generalScienceMarks;
	}

	public void setGeneralScienceMarks(int generalScienceMarks) {
		this.generalScienceMarks = generalScienceMarks;
	}

	public int getSocialScienceMarks() {
		return socialScienceMarks;
	}

	public void setSocialScienceMarks(int socialScienceMarks) {
		this.socialScienceMarks = socialScienceMarks;
	}

	public void showResult() {
		System.out.println("Bengali: " + this.bengaliMarks);
		System.out.println("English: " + this.englishMarks);
		System.out.println("Math: " + this.mathMarks);
		System.out.println("General Science: " + this.generalScienceMarks);
		System.out.println("Social Science: " + this.socialScienceMarks);
	}
}
