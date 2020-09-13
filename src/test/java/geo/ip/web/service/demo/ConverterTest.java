package geo.ip.web.service.demo;

import geo.ip.web.service.demo.converter.Converter;
import org.junit.Assert;
import org.junit.Test;

public class ConverterTest {
    @Test
    public void converterCheck() {
        Converter converter = new Converter();
        String ip = "8.8.8.8";
        int actual = 134744072;
        int expected = converter.convertIpToInt(ip);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NumberFormatException.class)
    public void converterWrongIpFormatUsingLetters() {
        Converter converter = new Converter();
        String ip = "a.b.c.d";
        int actual = 134744072;
        int expected = converter.convertIpToInt(ip);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NumberFormatException.class)
    public void converterWrongIpFormatUsingLessNumbers() {
        Converter converter = new Converter();
        String ip = "8.8.8";
        int actual = 134744072;
        int expected = converter.convertIpToInt(ip);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NumberFormatException.class)
    public void converterWrongIpFormatUsingThreeSectionsOnly() {
        Converter converter = new Converter();
        String ip = "192.28.35";
        int actual = 134744072;
        int expected = converter.convertIpToInt(ip);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NumberFormatException.class)
    public void converterWrongIpFormatUsingFiveSectionsOnly() {
        Converter converter = new Converter();
        String ip = "8.8.8.8.8";
        int actual = 134744072;
        int expected = converter.convertIpToInt(ip);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NumberFormatException.class)
    public void converterWrongIpFormatUsingZerosOnly() {
        Converter converter = new Converter();
        String ip = "0.0.0.0";
        int actual = 0;
        int expected = converter.convertIpToInt(ip);
        Assert.assertEquals(expected, actual);
    }
}
