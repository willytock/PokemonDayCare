package classes;

public class Invoices {
	// Attributes
	private double totalPrice;
	private String detail;

	// Getters and setters
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	// Constructors
	public Invoices(double totalPrice, String detail) {
		super();
		this.totalPrice = totalPrice;
		this.detail = detail;
	}

}
