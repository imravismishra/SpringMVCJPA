package com.cogent.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "form")
public class FormEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Embedded
	private NameEntity nameEntity;
	@Column(unique = true,nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String mobile;
	@Column(nullable = false)
	private String dob;
	@Column(nullable = false)
	private String gender;
	@OneToOne(cascade = CascadeType.ALL)
	private LanguageEntity languageEntity;
	@Column(nullable = false)
	private String education;
	@Column(nullable = false)
	private String imageUrl;

	/*
	
	public FormEntity() {
		super();
	}

	public FormEntity(NameEntity nameDao, String email, String password, String mobile, String dob, String gender,
			LanguageEntity languageEntity, String education, String imageUrl) {
		super();
		this.nameEntity = nameEntity;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.dob = dob;
		this.gender = gender;
		this.languageEntity = languageEntity;
		this.education = education;
		this.imageUrl = imageUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public NameEntity getNameEntity() {
		return nameEntity;
	}

	public void setNameEntity(NameEntity nameDao) {
		this.nameEntity = nameDao;
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

	public LanguageEntity getLanguageEntity() {
		return languageEntity;
	}

	public void setLanguageEntity(LanguageEntity languageDao) {
		this.languageEntity = languageDao;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "FormDao [nameEntity=" + nameEntity + ", email=" + email + ", password=" + password + ", mobile="
				+ mobile + ", dob=" + dob + ", gender=" + gender + ", languageEntity=" + languageEntity + ", education="
				+ education + ", imageUrl=" + imageUrl + "]";
	}
	
	*/

}
