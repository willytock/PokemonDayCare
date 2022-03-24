package classes;

public class Institution {
	// Attributes
	private String region;
	private String name;
	private String city;
	private int freeRooms;

	// Getters and setters
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getFreeRooms() {
		return freeRooms;
	}

	public void setFreeRooms(int freeRooms) {
		this.freeRooms = freeRooms;
	}

	// Constructors
	public Institution(String region, String name, String city, int freeRooms) {
		super();
		this.region = region;
		this.name = name;
		this.city = city;
		this.freeRooms = freeRooms;
	}

}
