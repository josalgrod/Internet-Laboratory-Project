package internet.laboratory.shared;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Set;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String Id_User;

	@Persistent
	private String Username;

	@Persistent
	private String Password;

	@Persistent
	private String Name;

	@Persistent
	private GregorianCalendar Birthdate;

	@Persistent
	private String Phone;

	@Persistent
	private String Email;

	public User(String username, String password, String name,
			GregorianCalendar birthdate, String phone, String email) {
		super();

		if (checkUserName(username) && checkPassword(password)
				&& checkName(name) && checkBirthdate(birthdate)
				&& checkPhone(phone) && checkEmail(email)) {
			Username = username;
			Password = password;
			Name = name;
			Birthdate = birthdate;
			Phone = phone;
			Email = email;
		}
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		if (checkUserName(username))
			Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		if (checkPassword(password))
			Password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		if (checkName(name))
			Name = name;
	}

	public GregorianCalendar getBirthdate() {
		return Birthdate;
	}

	public void setBirthdate(GregorianCalendar birthdate) {
		if (checkBirthdate(birthdate))
			Birthdate = birthdate;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		if (checkPhone(phone))
			Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		if (checkEmail(email))
			Email = email;
	}

	public String getId_User() {
		return Id_User;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id_User == null) ? 0 : Id_User.hashCode());
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
		User other = (User) obj;
		if (Id_User == null) {
			if (other.Id_User != null)
				return false;
		} else if (!Id_User.equals(other.Id_User))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [Id_User=" + Id_User + ", Username=" + Username
				+ ", Password=" + Password + ", Name=" + Name + ", Birthdate="
				+ Birthdate + ", Phone=" + Phone + ", Email=" + Email + "]";
	}

	private boolean checkEmail(String email) {
		return !email.isEmpty() && email.contains("@");
	}

	private boolean checkPhone(String phone) {
		return phone.length() == 9 && Character.isDigit(0)
				&& Character.isDigit(1) && Character.isDigit(2)
				&& Character.isDigit(3) && Character.isDigit(4)
				&& Character.isDigit(5) && Character.isDigit(6)
				&& Character.isDigit(7) && Character.isDigit(8);
	}

	private boolean checkBirthdate(GregorianCalendar birthdate) {
		GregorianCalendar current = new GregorianCalendar();
		return birthdate.before(current) && birthdate != null;
	}

	private boolean checkName(String name) {
		boolean res = false;
		for (int i = 0; i < name.length(); i++) {
			char espace = ' ';
			if (Character.isAlphabetic(name.charAt(i))
					|| name.charAt(i) == espace && name != null) {
				res = true;
			}
		}
		return res;
	}

	private boolean checkPassword(String password) {
		boolean res = false;
		for (int i = 0; i < password.length(); i++) {
			char espace = ' ';
			if (Character.isAlphabetic(password.charAt(i))
					|| Character.isDigit(password.charAt(i))
					&& password.charAt(i) != espace && password.length() > 5
					&& password.length() < 16 && password != null) {
				res = true;
			}
		}
		return res;
	}

	private boolean checkUserName(String username) {
		return !username.isEmpty();
	}

	@OneToMany(mappedBy = "User_Event", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private Set<Event_User> userEvent;
}
