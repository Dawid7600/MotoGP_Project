package Model;

public class Track {

    private String location;
    private String country;
    private String distance;
    private String openDate;
    private String trackRecord;
    private String description;

    public Track(String location, String country, String distance,
                 String openDate, String trackRecord, String description) {
        this.location = location;
        this.country = country;
        this.distance = distance;
        this.openDate = openDate;
        this.trackRecord = trackRecord;
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getTrackRecord() {
        return trackRecord;
    }

    public void setTrackRecord(String trackRecord) {
        this.trackRecord = trackRecord;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
