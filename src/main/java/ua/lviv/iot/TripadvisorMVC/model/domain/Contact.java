package ua.lviv.iot.TripadvisorMVC.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "website_url")
	private String websiteUrl;

	@Column(name = "phone_number")
	private Long phoneNumber;

	@Column(name = "email")
	private String email;

	public Contact(Integer id, String websiteUrl, Long phoneNumber, String email) {
		super();
		this.id = id;
		this.websiteUrl = websiteUrl;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Contact(String websiteUrl, Long phoneNumber, String email) {
		super();
		this.websiteUrl = websiteUrl;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Contact() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((websiteUrl == null) ? 0 : websiteUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Contact other = (Contact) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (phoneNumber == null) {
			if (other.phoneNumber != null) {
				return false;
			}
		} else if (!phoneNumber.equals(other.phoneNumber)) {
			return false;
		}
		if (websiteUrl == null) {
			if (other.websiteUrl != null) {
				return false;
			}
		} else if (!websiteUrl.equals(other.websiteUrl)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", websiteUrl=" + websiteUrl + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ "]";
	}
}