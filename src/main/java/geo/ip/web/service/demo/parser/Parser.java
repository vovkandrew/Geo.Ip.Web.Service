package geo.ip.web.service.demo.parser;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import geo.ip.web.service.demo.mapper.LocationMapper;
import geo.ip.web.service.demo.model.Location;
import geo.ip.web.service.demo.repository.LocationRepository;
import java.io.FileReader;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;



@Component
public class Parser {
    private static final int LIMIT_FOR_INCOMING_DATA = 100;
    private static final Logger LOGGER = Logger.getLogger(Parser.class);

    private final LocationMapper mapper;
    private final LocationRepository repository;

    public Parser(LocationMapper mapper, LocationRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public void parse(String path) {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(path));
            reader.readNext();
            String[] row;
            int limit = LIMIT_FOR_INCOMING_DATA;
            while ((row = reader.readNext()) != null && limit > 0) {
                Location location = mapper.getLocationFromStringArr(row);
                repository.save(location);
                limit--;
            }
            LOGGER.info(LIMIT_FOR_INCOMING_DATA + " locations have been successfully added to the database");
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }
    }
}
