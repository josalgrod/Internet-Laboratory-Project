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

public class Event implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String Id_Event;

	@Persistent
	private String Name;

	@Persistent
	private GregorianCalendar Date;

	@Persistent
	private String Address;

	@Persistent
	private String Phone;

	@Persistent
	private String Email;

	@Persistent
	private Double Price;

	@Persistent
	private Integer MaxPeople;

	@Persistent
	private TypeEvent Type;

	@Persistent
	private String Dresscode;

	@Persistent
	private Boolean BringOwnAlcohol;

	@Persistent
	private Integer AgeNeeded;

	@Persistent
	private String Description;

	public Event(String name, GregorianCalendar date, String address,
			String phone, String email, Double price, Integer maxPeople,
			TypeEvent type, String dresscode, Boolean bringOwnAlcohol,
			Integer ageNeeded, String description) {
		super();
		if (checkName(name) && checkDate(date) && checkAddress(address)
				&& checkPhone(phone) && checkEmail(email) && checkPrice(price)
				&& checkMaxPeople(maxPeople) && checkType(type)
				&& checkAgeNeeded(ageNeeded) && checkDescription(description)) {
			Name = name;
			Date = date;
			Address = address;
			Phone = phone;
			Email = email;
			Price = price;
			MaxPeople = maxPeople;
			Type = type;
			Dresscode = dresscode;
			BringOwnAlcohol = bringOwnAlcohol;
			AgeNeeded = ageNeeded;
			Description = description;
		}
	}

	public String getId_Event() {
		return Id_Event;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public GregorianCalendar getDate() {
		return Date;
	}

	public void setDate(GregorianCalendar date) {
		Date = date;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
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

	public void setMail(String mail) {
		Email = mail;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public Integer getMaxPeople() {
		return MaxPeople;
	}

	public void setMaxPeople(Integer maxPeople) {
		MaxPeople = maxPeople;
	}

	public TypeEvent getType() {
		return Type;
	}

	public void setType(TypeEvent type) {
		Type = type;
	}

	public String getDresscode() {
		return Dresscode;
	}

	public void setDresscode(String dresscode) {
		Dresscode = dresscode;
	}

	public Boolean getBringOwnAlcohol() {
		return BringOwnAlcohol;
	}

	public void setBringOwnAlcohol(Boolean bringOwnAlcohol) {
		BringOwnAlcohol = bringOwnAlcohol;
	}

	public Integer getAgeNeeded() {
		return AgeNeeded;
	}

	public void setAgeNeeded(Integer ageNeeded) {
		AgeNeeded = ageNeeded;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Id_Event == null) ? 0 : Id_Event.hashCode());
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
		Event other = (Event) obj;
		if (Id_Event == null) {
			if (other.Id_Event != null)
				return false;
		} else if (!Id_Event.equals(other.Id_Event))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [Id_Event=" + Id_Event + ", Name=" + Name + ", Date="
				+ Date + ", Address=" + Address + ", Phone=" + Phone
				+ ", Email=" + Email + ", Price=" + Price + ", MaxPeople="
				+ MaxPeople + ", Type=" + Type + ", Dresscode=" + Dresscode
				+ ", BringOwnAlcohol=" + BringOwnAlcohol + ", AgeNeeded="
				+ AgeNeeded + ", Description=" + Description + "]";
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

	private boolean checkDate(GregorianCalendar date) {
		GregorianCalendar current = new GregorianCalendar();
		return date.before(current) && date != null;
	}

	private boolean checkDescription(String description) {
		return description.length() <= 500;
	}

	private boolean checkType(TypeEvent type) {
		return type.equals(TypeEvent.MUSIC) || type.equals(TypeEvent.OTHER)
				|| type.equals(TypeEvent.PARTY) || type.equals(TypeEvent.SPORT);
	}

	private boolean checkMaxPeople(Integer maxPeople) {
		return maxPeople != null && maxPeople > 0;
	}

	private boolean checkPrice(Double price) {
		return price >= 0;
	}

	private boolean checkAddress(String address) {
		boolean res = false;
		for (int i = 0; i < address.length(); i++) {
			char espace = ' ';
			if (Character.isAlphabetic(address.charAt(i))
					|| Character.isDigit(address.charAt(i))
					&& address.charAt(i) == espace) {
				res = true;
			}
		}
		return res;
	}

	private boolean checkAgeNeeded(Integer ageNeeded) {
		return ageNeeded.compareTo(getAgeNeeded()) > 0;
	}

	@OneToMany(mappedBy = "Event_User", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private Set<Event_User> eventUser;

}
