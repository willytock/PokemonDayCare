package classes;

public class Disease {
	// Attributes
	private String name;
	private int duration;

	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	// Constructors
	public Disease(String name, int duration) {
		super();
		this.name = name;
		this.duration = duration;
	}

}
