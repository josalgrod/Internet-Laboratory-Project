package internet.laboratory.shared;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class Util_Event {

	public void addEvent(String name, Date date, String address,
			String phone, String mail, Double price, Integer maxPeople,
			TypeEvent type, String dresscode, Boolean bringOwnAlcohol,
			Integer ageNeeded, String description) {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		Event e = new Event(name, date, address, phone, mail, price, maxPeople,
				type, dresscode, bringOwnAlcohol, ageNeeded, description);
		try {
			pm.makePersistent(e);
		} finally {
			pm.close();
		}

	}

	public void updateEvent(Event event, String name, Date date,
			String address, String phone, String mail, Double price,
			Integer maxPeople, TypeEvent type, String dresscode,
			Boolean bringOwnAlcohol, Integer ageNeeded, String description) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Event e = pm.getObjectById(Event.class, event.getId_Event());
			e.setAddress(address);
			e.setAgeNeeded(ageNeeded);
			e.setBringOwnAlcohol(bringOwnAlcohol);
			e.setDate(date);
			e.setDescription(description);
			e.setDresscode(dresscode);
			e.setMail(mail);
			e.setMaxPeople(maxPeople);
			e.setName(name);
			e.setPhone(phone);
			e.setPrice(price);
			e.setType(type);

		} finally {
			pm.close();
		}
	}

	public Event searchEvent(String k) {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		Event e = pm.getObjectById(Event.class, k);
		pm.close();
		return e;

	}

	public List<Event> searchEventByName(String name) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery("select from Event" + "where Name == NameParam "
				+ "parameters String NameParam");
		List<Event> results = (List<Event>) q.execute(name);
		pm.close();
		return results;

	}

	public void deleteEvent(Event e) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		pm.deletePersistent(e);
		pm.close();
	}

}
