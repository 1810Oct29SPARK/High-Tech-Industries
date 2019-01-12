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
 * each instance of this class represents a row within the members table
 * there are serveral constructors, a no args, an id constructor for searching
 * a idLess constructor for insertion, and a full constructor for grabbing data from DB 
 **/
@Entity
@Table(name="MEMBERS")
public class Users {
	
	public Users(int id, String firstName, String lastName, String email, String phone, String employeeStatus,
			int helpedBy, Blob picture, String username, String passHash, String salt) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.employeeStatus = employeeStatus;
		this.helpedBy = helpedBy;
		this.picture = picture;
		this.username = username;
		this.password = passHash;
		this.salt = salt;
	}
	
	public Users(String firstName, String lastName, String email, String phone, String employeeStatus,
			int helpedBy, Blob picture, String username, String passHash, String salt) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.employeeStatus = employeeStatus;
		this.helpedBy = helpedBy;
		this.picture = picture;
		this.username = username;
		this.password = passHash;
		this.salt = salt;
	}
	
	public Users(int id) {
		super();
		this.id = id;
	}
	
	public Users(String firstName, String lastName, String email, String phone, String employeeStatus,
			String username, String passHash, String salt) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.employeeStatus = employeeStatus;
		this.username = username;
		this.password = passHash;
		this.salt = salt;
	}
	
	// add method to get users info by their username and password
	public Users(String username, String passHash) {
		super();
		this.username = username;
		this.password = passHash;
	}
	
	public Users() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "userSequence")
	@SequenceGenerator(allocationSize = 1, name = "userSequence", sequenceName = "SQ_MEMBER_ID")
	@Column(name="MEMBER_ID")
	private Integer id;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="EMAIL")
	private String email;
	@Column(name="PHONE")
	private String phone;
	@Column(name="EMPLOYEE_STATUS")
	private String employeeStatus;
	@Column(name="HELPED_BY")
	private Integer helpedBy;
	@Column(name="IMAGE")
	private Blob picture;
	@Column(name="MEMBER_NAME")
	private String username;
	@Column(name="PASSWORD_HASH")
	private String password;
	@Column(name="SALT")
	private String salt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmployeeStatus() {
		return employeeStatus;
	}
	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}
	public int getHelpedBy() {
		return helpedBy;
	}
	public void setHelpedBy(int helpedBy) {
		this.helpedBy = helpedBy;
	}
	public Blob getPicture() {
		return picture;
	}
	public void setPicture(Blob picture) {
		this.picture = picture;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassHash() {
		return password;
	}
	public void setPassHash(String passHash) {
		this.password = passHash;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", employeeStatus=" + employeeStatus + ", helpedBy=" + helpedBy + ", picture="
				+ picture + ", username=" + username + ", passHash=" + password + ", salt=" + salt + "]";
	}

}
