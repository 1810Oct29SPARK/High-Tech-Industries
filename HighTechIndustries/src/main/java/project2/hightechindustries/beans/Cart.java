package project2.hightechindustries.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CART")
public class Cart {
	
	public Cart(int cartId) {
		super();
		this.cartId=cartId;
	}
	
	public Cart(int cartId, int memberId, int productId, int quantity) {
		super();
		this.cartId = cartId;
		this.memberId = memberId;
		this.productId = productId;
		this.quantity = quantity;
	}
	
	public Cart(int memberId, int productId, int quantity) {
		super();
		this.memberId = memberId;
		this.productId = productId;
		this.quantity = quantity;
	}
	
	public Cart() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="cartSequence")
	@SequenceGenerator(allocationSize=1, name="cartSequence", sequenceName="SQ_CART_ID")
	@Column(name="CART_ID")
	private Integer cartId;
	@Column(name="MEMBER_ID")
	private Integer memberId;
	@Column(name="PRODUCT_ID")
	private Integer productId;
	@Column(name="QUANTITY")
	private Integer quantity;
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
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
		return "Cart [cartId="+ cartId +", memberId=" + memberId + ", productId=" + productId + ", quantity=" + quantity + "]";
	}

}
