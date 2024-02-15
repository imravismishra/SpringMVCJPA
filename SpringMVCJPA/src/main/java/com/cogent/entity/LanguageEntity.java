package com.cogent.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "language")
public class LanguageEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "english", columnDefinition = "varchar(100) default 'not'")
	private String english;
	@Column(name = "hindi", columnDefinition = "varchar(100) default 'not'")
	private String hindi;
	@Column(name = "none", columnDefinition = "varchar(100) default 'not'")
	private String none;

	/*
	
	public LanguageEntity() {
		super();
	}

	public LanguageEntity(String english, String hindi, String none) {
		super();
		this.english = english;
		this.hindi = hindi;
		this.none = none;
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

	@Override
	public String toString() {
		return "LanguageEntity [english=" + english + ", hindi=" + hindi + ", none=" + none + "]";
	}

*/
}
