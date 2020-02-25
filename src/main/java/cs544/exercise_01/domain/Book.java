package cs544.exercise_01.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name ="BookTitle", length=255, nullable=false)
	private String title;
	
	@Column(name ="BookISBN", length=255, nullable=false)
	private String ISBN;
	
	@Column(name ="BookAuthor", length=255, nullable=false)
	private String  author;
	
	@Column(name ="BookPrice", length=255, nullable=false)
	private double price;
	
	@Temporal(TemporalType.DATE)
	private LocalDate publish_date;
	

	public Book() {
		
	}

	public Book(String title, String iSBN, String author, double price) {
		this.title = title;
		ISBN = iSBN;
		this.author = author;
		this.price = price;
		//this.publish_date = publish_date;
	}

	public Long getId() {
		return Id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(LocalDate publish_date) {
		this.publish_date = publish_date;
	}
	
	
	


}
