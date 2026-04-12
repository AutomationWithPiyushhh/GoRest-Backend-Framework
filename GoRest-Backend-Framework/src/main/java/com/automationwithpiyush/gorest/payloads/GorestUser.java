package com.automationwithpiyush.gorest.payloads;

import lombok.Data;

@Data
public class GorestUser {
    private Integer id;
    private String name;
    private String email;
    private String gender;
    private String status;
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getGender() {
		return gender;
	}
	public String getStatus() {
		return status;
	}
    
    
}