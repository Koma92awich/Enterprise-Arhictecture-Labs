package edu.mum.cs.cs544.exercises;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "car_brand", length = 255, nullable = false)
	private String brand;

	@Column(name = "model", length = 255, nullable = false)
	private String year;

	@Column(name = "car_price", length = 255, nullable = false)
	private double price;

	@ManyToOne
	@JoinColumn(name="car_owner")
	private Owner owner;
	
	public Car() {
	}

	public Car(String brand, String year, double price) {
		this.brand = brand;
		this.year = year;
		this.price = price;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getYear() {
		return year;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
	
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	public Owner getOwner() {
		return owner;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", year=" + year + ", price=" + price + "]";
	}

}
