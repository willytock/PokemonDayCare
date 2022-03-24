package classes;

public class Trainer {
	// Attributes
	private int id;
	private String name;
	private String firstName;
	private int age;
	private int nbBadge;

	// Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNbBadge() {
		return nbBadge;
	}

	public void setNbBadge(int nbBadge) {
		this.nbBadge = nbBadge;
	}

	// Constructors
	public Trainer(int id, String name, String firstName, int age, int nbBadge) {
		super();
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.age = age;
		this.nbBadge = nbBadge;
	}

}
