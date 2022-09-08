package demos.springboot.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "product_details")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "product_prodid_seq")
	@Column(name = "prodid",scale = 10)
	private int prodId;
	
	@Column(name = "prodname", length = 20)
	private String prodName;
	
	@Column(name = "brand", length = 20)
	private String brand;
	
	@Column(name = "price", scale = 10, precision = 2)
	private Double price;
	
	@Column(name = "dateOfManufacture")
	@Temporal(TemporalType.DATE)
	private Date dateOfManufacture;
	
	@Column(name = "timeOfManufacture")
	@Temporal(TemporalType.TIME)
	private Date timeOfManufacture;
	
	/*
	@ManyToOne
	@JoinColumn(name = "category")
	@JsonIgnoreProperties("products")
	private Category category;
	*/
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int prodId, String prodName, String brand, Double price) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.brand = brand;
		this.price = price;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	public Date getDateOfManufacture() {
		return dateOfManufacture;
	}
	public void setDateOfManufacture(String dateOfManufacture) {
		//this.dateOfManufacture = dateOfManufacture;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.dateOfManufacture = sdf.parse(dateOfManufacture);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Date getTimeOfManufacture() {
		return timeOfManufacture;
	}
	public void setTimeOfManufacture(String timeOfManufacture) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		
		try {
			Date manufactureTime = sdf.parse(timeOfManufacture);
			
			long totalMillis = this.dateOfManufacture.getTime() + manufactureTime.getTime();
			
			totalMillis = totalMillis +((1000*60*60*5)+(1000*60*30));
			
			this.timeOfManufacture = new Date(totalMillis);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	*/
	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", brand=" + brand + ", price=" + price + "]";
	}
	
	
	

}
