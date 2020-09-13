package geo.ip.web.service.demo.converter;

import org.springframework.stereotype.Component;

@Component
public class Converter {
    private static final int BASE = 256;
    private static final int POW = 3;
    private static final int MIN_IP_LENGTH = 7;
    private static final int NUM_OF_SECTIONS = 4;

    public int convertIpToInt(String ip) {
        if (ip.length() < MIN_IP_LENGTH || !ip.matches("^[.0-9]*$")) {
            throw new NumberFormatException("Improper ip format: ip address should be at least " +
                    "7 symbols long and contain only numbers and dots");
        }
        int ipInt = 0;
        String[] arr = ip.split("\\.");
        if (arr.length != NUM_OF_SECTIONS) {
            throw new NumberFormatException("Improper ip format: ip should match this format " +
                    "X.X.X.X where X is a digit");
        }
        for (int i = 0; i < arr.length; i++) {
            ipInt = (int) (ipInt + Integer.parseInt(arr[i]) * (Math.pow(BASE,(POW - i))));
        }
        if (ipInt == 0) {
            throw new NumberFormatException("Improper ip format: ip address should start at least from 1.X.X.X " +
                    "and should contain only zeros");
        }
        return ipInt;
    }
}
