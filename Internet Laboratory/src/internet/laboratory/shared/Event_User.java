package internet.laboratory.shared;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

public class Event_User {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Integer Id_Event_User ;
	
	@ForeignKey
	private Integer Id_Event;
	
	@ForeignKey
	private Integer Id_User;
	
	@Persistent
	private Boolean Participation;

	public Event_User(Integer id_Event_User, Integer id_Event, Integer id_User,
			Boolean participation) {
		super();
		Id_Event_User = id_Event_User;
		Id_Event = id_Event;
		Id_User = id_User;
		Participation = participation;
	}

	public Event_User() {
		super();
	}

	public Boolean getParticipation() {
		return Participation;
	}

	public void setParticipation(Boolean participation) {
		Participation = participation;
	}

	public Integer getId_Event_User() {
		return Id_Event_User;
	}

	public Integer getId_Event() {
		return Id_Event;
	}

	public Integer getId_User() {
		return Id_User;
	}
	
	
	
	
}
