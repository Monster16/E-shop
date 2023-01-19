package com.shoppingcartsystem.model;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "userdb", uniqueConstraints = { @UniqueConstraint(columnNames = "uEmail") })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "uId")
	private Long uId;

	@NotBlank
	@Column(name= "uName")
	private String uName;

	@NotBlank
	@Column(name= "uPhone")
	private String uPhone;

	@NotBlank
	@Size(max = 50)
	@Column(name= "uEmail")
	private String uEmail;

	@NotBlank
	@Column(name= "uPassword")
	private String uPassword;
	
	@Column(name= "uAddress")
	private String uAddress;

	public User() {
	
	}

	public Long getuId() {
		return uId;
	}

	public void setuId(Long uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPhone() {
		return uPhone;
	}

	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getuAddress() {
		return uAddress;
	}

	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}

	public User(Long uId, @NotBlank String uName, @NotBlank String uPhone, @NotBlank @Size(max = 50) String uEmail,
			@NotBlank String uPassword, String uAddress) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uPhone = uPhone;
		this.uEmail = uEmail;
		this.uPassword = uPassword;
		this.uAddress = uAddress;
	}

	
	
}
