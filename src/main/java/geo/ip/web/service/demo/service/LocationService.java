package geo.ip.web.service.demo.service;

import geo.ip.web.service.demo.model.Location;
import geo.ip.web.service.demo.repository.LocationRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    private static final Logger LOGGER = Logger.getLogger(LocationService.class);
    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    public void addLocationToTheDatabase(Location location) {
        repository.save(location);
        LOGGER.info("New Location with id = " + location.getLocationId() + " has been added to the database");
    }

    public Location getLocationByCanonicalIp(int ip) {
        return repository.findLocationByIp(ip).orElseThrow(() -> new IllegalArgumentException("Wrong ip provided: " +
                "there is no location found in the database with the ip address provided"));
    }
}
