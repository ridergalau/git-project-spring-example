package tujuh.suganda.model;

public class DataModel {
	private String id;
	private String name;
	private String email;
	private String city;
	private String country;
	private String ip;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public DataModel(String id, String name, String email, String city, String country, String ip) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.city = city;
		this.country = country;
		this.ip = ip;
	}
	@Override
	public String toString() {
		return "DataModel [id=" + id + ", name=" + name + ", email=" + email + ", city=" + city + ", country=" + country
				+ ", ip=" + ip + "]";
	}
	
	
}
