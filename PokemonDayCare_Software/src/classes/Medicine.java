package classes;

import java.time.LocalDate;

public class Medicine {
	// Attributes
	private String name;
	private double price;
	private int quantities;
	private LocalDate expirationDate;

	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantities() {
		return quantities;
	}

	public void setQuantities(int quantities) {
		this.quantities = quantities;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	// Constructors
	public Medicine(String name, double price, int quantities, LocalDate expirationDate) {
		super();
		this.name = name;
		this.price = price;
		this.quantities = quantities;
		this.expirationDate = expirationDate;
	}

}
