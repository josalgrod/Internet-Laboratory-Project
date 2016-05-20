package aiss.shared.domain.spotify;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AlbumSearch implements Serializable {

	private static final long serialVersionUID = 2686704549319794406L;
	private Albums albums;
	
	public Albums getAlbums(){
		return this.albums;
	}
	public void setAlbums(Albums albums){
		this.albums = albums;
	}	
}

