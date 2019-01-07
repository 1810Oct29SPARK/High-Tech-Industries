package project2.hightechindustries.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author (name="SBG")
 * each instance of this class will represent a row within the RECENTLY_VIEWED table
 * the constructors in this class are used in different ways, there is a no-args,
 * a userId only version which exists to generate a row in the table to avoid null-pointer,
 * a userId+productId version which passes a productId for insertion into the DB,
 * and a full constructor for grabbing data from DB 
 **/
@Entity
@Table(name="RECENTLY_VIEWED")
public class RecentlyViewed {
	
	public RecentlyViewed(int memberId, int productId1, int productId2, int productId3, int productId4,
			int productId5) {
		super();
		this.memberId = memberId;
		this.productId1 = productId1;
		this.productId2 = productId2;
		this.productId3 = productId3;
		this.productId4 = productId4;
		this.productId5 = productId5;
	}
	
	public RecentlyViewed(int memberId, int productId1) {
		super();
		this.memberId = memberId;
		this.productId1 = productId1;
	}
	
	public RecentlyViewed(int memberId) {
		super();
		this.memberId = memberId;
	}
	
	public RecentlyViewed() {
	}
	
	@Id
	@Column(name="MEMBER_ID")
	private Integer memberId;
	@Column(name="PRODUCT_ID_1")
	private Integer productId1;
	@Column(name="PRODUCT_ID_2")
	private Integer productId2;
	@Column(name="PRODUCT_ID_3")
	private Integer productId3;
	@Column(name="PRODUCT_ID_4")
	private Integer productId4;
	@Column(name="PRODUCT_ID_5")
	private Integer productId5;
	
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Integer getProductId1() {
		return productId1;
	}
	public void setProductId1(int productId1) {
		this.productId1 = productId1;
	}
	public Integer getProductId2() {
		return productId2;
	}
	public void setProductId2(int productId2) {
		this.productId2 = productId2;
	}
	public Integer getProductId3() {
		return productId3;
	}
	public void setProductId3(int productId3) {
		this.productId3 = productId3;
	}
	public Integer getProductId4() {
		return productId4;
	}
	public void setProductId4(int productId4) {
		this.productId4 = productId4;
	}
	public Integer getProductId5() {
		return productId5;
	}
	public void setProductId5(int productId5) {
		this.productId5 = productId5;
	}
	@Override
	public String toString() {
		return "RecentlyViewed [memberId=" + memberId + ", productId1=" + productId1
				+ ", productId2=" + productId2 + ", productId3=" + productId3 + ", productId4=" + productId4
				+ ", productId5=" + productId5 + "]";
	}

}
