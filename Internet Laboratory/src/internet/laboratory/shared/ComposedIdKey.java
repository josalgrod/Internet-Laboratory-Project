package internet.laboratory.shared;

import java.io.Serializable;
import java.util.StringTokenizer;

public class ComposedIdKey implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	public String Id_Event;
	public String Id_User;

	public ComposedIdKey() {
	}

	/**
	 * Constructor accepting same input as generated by toString().
	 */
	public ComposedIdKey(String value) {
		StringTokenizer token = new StringTokenizer(value, "::");
		token.nextToken(); // className
		this.Id_Event = token.nextToken(); // field1
		this.Id_User = token.nextToken(); // field2
	}

	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof ComposedIdKey)) {
			return false;
		}
		ComposedIdKey c = (ComposedIdKey) obj;

		return Id_Event.equals(c.Id_Event) && Id_User.equals(c.Id_User);
	}

	public int hashCode() {
		return this.Id_Event.hashCode() ^ this.Id_User.hashCode();
	}

	public String toString() {
		// Give output expected by String constructor
		return this.getClass().getName() + "::" + this.Id_Event + "::"
				+ this.Id_User;
	}
}
