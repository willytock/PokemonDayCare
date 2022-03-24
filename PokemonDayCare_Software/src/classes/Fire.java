package classes;

public class Fire extends TemperatureRooms {
	// Attributes
	private boolean lava;

	// Getters and setters
	public boolean isLava() {
		return lava;
	}

	public void setLava(boolean lava) {
		this.lava = lava;
	}

	// Inheritance
	public Fire(int roomNumber, double price) {
		super(roomNumber, price);
		// TODO Auto-generated constructor stub
	}
	// Constructors

	public Fire(int roomNumber, double price, boolean lava) {
		super(roomNumber, price);
		this.lava = lava;
	}
}
