package project2.hightechindustries.beans;

import java.io.File;
import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @Author (name="Sean, SBG")
 * this POJO will represent a single row in the STORE
 * the constructors in the class are a no args, and a full args constructor
 */
@Entity
@Table(name="STORE")
public class Store implements Serializable {
	
	public Store(Integer productId, String productName, String description, Double price, String specs, File pic) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.specs = specs;
		this.pic = pic;
	}


	private static final long serialVersionUID = 1L;
	
	public Store(int productId, String productName, String description, Double price, String specs, byte[] image) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.specs = specs;
		this.image = image;
	}
	
	public Store(String productName, String description, Double price, String specs, byte[] image) {
		super();
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.specs = specs;
		this.image = image;
	}
	
	public Store(int productId, byte[] image) {
		super();
		this.productId = productId;
		this.image = image;
	}
	
	public Store(int productId) {
		super();
		this.productId = productId;
	}
	
	public Store() {};

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "storeSequence")
	@SequenceGenerator(allocationSize = 1, name = "storeSequence", sequenceName = "SQ_STORE_ID")
	@Column(name="PRODUCT_ID")
	private Integer productId;
	@Column(name="PRODUCT_NAME")
	private String productName;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="PRICE")
	private Double price;
	@Column(name="SPECIFICATIONS")
	private String specs;
	@Column(name="IMAGE")
	private byte[] image;
	@Transient
	private File pic;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getSpecs() {
		return specs;
	}
	public void setSpecs(String specs) {
		this.specs = specs;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] imageData) {
		this.image = imageData;
	}
	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}
	@Override
	public String toString() {
		return "Store [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", price=" + price + ", specs=" + specs + ", image=" + image + "]";
	}

	

}
