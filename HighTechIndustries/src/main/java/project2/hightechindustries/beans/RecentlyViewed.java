package project2.hightechindustries.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RECENTLY_VIEWED")
public class RecentlyViewed {
	
	public RecentlyViewed(int viewedId, int memberId, int productId1, int productId2, int productId3, int productId4,
			int productId5) {
		super();
		this.viewedId = viewedId;
		this.memberId = memberId;
		this.productId1 = productId1;
		this.productId2 = productId2;
		this.productId3 = productId3;
		this.productId4 = productId4;
		this.productId5 = productId5;
	}
	
	@Id
	@Column(name="VIEWED_ID")
	int viewedId;
	@Column(name="MEMBER_ID")
	int memberId;
	@Column(name="PRODUCT_ID_1")
	int productId1;
	@Column(name="PRODUCT_ID_2")
	int productId2;
	@Column(name="PRODUCT_ID_3")
	int productId3;
	@Column(name="PRODUCT_ID_4")
	int productId4;
	@Column(name="PRODUCT_ID_5")
	int productId5;
	
	public int getViewedId() {
		return viewedId;
	}
	public void setViewedId(int viewedId) {
		this.viewedId = viewedId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getProductId1() {
		return productId1;
	}
	public void setProductId1(int productId1) {
		this.productId1 = productId1;
	}
	public int getProductId2() {
		return productId2;
	}
	public void setProductId2(int productId2) {
		this.productId2 = productId2;
	}
	public int getProductId3() {
		return productId3;
	}
	public void setProductId3(int productId3) {
		this.productId3 = productId3;
	}
	public int getProductId4() {
		return productId4;
	}
	public void setProductId4(int productId4) {
		this.productId4 = productId4;
	}
	public int getProductId5() {
		return productId5;
	}
	public void setProductId5(int productId5) {
		this.productId5 = productId5;
	}
	@Override
	public String toString() {
		return "RecentlyViewed [viewedId=" + viewedId + ", memberId=" + memberId + ", productId1=" + productId1
				+ ", productId2=" + productId2 + ", productId3=" + productId3 + ", productId4=" + productId4
				+ ", productId5=" + productId5 + "]";
	}

}
