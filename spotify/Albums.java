package aiss.shared.domain.spotify;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Albums implements Serializable {

	
	private static final long serialVersionUID = 3301373113706564633L;
	private String href;
	private List<Item> items;		
	
	public Albums() {
		
	}

	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	   
}
