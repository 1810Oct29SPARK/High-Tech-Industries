package project2.hightechindustries.beans;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
		this.passHash = passHash;
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
		this.passHash = passHash;
		this.salt = salt;
	}
	
	public Users() {};
	
	@Id
	@Column(name="MEMBER_ID")
	private int id;
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
	private int helpedBy;
	@Column(name="IMAGE")
	private Blob picture;
	@Column(name="MEMBER_NAME")
	private String username;
	@Column(name="PASSWORD_HASH")
	private String passHash;
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
		return passHash;
	}
	public void setPassHash(String passHash) {
		this.passHash = passHash;
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
				+ picture + ", username=" + username + ", passHash=" + passHash + ", salt=" + salt + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((employeeStatus == null) ? 0 : employeeStatus.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + helpedBy;
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((passHash == null) ? 0 : passHash.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		result = prime * result + ((salt == null) ? 0 : salt.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Users other = (Users) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employeeStatus == null) {
			if (other.employeeStatus != null)
				return false;
		} else if (!employeeStatus.equals(other.employeeStatus))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (helpedBy != other.helpedBy)
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (passHash == null) {
			if (other.passHash != null)
				return false;
		} else if (!passHash.equals(other.passHash))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		if (salt == null) {
			if (other.salt != null)
				return false;
		} else if (!salt.equals(other.salt))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
