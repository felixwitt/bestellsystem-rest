package eu.wittgruppe.bestellsystem.service;

import eu.wittgruppe.bestellsystem.entity.Kunde;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

@Service
public class KundeService {

    private static final String DATASET_KUNDE = "Kunden.csv";

    public Kunde getKunde(String email) {
        Hashtable<String, Kunde> kundeTable = new Hashtable<>();
        File kundeFile = new File(DATASET_KUNDE);
        Kunde k = null;

        try {
            Scanner kundeScanner = new Scanner(kundeFile);
            kundeScanner.next(); // Ignoriert die erste Zeile, da das ja nur die Bezeichner und keine Daten sind
            while (kundeScanner.hasNext()) {
                String row = kundeScanner.next(); // Speichert die komplette nächste Zeile als String
                String[] data = row.split(";"); //Trennt den String anhand der ; in einzelne Datensätze innerhalb eines Arrays

                k = new Kunde();
                k.setKundennummer(data[0]);
                k.setVorname(data[1]);
                k.setNachname(data[2]);
                k.setStraße(data[3]);
                k.setHausnummer(data[4]);
                k.setPLZ(data[5]);
                k.setStadt(data[6]);
                k.setLand(data[7]);
                k.setKontostand(Float.parseFloat(data[8]));
                k.setEmail(data[9]);
                kundeTable.put(data[0], k);
                if (email.equals(k.getEmail())) {
                    return k;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fehler bei Kunde Try-Catch || FileNotFoundException");
            e.printStackTrace();
        }
        return k;
    }

}
