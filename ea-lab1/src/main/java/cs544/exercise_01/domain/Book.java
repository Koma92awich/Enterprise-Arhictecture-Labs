package cs544.exercise_01.domain;

import java.util.Date;

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
	private Date publish_date;
	

	public Book() {
		
	}

	public Book(String title, String iSBN, String author, double price,Date publish_date) {
		this.title = title;
		ISBN = iSBN;
		this.author = author;
		this.price = price;
		this.publish_date = publish_date;
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

	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	@Override
	public String toString() {
		return "Book [Id=" + Id + ", title=" + title + ", ISBN=" + ISBN + ", author=" + author + ", price=" + price
				+ ", publish_date=" + publish_date + "]";
	}
	
	
	


}
