package geo.ip.web.service.demo.mapper;

import geo.ip.web.service.demo.dto.LocationResponseDto;
import geo.ip.web.service.demo.model.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {
    private static final int INT_FROM_POS = 0;
    private static final int INT_TO_POS = 1;
    private static final int COUNTRY_CODE_POS = 2;
    private static final int COUNTRY_NAME_POS = 3;
    private static final int REGION_NAME_POS = 4;
    private static final int CITY_NAME_POS = 5;
    private static final int LATITUDE_POS = 6;
    private static final int LONGITUDE_POS = 7;

    public Location getLocationFromStringArr(String[] arr) {
        Location location = new Location();
        location.setIpFrom(Integer.parseInt(arr[INT_FROM_POS]));
        location.setIpTo(Integer.parseInt(arr[INT_TO_POS]));
        location.setCountryCode(arr[COUNTRY_CODE_POS]);
        location.setCountryName(arr[COUNTRY_NAME_POS]);
        location.setRegionName(arr[REGION_NAME_POS]);
        location.setCityName(arr[CITY_NAME_POS]);
        location.setLatitude(Double.parseDouble(arr[LATITUDE_POS]));
        location.setLongitude(Double.parseDouble(arr[LONGITUDE_POS]));
        return location;
    }

    public LocationResponseDto getLocationResponseDtoFromLocation(Location location, String ip, int convertedIp) {
        LocationResponseDto responseDto = new LocationResponseDto();
        responseDto.setCanonicalIPv4Representation(ip);
        responseDto.setCityName(location.getCityName());
        responseDto.setCountryCode(location.getCountryCode());
        responseDto.setCountryName(location.getCountryName());
        responseDto.setIPv4(convertedIp);
        responseDto.setLatitude(location.getLatitude());
        responseDto.setLongitude(location.getLongitude());
        responseDto.setRegionName(location.getRegionName());
        return responseDto;
    }
}
