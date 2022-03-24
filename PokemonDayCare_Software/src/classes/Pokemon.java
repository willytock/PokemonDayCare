package classes;

public class Pokemon {
	// Attributes
	private String name;
	private double size;
	private double weight;
	private String gender;
	private String status;

	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// Constructors
	public Pokemon(String name, double size, double weight, String gender, String status) {
		super();
		this.name = name;
		this.size = size;
		this.weight = weight;
		this.gender = gender;
		this.status = status;
	}

}
