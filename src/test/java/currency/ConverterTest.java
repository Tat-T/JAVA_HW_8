package currency;

import org.example.currency.Converter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterTest {

    @Test
    public void testUsdToEur() {
        Converter converter = new Converter();
        double result = converter.convert(100, Converter.Currency.USD, Converter.Currency.EUR);
        assertEquals(90.0, result, 0.001);
    }

    @Test
    public void testEurToUsd() {
        Converter converter = new Converter();
        double result = converter.convert(90, Converter.Currency.EUR, Converter.Currency.USD);
        assertEquals(100.0, result, 0.001);
    }

    @Test
    public void testGbpToJpy() {
        Converter converter = new Converter();
        double result = converter.convert(80, Converter.Currency.GBP, Converter.Currency.JPY);
        assertEquals(11000.0, result, 0.001);
    }

    @Test
    public void testSameCurrency() {
        Converter converter = new Converter();
        double result = converter.convert(50, Converter.Currency.JPY, Converter.Currency.JPY);
        assertEquals(50.0, result, 0.001);
    }
}
