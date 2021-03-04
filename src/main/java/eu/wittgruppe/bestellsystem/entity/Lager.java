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
}
