package geo.ip.web.service.demo.controller;

import geo.ip.web.service.demo.converter.Converter;
import geo.ip.web.service.demo.dto.LocationResponseDto;
import geo.ip.web.service.demo.mapper.LocationMapper;
import geo.ip.web.service.demo.model.Location;
import geo.ip.web.service.demo.parser.Parser;
import geo.ip.web.service.demo.service.LocationService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/geoip")
public class GeoIpController {
    @Value("${filepath}")
    private String path;
    private final Converter converter;
    private final LocationService service;
    private final LocationMapper mapper;
    private final Parser parser;

    public GeoIpController(Converter converter, LocationService service, LocationMapper mapper, Parser parser) {
        this.converter = converter;
        this.service = service;
        this.mapper = mapper;
        this.parser = parser;
    }

    @GetMapping
    @RequestMapping("/{ip:.+}")
    public LocationResponseDto getLocationByIp(@PathVariable("ip") String ip) {
        int ipConverted = converter.convertIpToInt(ip);
        Location location = service.getLocationByCanonicalIp(ipConverted);
        return mapper.getLocationResponseDtoFromLocation(location, ip, ipConverted);
    }

    @PostConstruct
    private void parseLocations() {
        parser.parse(path);
    }
}
