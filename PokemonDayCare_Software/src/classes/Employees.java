package classes;

public class Employees {
	// Attributes
	private String name;
	private String firstName;
	private String role;

	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	// Constructors
	public Employees(String name, String firstName, String role) {
		super();
		this.name = name;
		this.firstName = firstName;
		this.role = role;
	}

}
