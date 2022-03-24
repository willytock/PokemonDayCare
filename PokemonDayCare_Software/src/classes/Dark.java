package classes;

public class Dark extends Rooms {
	// Attributes
	private int brightness;

	// Getters and setters
	public int getBrightness() {
		return brightness;
	}

	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}

	// Inheritance
	public Dark(int roomNumber, double price) {
		super(roomNumber, price);
		// TODO Auto-generated constructor stub
	}

	// Constructors
	public Dark(int roomNumber, double price, int brightness) {
		super(roomNumber, price);
		this.brightness = brightness;
	}
}
