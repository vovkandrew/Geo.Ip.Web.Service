package geo.ip.web.service.demo.dto;

public class LocationResponseDto {
    private String canonicalIPv4Representation;
    private String cityName;
    private String countryCode;
    private String countryName;
    private int IPv4;
    private double latitude;
    private double longitude;
    private String regionName;

    public LocationResponseDto(String canonicalIPv4Representation, String cityName, String countryCode,
                               String countryName, int IPv4, double latitude, double longitude, String regionName) {
        this.canonicalIPv4Representation = canonicalIPv4Representation;
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.IPv4 = IPv4;
        this.latitude = latitude;
        this.longitude = longitude;
        this.regionName = regionName;
    }

    public LocationResponseDto() {
    }

    public String getCanonicalIPv4Representation() {
        return canonicalIPv4Representation;
    }

    public void setCanonicalIPv4Representation(String canonicalIPv4Representation) {
        this.canonicalIPv4Representation = canonicalIPv4Representation;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    public int getIPv4() {
        return IPv4;
    }

    public void setIPv4(int IPv4) {
        this.IPv4 = IPv4;
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

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationResponseDto that = (LocationResponseDto) o;

        if (IPv4 != that.IPv4) return false;
        if (Double.compare(that.latitude, latitude) != 0) return false;
        if (Double.compare(that.longitude, longitude) != 0) return false;
        if (canonicalIPv4Representation != null ? !canonicalIPv4Representation.equals(that.canonicalIPv4Representation) : that.canonicalIPv4Representation != null)
            return false;
        if (cityName != null ? !cityName.equals(that.cityName) : that.cityName != null) return false;
        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;
        if (countryName != null ? !countryName.equals(that.countryName) : that.countryName != null) return false;
        return regionName != null ? regionName.equals(that.regionName) : that.regionName == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = canonicalIPv4Representation != null ? canonicalIPv4Representation.hashCode() : 0;
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        result = 31 * result + IPv4;
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        return result;
    }
}
