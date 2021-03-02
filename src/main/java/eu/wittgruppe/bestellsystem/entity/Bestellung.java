package eu.wittgruppe.bestellsystem.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bestellung {
    String Artikelnummer;
    String Artikelbezeichnung;
    int Bestand;
    float Kosten;
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
