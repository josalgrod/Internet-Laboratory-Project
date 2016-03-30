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
			if (checkUserName(username) && checkPassword(password)
					&& checkName(name) && checkBirthdate(birthdate)
					&& checkPhone(phone) && checkEmail(email)) {
				u.setUsername(username);
				u.setPassword(password);
				u.setName(name);
				u.setBirthdate(birthdate);
				u.setPhone(phone);
				u.setEmail(email);
			}
		} finally {
			pm.close();
		}
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
		return birthdate.before(current);
	}

	private boolean checkName(String name) {
		boolean res = false;
		for (int i = 0; i < name.length(); i++) {
			char espace = ' ';
			if (Character.isAlphabetic(name.charAt(i))
					|| name.charAt(i) == espace) {
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
					&& password.length() < 16) {
				res = true;
			}
		}
		return res;
	}

	private boolean checkUserName(String username) {
		return !username.isEmpty();
	}
}
