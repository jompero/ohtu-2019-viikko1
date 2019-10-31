package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void constructor() {
        new Varasto(1d, 1d);
    }

    @Test
    public void constructorExcess() {
        new Varasto(1d, 2d);
    }

    @Test
    public void constructorUseless() {
        new Varasto(-1d, -1d);
    }

    @Test
    public void constructorSingleParameter() {
        new Varasto(-1d);
    }

    @Test
    public void fillNegative() {
        varasto.lisaaVarastoon(3d);
        varasto.lisaaVarastoon(-1d);
        assertEquals(3d, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void fillTooMuch() {
        varasto.lisaaVarastoon(20d);
        assertEquals(10d, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void takeNegative() {
        varasto.lisaaVarastoon(5d);
        varasto.otaVarastosta(-5d);
        assertEquals(5d, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void giveMeEverything() {
        varasto.lisaaVarastoon(10d);
        assertEquals(10d, varasto.otaVarastosta(20d), vertailuTarkkuus);
    }

    @Test
    public void toStringTest() {
        assertEquals("saldo = 0.0, vielä tilaa 10.0", varasto.toString());
    }
}