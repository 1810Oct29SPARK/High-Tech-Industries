package project2.hightechindustries.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CART")
public class Cart {
	
	public Cart(int memberId, int productId, int quantity) {
		super();
		this.memberId = memberId;
		this.productId = productId;
		this.quantity = quantity;
	}
	@Id
	@Column(name="MEMBER_ID")
	int memberId;
	@Column(name="PRODUCT_ID")
	int productId;
	@Column(name="QUANTITY")
	int quantity;
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Cart [memberId=" + memberId + ", productId=" + productId + ", quantity=" + quantity + "]";
	}

}
