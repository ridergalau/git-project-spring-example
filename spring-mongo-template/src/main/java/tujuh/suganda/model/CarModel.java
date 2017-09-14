package tujuh.suganda.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "carcustomer")
public class CarModel {
	@Id
	private String id;
	private String name;
	private String manufacture;
	private String date;
	private String owner;
	private List<String> group;
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
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public List<String> getGroup() {
		return group;
	}
	public void setGroup(List<String> group) {
		this.group = group;
	}
	public CarModel(String id, String name, String manufacture, String date, String owner, List<String> group) {
		super();
		this.id = id;
		this.name = name;
		this.manufacture = manufacture;
		this.date = date;
		this.owner = owner;
		this.group = group;
	}
	@Override
	public String toString() {
		return "CarModel [id=" + id + ", name=" + name + ", manufacture=" + manufacture + ", date=" + date + ", owner="
				+ owner + ", group=" + group + "]";
	}
	
	
	
}
