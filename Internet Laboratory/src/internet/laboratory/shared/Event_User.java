package internet.laboratory.shared;

import java.io.Serializable;
import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@PersistenceCapable(objectIdClass = ComposedIdKey.class)
public class Event_User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PrimaryKey
	private String Id_Event;

	@PrimaryKey
	private String Id_User;

	@Persistent
	private Boolean Participation;

	public Event_User(String id_Event, String id_User, Boolean participation) {
		super();
		Id_Event = id_Event;
		Id_User = id_User;
		Participation = participation;
	}

	public Boolean getParticipation() {
		return Participation;
	}

	public void setParticipation(Boolean participation) {
		Participation = participation;
	}

	public String getId_Event() {
		return Id_Event;
	}

	public String getId_User() {
		return Id_User;
	}

	@ManyToOne(targetEntity = Event.class, cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private Set<Event_User> eventUser;

	@ManyToOne(targetEntity = User.class, cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private Set<Event_User> userEvent;

}
