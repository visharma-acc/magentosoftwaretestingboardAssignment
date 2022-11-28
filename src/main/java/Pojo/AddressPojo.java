package Pojo;

public class AddressPojo {

	private String city;
	private String state;
	private String country;
	private String postcode;
	private String location;
	private String phone;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "AddressPojo [city=" + city + ", state=" + state + ", country=" + country + ", postcode=" + postcode
				+ ", location=" + location + ", phone=" + phone + "]";
	}
	
	
	
	
}
