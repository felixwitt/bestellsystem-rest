package eu.wittgruppe.bestellsystem.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lager {
    String Artikelnummer;
    String Artikelbezeichnung;
    int Bestand;
    float Kosten;

    public String getArtikelnummer() {
        return Artikelnummer;
    }

    public void setArtikelnummer(String artikelnummer) {
        Artikelnummer = artikelnummer;
    }

    public String getArtikelbezeichnung() {
        return Artikelbezeichnung;
    }

    public void setArtikelbezeichnung(String artikelbezeichnung) {
        Artikelbezeichnung = artikelbezeichnung;
    }

    public int getBestand() {
        return Bestand;
    }

    public void setBestand(int bestand) {
        Bestand = bestand;
    }

    public float getKosten() {
        return Kosten;
    }

    public void setKosten(float kosten) {
        Kosten = kosten;
    }
}
