package geo.ip.web.service.demo;

import geo.ip.web.service.demo.dto.LocationResponseDto;
import geo.ip.web.service.demo.mapper.LocationMapper;
import org.junit.Assert;
import org.junit.Test;
import geo.ip.web.service.demo.model.Location;

public class LocationMapperTest {
    @Test
    public void checkGetLocationFromStringArr() {
        String[] arr = {"16797952", "16798207", "JP", "Japan", "Tottori", "Kurayoshi", "35.433000", "133.817000"};
        LocationMapper mapper = new LocationMapper();
        Location expected = new Location(16797952, 16798207, "JP", "Japan",
                "Tottori", "Kurayoshi", 35.433000, 133.817000);
        Location actual = mapper.getLocationFromStringArr(arr);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkGetLocationFromStringArrNotEqualLocations() {
        String[] arr = {"16812032", "16812287", "TH", "Thailand", "Kanchanaburi", "Bo Phloi", "14.323610", "99.516110"};
        LocationMapper mapper = new LocationMapper();
        Location expected = new Location(16797952, 16798207, "JP", "Japan",
                "Tottori", "Kurayoshi", 35.433000, 133.817000);
        Location actual = mapper.getLocationFromStringArr(arr);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void checkGetLocationResponseDtoFromLocation() {
        String canonicalIp = "1.0.136.153";
        int ipInt = 16812185;
        Location location = new Location(16812032, 16812287, "TH", "Thailand",
                "Kanchanaburi", "Bo Phloi", 14.323610, 99.516110);
        LocationResponseDto expected = new LocationResponseDto(canonicalIp, location.getCityName(),
                location.getCountryCode(), location.getCountryName(), ipInt, location.getLatitude(),
                location.getLongitude(), location.getRegionName());
        LocationMapper mapper = new LocationMapper();
        LocationResponseDto actual = mapper.getLocationResponseDtoFromLocation(location, canonicalIp, ipInt);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkGetLocationResponseDtoFromLocationNotEqual() {
        String canonicalIp = "1.0.136.153";
        int ipInt = 16812185;
        Location location = new Location(16812032, 16812287, "TH", "Thailand",
                "Kanchanaburi", "Bo Phloi", 14.323610, 99.516110);
        LocationResponseDto expected = new LocationResponseDto(canonicalIp, location.getCityName(),
                location.getCountryCode(), location.getCountryName(), ipInt, location.getLatitude(),
                location.getLongitude(), location.getRegionName());
        LocationMapper mapper = new LocationMapper();
        LocationResponseDto actual = mapper.getLocationResponseDtoFromLocation(location, "1.0.0.0", ipInt);
        Assert.assertNotEquals(expected, actual);
    }
}
