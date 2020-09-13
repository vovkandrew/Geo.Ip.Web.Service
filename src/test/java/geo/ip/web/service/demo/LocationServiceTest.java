package geo.ip.web.service.demo;

import geo.ip.web.service.demo.model.Location;
import geo.ip.web.service.demo.repository.LocationRepository;
import geo.ip.web.service.demo.service.LocationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LocationServiceTest {
    @Mock
    private LocationRepository repository;

    @InjectMocks
    private LocationService service;

    @Test
    public void checkGetLocationByCanonicalIp(){
        int ip = 16812185;
        Location actual = new Location(55L, 16812032, 16812287, "TH",
                "Thailand", "Kanchanaburi", "Bo Phloi",
                14.323610, 99.516110);
        when(repository.findLocationByIp(ip)).thenReturn(java.util.Optional.of(actual));
        Location expected = service.getLocationByCanonicalIp(ip);
        Assert.assertEquals(expected, actual);
        verify(repository).findLocationByIp(ip);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkGetLocationByCanonicalIpWithWrongIp(){
        int ip = 0;
        Location actual = new Location(55L, 16812032, 16812287, "TH",
                "Thailand", "Kanchanaburi", "Bo Phloi",
                14.323610, 99.516110);
        when(repository.findLocationByIp(0)).thenReturn(java.util.Optional.empty());
        Location expected = service.getLocationByCanonicalIp(ip);
        Assert.assertEquals(expected, actual);
        verify(repository).findLocationByIp(ip);
    }
}
