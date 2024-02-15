package com.cogent.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Embeddable
public class NameEntity {

	@Column(nullable = false)
	private String fName;
	private String mName;
	@Column(nullable = false)
	private String lName;

	/*
	public NameEntity() {
		super();
	}

	public NameEntity(String fName, String mName, String lName) {
		super();
		this.fName = fName;
		this.mName = mName;
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	@Override
	public String toString() {
		return "NameEntity [fName=" + fName + ", mName=" + mName + ", lName=" + lName + "]";
	}
*/
}
