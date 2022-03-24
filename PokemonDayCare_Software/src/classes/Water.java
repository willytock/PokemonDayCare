package classes;

public class Water extends TemperatureRooms {
	// Attributes
	private int humidity;
	private int waterQty;

	// Getters and setters
	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public int getWaterQty() {
		return waterQty;
	}

	public void setWaterQty(int waterQty) {
		this.waterQty = waterQty;
	}

	// Inheritance
	public Water(int roomNumber, double price) {
		super(roomNumber, price);
		// TODO Auto-generated constructor stub
	}

	// Constructors
	public Water(int roomNumber, double price, int humidity, int waterQty) {
		super(roomNumber, price);
		this.humidity = humidity;
		this.waterQty = waterQty;
	}
}
