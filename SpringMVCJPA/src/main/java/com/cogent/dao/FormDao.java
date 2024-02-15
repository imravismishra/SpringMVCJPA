package com.cogent.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FormDao {

	private String fname;
	private String mname;
	private String lname;
	private String email;
	private String password;
	private String mobile;
	private String dob;
	private String gender;
	private String english;
	private String hindi;
	private String none;
	private String education;
	private String Imagefile;

	
	/*
	public FormDao() {
		super();
	}

	public FormDao(String fname, String mname, String lname, String email, String password, String mobile, String dob,
			String gender, String english, String hindi, String none, String education) {
		super();
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.dob = dob;
		this.gender = gender;
		this.english = english;
		this.hindi = hindi;
		this.none = none;
		this.education = education;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getHindi() {
		return hindi;
	}

	public void setHindi(String hindi) {
		this.hindi = hindi;
	}

	public String getNone() {
		return none;
	}

	public void setNone(String none) {
		this.none = none;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Override
	public String toString() {
		return "FormDao [fname=" + fname + ", mname=" + mname + ", lname=" + lname + ", email=" + email + ", password="
				+ password + ", mobile=" + mobile + ", dob=" + dob + ", gender=" + gender + ", english=" + english
				+ ", hindi=" + hindi + ", none=" + none + ", education=" + education + "]";
	}

*/
	
}
