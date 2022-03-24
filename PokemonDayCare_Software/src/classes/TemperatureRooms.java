package classes;

public class TemperatureRooms extends Rooms {
	// Attributes
	private double temperature;

	// Getters and setters
	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	// Inheritance
	public TemperatureRooms(int roomNumber, double price) {
		super(roomNumber, price);
		// TODO Auto-generated constructor stub
	}

	// Constructors
	public TemperatureRooms(int roomNumber, double price, double temperature) {
		super(roomNumber, price);
		this.temperature = temperature;
	}

}
