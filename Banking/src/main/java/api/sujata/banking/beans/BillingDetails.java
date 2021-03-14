package api.sujata.banking.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BillingDetails {
	@Id
	@GeneratedValue
	private int id;
	private String street1;
	private String street2;
	private String city;
	private String country;
	private String zip;
	@OneToOne(mappedBy = "billingDetails")
	@JsonIgnore
	private Transaction transaction;
	public BillingDetails(int id, String street1, String street2, String city, String country, String zip) {
		super();
		this.id = id;
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.country = country;
		this.zip = zip;
	}
	public BillingDetails() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "BillingDetails [id=" + id + ", street1=" + street1 + ", street2=" + street2 + ", city=" + city
				+ ", country=" + country + ", zip=" + zip + "]";
	}
	

}
