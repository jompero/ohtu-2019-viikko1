package main;

import ohtu.ohtuvarasto.*;

public class Main {

    static Varasto mehua = new Varasto(100.0);
    static Varasto olutta = new Varasto(100.0, 20.2);

    public static void main(String[] args) {
        alkuTilanne();
        olutgetterit();
        mehusetterit();
        virhetilanteet();
        lisaaOlutvarastoon(1000.0);
        lisaaMehuvarastoon(-666.0);
        otaOlutvarastosta(1000.0);
        otaMehuvarastosta(-32.9);
    }

    private static void alkuTilanne() {
        System.out.println("Luonnin jälkeen:");
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("Olutvarasto: " + olutta);
    }

    private static void olutgetterit() {
        System.out.println("Olutgetterit:");
        System.out.println("getSaldo()     = " + olutta.getSaldo());
        System.out.println("getTilavuus    = " + olutta.getTilavuus());
        System.out.println("paljonkoMahtuu = " + olutta.paljonkoMahtuu());
    }

    private static void mehusetterit() {
        System.out.println("Mehusetterit:");
        System.out.println("Lisätään 50.7");
        mehua.lisaaVarastoon(50.7);
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("Otetaan 3.14");
        mehua.otaVarastosta(3.14);
        System.out.println("Mehuvarasto: " + mehua);
    }

    private static void virhetilanteet() {
        System.out.println("Virhetilanteita:");
        System.out.println("new Varasto(-100.0);");
        Varasto huono = new Varasto(-100.0);
        System.out.println(huono);

        System.out.println("new Varasto(100.0, -50.7)");
        huono = new Varasto(100.0, -50.7);
        System.out.println(huono);
    }

    private static void olutvarastoTila() {
        System.out.println("Olutvarasto: " + olutta);
    }

    private static void mehuvarastoTila() {
        System.out.println("Mehuvarasto: " + mehua);
    }

    private static void lisaaOlutvarastoon(double amount) {
        olutvarastoTila();
        System.out.println(String.format("olutta.lisaaVarastoon(%f)", amount));
        olutta.lisaaVarastoon(amount);
        olutvarastoTila();
    }

    private static void lisaaMehuvarastoon(double amount) {
        mehuvarastoTila();
        System.out.println(String.format("mehua.lisaaVarastoon(%f)", amount));
        mehua.lisaaVarastoon(amount);
        mehuvarastoTila();
    }

    private static void otaOlutvarastosta(double amount) {
        olutvarastoTila();
        System.out.println(String.format("olutta.otaVarastosta(%f)", amount));
        System.out.println("saatiin " + olutta.otaVarastosta(amount));
        olutvarastoTila();
    }

    private static void otaMehuvarastosta(double amount) {
        mehuvarastoTila();
        System.out.println(String.format("mehua.otaVarastosta(%f)", amount));
        System.out.println("saatiin " + mehua.otaVarastosta(amount));
        mehuvarastoTila();
    }

    private static void breakingBad() 
    {
        System.out.println("lol");
    }
}
