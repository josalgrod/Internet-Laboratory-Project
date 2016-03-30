package internet.laboratory.shared;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Set;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;

public class User implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key Id_User;

	@ForeignKey
	private Key Id_Event_User;

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
		Username = username;
		Password = password;
		Name = name;
		Birthdate = birthdate;
		Phone = phone;
		Email = email;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	public GregorianCalendar getBirthdate() {
		return Birthdate;
	}

	public void setBirthdate(GregorianCalendar birthdate) {
		Birthdate = birthdate;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Key getId_User() {
		return Id_User;
	}

	@OneToMany(mappedBy = "User_Event", cascade = CascadeType.REFRESH, fetch=FetchType.LAZY) 
	private Set<Event_User> userEvent;
}