package classes;

public class Rooms {
	// Attributes
	protected int roomNumber;
	protected double price;
	private double size;
	private int floor;
	private double height;

	// Getters and setters
	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	// Constructors
	public Rooms(int roomNumber, double price) {
		super();
		this.roomNumber = roomNumber;
		this.price = price;
	}

}
