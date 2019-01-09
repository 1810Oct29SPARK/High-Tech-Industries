package project2.hightechindustries.beans;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @Author (name="Sean, SBG")
 * this POJO will represent a single row in the STORE
 * the constructors in the class are a no args, and a full args constructor
 */
@Entity
@Table(name="STORE")
public class Store {
	
	public Store(int productId, String productName, String description, Double price, String specs, Blob image) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.specs = specs;
		this.image = image;
	}
	
	public Store(String productName, String description, Double price, String specs, Blob image) {
		super();
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.specs = specs;
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
	private Blob image;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
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
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Store [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", price=" + price + ", specs=" + specs + ", image=" + image + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + productId;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((specs == null) ? 0 : specs.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Store other = (Store) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (specs == null) {
			if (other.specs != null)
				return false;
		} else if (!specs.equals(other.specs))
			return false;
		return true;
	}

}
