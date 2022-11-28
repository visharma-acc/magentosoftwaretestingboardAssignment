package Pojo;

public class UserPoja {
	
	private String firstname;
	private String lastname;
	private String password;
	private String email;
	
	private AddressPojo address;
	
	public AddressPojo getAddress() {
		return address;
	}
	public void setAddress(AddressPojo address) {
		this.address = address;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserPoja [firstname=" + firstname + ", lastname=" + lastname + ", password=" + password + ", email="
				+ email + ", address=" + address + "]";
	}
	
	
	
	
	
	
	
	

}
