package geo.ip.web.service.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long locationId;
    private int ipFrom;
    private int ipTo;
    private String countryCode;
    private String countryName;
    private String regionName;
    private String cityName;
    private double latitude;
    private double longitude;

    public Location() {
    }

    public Location(long id, int ipFrom, int ipTo, String countryCode, String countryName,
                    String regionName, String cityName, double latitude, double longitude) {
        this.locationId = id;
        this.ipFrom = ipFrom;
        this.ipTo = ipTo;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.regionName = regionName;
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location(int ipFrom, int ipTo, String countryCode, String countryName,
                    String regionName, String cityName, double latitude, double longitude) {
        this.ipFrom = ipFrom;
        this.ipTo = ipTo;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.regionName = regionName;
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long id) {
        this.locationId = id;
    }

    public int getIpFrom() {
        return ipFrom;
    }

    public void setIpFrom(int ipFrom) {
        this.ipFrom = ipFrom;
    }

    public int getIpTo() {
        return ipTo;
    }

    public void setIpTo(int ipTo) {
        this.ipTo = ipTo;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (locationId != location.locationId) return false;
        if (ipFrom != location.ipFrom) return false;
        if (ipTo != location.ipTo) return false;
        if (Double.compare(location.latitude, latitude) != 0) return false;
        if (Double.compare(location.longitude, longitude) != 0) return false;
        if (countryCode != null ? !countryCode.equals(location.countryCode) : location.countryCode != null)
            return false;
        if (countryName != null ? !countryName.equals(location.countryName) : location.countryName != null)
            return false;
        if (regionName != null ? !regionName.equals(location.regionName) : location.regionName != null) return false;
        return cityName != null ? cityName.equals(location.cityName) : location.cityName == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (locationId ^ (locationId >>> 32));
        result = 31 * result + ipFrom;
        result = 31 * result + ipTo;
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
