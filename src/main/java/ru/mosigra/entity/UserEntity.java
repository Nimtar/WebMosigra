package ru.mosigra.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "public", catalog = "mosigra")
public class UserEntity {
	private String fullName;
	private String username;
	private short id;
	private String passwordHash;
	private String phoneNumber;

	@Basic
	@Column(name = "full_name", nullable = false, length = 256)
	public String getFullName () {
		return fullName;
	}

	public UserEntity setFullName (String fullName) {
		this.fullName = fullName;
		return this;
	}

	@Basic
	@Column(name = "username", nullable = false, length = 256)
	public String getUsername () {
		return username;
	}

	public UserEntity setUsername (String username) {
		this.username = username;
		return this;
	}

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public short getId () {
		return id;
	}

	public UserEntity setId (short id) {
		this.id = id;
		return this;
	}

	@Basic
	@Column(name = "password_hash", nullable = false, length = 64)
	public String getPasswordHash () {
		return passwordHash;
	}

	public UserEntity setPasswordHash (String passwordHash) {
		this.passwordHash = passwordHash;
		return this;
	}

	@Basic
	@Column(name = "phone_number", nullable = true, length = 16)
	public String getPhoneNumber () {
		return phoneNumber;
	}

	public UserEntity setPhoneNumber (String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	@Override
	public int hashCode () {
		return Objects.hash(fullName, username, id, passwordHash, phoneNumber);
	}

	@Override
	public boolean equals (Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || !getClass().equals(o.getClass())) {
			return false;
		}
		UserEntity that = (UserEntity)o;
		return id == that.id && Objects.equals(fullName, that.fullName)
			&& Objects.equals(username, that.username) && Objects.equals(
			passwordHash, that.passwordHash) && Objects.equals(phoneNumber,
			that.phoneNumber);
	}

	@Override
	public String toString () {
		return "UserEntity { " + "fullName='" + fullName + '\'' + ", "
			+ "username='" + username + '\'' + ", id=" + id + ", "
			+ "passwordHash='" + passwordHash + '\'' + ", phoneNumber='"
			+ phoneNumber + '\'' + " }";
	}
}
