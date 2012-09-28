package org.hedspi.posgresql.hedspi_student_manager.model.contact.address;

public class Address {

	public Address(String home, City city, District district) {
		super();
		this.home = home;
		this.city = city;
		this.district = district;
	}
	private String home;
	private City city;
	private District district;
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	
	public String toString(){
		return home + "," + getCity().toString() + ", " + getDistrict().toString();
	}
}
