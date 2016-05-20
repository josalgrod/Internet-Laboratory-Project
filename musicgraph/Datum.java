
package aiss.shared.domain.musicgraph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
@Generated("org.jsonschema2pojo")
public class Datum implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mainGenre;
    private String decade;
    private String country;
    private String entityType;
    private String artistRefId;
    private String id;
    private String musicbrainzId;
    private List<String> alternateNames = new ArrayList<String>();
    private String name;
    private String spotifyId;
    private String gender;
    private String sortName;
    private String musicbrainzImageUrl;
    private String youtubeId;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The mainGenre
     */
    public String getMainGenre() {
        return mainGenre;
    }

    /**
     * 
     * @param mainGenre
     *     The main_genre
     */
    public void setMainGenre(String mainGenre) {
        this.mainGenre = mainGenre;
    }

    /**
     * 
     * @return
     *     The decade
     */
    public String getDecade() {
        return decade;
    }

    /**
     * 
     * @param decade
     *     The decade
     */
    public void setDecade(String decade) {
        this.decade = decade;
    }

    /**
     * 
     * @return
     *     The countryOfOrigin
     */
    public String getCountry() {
        return country;
    }

    /**
     * 
     * @param countryOfOrigin
     *     The country_of_origin
     */
    public void setCountry(String countryOfOrigin) {
        this.country = countryOfOrigin;
    }

    /**
     * 
     * @return
     *     The entityType
     */
    public String getEntityType() {
        return entityType;
    }

    /**
     * 
     * @param entityType
     *     The entity_type
     */
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    /**
     * 
     * @return
     *     The artistRefId
     */
    public String getArtistRefId() {
        return artistRefId;
    }

    /**
     * 
     * @param artistRefId
     *     The artist_ref_id
     */
    public void setArtistRefId(String artistRefId) {
        this.artistRefId = artistRefId;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The musicbrainzId
     */
    public String getMusicbrainzId() {
        return musicbrainzId;
    }

    /**
     * 
     * @param musicbrainzId
     *     The musicbrainz_id
     */
    public void setMusicbrainzId(String musicbrainzId) {
        this.musicbrainzId = musicbrainzId;
    }

    /**
     * 
     * @return
     *     The alternateNames
     */
    public List<String> getAlternateNames() {
        return alternateNames;
    }

    /**
     * 
     * @param alternateNames
     *     The alternate_names
     */
    public void setAlternateNames(List<String> alternateNames) {
        this.alternateNames = alternateNames;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The spotifyId
     */
    public String getSpotifyId() {
        return spotifyId;
    }

    /**
     * 
     * @param spotifyId
     *     The spotify_id
     */
    public void setSpotifyId(String spotifyId) {
        this.spotifyId = spotifyId;
    }

    /**
     * 
     * @return
     *     The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 
     * @param gender
     *     The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 
     * @return
     *     The sortName
     */
    public String getSortName() {
        return sortName;
    }

    /**
     * 
     * @param sortName
     *     The sort_name
     */
    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    /**
     * 
     * @return
     *     The musicbrainzImageUrl
     */
    public String getMusicbrainzImageUrl() {
        return musicbrainzImageUrl;
    }

    /**
     * 
     * @param musicbrainzImageUrl
     *     The musicbrainz_image_url
     */
    public void setMusicbrainzImageUrl(String musicbrainzImageUrl) {
        this.musicbrainzImageUrl = musicbrainzImageUrl;
    }

    /**
     * 
     * @return
     *     The youtubeId
     */
    public String getYoutubeId() {
        return youtubeId;
    }

    /**
     * 
     * @param youtubeId
     *     The youtube_id
     */
    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
