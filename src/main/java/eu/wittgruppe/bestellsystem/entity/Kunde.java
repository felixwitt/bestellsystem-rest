package eu.wittgruppe.bestellsystem.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Kunde {
    String Kundennummer;
    String Vorname;
    String Nachname;
    String Straße;
    String Hausnummer;
    String PLZ;
    String Stadt;
    String Land;
    float Kontostand;
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKundennummer() {
        return Kundennummer;
    }

    public void setKundennummer(String kundennummer) {
        Kundennummer = kundennummer;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) {
        Nachname = nachname;
    }

    public String getStraße() {
        return Straße;
    }

    public void setStraße(String straße) {
        Straße = straße;
    }

    public String getHausnummer() {
        return Hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        Hausnummer = hausnummer;
    }

    public String getPLZ() {
        return PLZ;
    }

    public void setPLZ(String PLZ) {
        this.PLZ = PLZ;
    }

    public String getStadt() {
        return Stadt;
    }

    public void setStadt(String stadt) {
        Stadt = stadt;
    }

    public String getLand() {
        return Land;
    }

    public void setLand(String land) {
        Land = land;
    }

    public float getKontostand() {
        return Kontostand;
    }

    public void setKontostand(float kontostand) {
        Kontostand = kontostand;
    }
}
