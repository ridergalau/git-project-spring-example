package tujuh.suganda.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "person", type = "detail")
public class Person {
	@Id
    private String id;
    private String name;
    private String address;
    private String gender;
    
    public Person() {
    }
    
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Person(String id, String name, String address, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + ", gender=" + gender + "]";
	}
    
}
