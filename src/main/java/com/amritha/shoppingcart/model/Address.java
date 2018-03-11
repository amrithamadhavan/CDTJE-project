package com.amritha.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Entity
@Table(name="Address")
@Component
public class Address implements Serializable{
	private static final long serialVersionUID = 4657462015039726030L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotEmpty(message="door number should not be empty")
	private String doorno;
	@NotEmpty(message="street name should not be empty")
	private String stname;
	@NotEmpty(message="area should not be empty")
	private String areaname;
	@NotEmpty(message="city should not be empty")
	private String city;
	@Size(max=6,min=6,message="pincode not valid")
	private String pincode;
	
	
	
	public int getId() {
		return id;
	}
	
	public String getDoorno() {
		return doorno;
	}
	public void setDoorno(String doorno) {
		this.doorno = doorno;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	

}
