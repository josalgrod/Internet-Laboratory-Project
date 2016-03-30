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

public class Event implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key Id_Event;

	@ForeignKey
	@Persistent
	private Key Id_Event_User;
	
    @Persistent
    private String Name;

    @Persistent
    private GregorianCalendar Date;

    @Persistent
    private String Address;
    
    @Persistent
    private String Phone;
    	
    @Persistent
    private String Mail;
    
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
    
    
    
    
	public Event(Key id_Event, String name, GregorianCalendar date,
			String address, String phone, String mail, Double price,
			Integer maxPeople, TypeEvent type, String dresscode,
			Boolean bringOwnAlcohol, Integer ageNeeded,String description) {
		super();
		Id_Event = id_Event;
		Name = name;
		Date = date;
		Address = address;
		Phone = phone;
		Mail = mail;
		Price = price;
		MaxPeople = maxPeople;
		Type = type;
		Dresscode = dresscode;
		BringOwnAlcohol = bringOwnAlcohol;
		AgeNeeded = ageNeeded;
		Description = description;
	}

	public Key getId_Event() {
		return Id_Event;
	}

	public Key getId_Event_User() {
		return Id_Event_User;
	}

	public void setId_Event_User(Key id_Event_User) {
		Id_Event_User = id_Event_User;
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

	public String getMail() {
		return Mail;
	}

	public void setMail(String mail) {
		Mail = mail;
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
 
	@OneToMany(mappedBy = "Event_User", cascade = CascadeType.REFRESH, fetch=FetchType.LAZY) 
	private Set<Event_User> eventUser;
	
	
}
