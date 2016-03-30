package internet.laboratory.shared;

import java.util.GregorianCalendar;

import javax.jdo.PersistenceManager;

public class Util_User {

	public void addUser(String username, String password, String name,
			GregorianCalendar birthdate, String phone, String email) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		User u = new User(username, password, name, birthdate, phone, email);
		try {
			pm.makePersistent(u);
		} finally {
			pm.close();
		}
	}

	public void updateUser(User user, String username, String password,
			String name, GregorianCalendar birthdate, String phone, String email) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			User u = pm.getObjectById(User.class, user.getId_User());
			u.setUsername(username);
			u.setPassword(password);
			u.setName(name);
			u.setBirthdate(birthdate);
			u.setPhone(phone);
			u.setEmail(email);
		} finally {
			pm.close();
		}
	}
}
