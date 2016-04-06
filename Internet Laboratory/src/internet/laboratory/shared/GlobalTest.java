package internet.laboratory.shared;

import java.util.GregorianCalendar;

import javax.jdo.PersistenceManager;

import org.junit.Test;

public class GlobalTest {

	/**
	 * @param args
	 */
	@Test
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// EVENTS
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Event e1 = new Event("Football Game", new GregorianCalendar(),
				"Oktogon", "610920324", "alvarogj@gmail.com", 0.0, 21,
				TypeEvent.SPORT, "Sport clothes", false, 16, "Football match");
		// Event e2 = new Event("Party BME", new GregorianCalendar(), "Instant",
		// "+36123456789" ,
		// "bme@gmail.com", 10.0, 100, TypeEvent.PARTY, "Elegant", true, 18,
		// "Party all the night");

		// Event e3 = new Event("Party Corvnius", new GregorianCalendar(),
		// "Morrisons", "123456789",
		// "corvinus@gmail.com", 8.0, 125, TypeEvent.PARTY, "As you want", true,
		// 18, "The best party ever");

		try {
			pm.makePersistent(e1);
			System.out.println(e1.toString());
		} finally {
			pm.close();
		}

		/*
		 * //Necesitamos un constructor que no pida los parametros que puedan
		 * ser null.
		 * 
		 * //Check Address a null e1.setAddress(null);
		 * 
		 * //Check AgeNeeded e1.setAgeNeeded(-5);
		 * 
		 * //Check Date a null e1.setDate(null);
		 * 
		 * GregorianCalendar gc = new GregorianCalendar(); gc.set(1995,
		 * Calendar.AUGUST,31); //Check Date con una fecha antigua
		 * e1.setDate(gc);
		 * 
		 * //Check Description con mas de 500 caracteres String s=null; for(int
		 * i=0; i<600; i++){ s = "a" + s.toString(); } e1.setDescription(s);
		 * 
		 * //Check Mail a null e1.setMail(null);
		 * 
		 * //Check Mail sin @ e1.setMail("hola");
		 * 
		 * //Check MaxPeople a null e1.setMaxPeople(null);
		 * 
		 * //Check MaxPeople a numero negativo e1.setMaxPeople(-100);
		 * 
		 * //Check Name a null e1.setName(null);
		 * 
		 * //Check Name a String con numeros e1.setName("123456789");
		 * 
		 * //Check Phone a null e1.setPhone(null);
		 * 
		 * //Check Phone con mas digitos e1.setPhone("1234567854452856");
		 * 
		 * //Check Phone con letras e1.setPhone("hola");
		 * 
		 * //Check Price con numero negativo e1.setPrice(-50.0);
		 * 
		 * //Check Type con null e1.setType(null);
		 */

	}
}
