package project2.hightechindustries.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PURCHASED")
public class Purchased {
	
	public Purchased(int purchasedId, int memberId, int productId, int quantity) {
		super();
		this.purchasedId = purchasedId;
		this.memberId = memberId;
		this.productId = productId;
		this.quantity = quantity;
	}
	
	public Purchased(int memberId, int productId, int quantity) {
		super();
		this.memberId = memberId;
		this.productId = productId;
		this.quantity = quantity;
	}
	
	public Purchased() {	
	}

	public Purchased(int purchasedId) {
		super();
		this.purchasedId = purchasedId;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="purchasedSequence")
	@SequenceGenerator(allocationSize=1, name="purchasedSequence", sequenceName="SQ_PURCHASED_ID")
	@Column(name="PURCHASED_ID")
	int purchasedId;
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
		return "Purchased [memberId=" + memberId + ", productId=" + productId + ", quantity=" + quantity + "]";
	}

}
