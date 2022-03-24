package classes;

public class NormalRooms extends Rooms {
	// Attributes
	private int nbBeds;

	// Getters and setters
	public int getNbBeds() {
		return nbBeds;
	}

	public void setNbBeds(int nbBeds) {
		this.nbBeds = nbBeds;
	}

	// Inheritance
	public NormalRooms(int roomNumber, double price) {
		super(roomNumber, price);
		// TODO Auto-generated constructor stub
	}

	// Constructors
	public NormalRooms(int roomNumber, double price, int nbBeds) {
		super(roomNumber, price);
		this.nbBeds = nbBeds;
	}
}
