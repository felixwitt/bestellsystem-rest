package eu.wittgruppe.bestellsystem.service;

import eu.wittgruppe.bestellsystem.entity.Bestellung;
import eu.wittgruppe.bestellsystem.entity.Kunde;
import eu.wittgruppe.bestellsystem.entity.Lager;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

@Service
public class LagerService {

    private static final String DATASET_LAGER = "Lager.csv";

    public List<Lager> getArticles() {
        Hashtable<String, Lager> lagerTable = new Hashtable<>();
        File lagerFile = new File(DATASET_LAGER);
        Lager l;

        try {
            Scanner lagerScanner = new Scanner(lagerFile);
            lagerScanner.next(); // Ignoriert die erste Zeile, da das ja nur die Bezeichner und keine Daten sind
            while (lagerScanner.hasNext()) {
                String row = lagerScanner.next(); // Speichert die komplette nächste Zeile als String
                String[] data = row.split(";"); //Trennt den String anhand der ; in einzelne Datensätze innerhalb eines Arrays

                l = new Lager();
                l.setArtikelnummer(data[0]);
                l.setArtikelbezeichnung(data[1]);
                l.setBestand(Integer.parseInt(data[2]));
                l.setKosten(Float.parseFloat(data[3]));
                lagerTable.put(data[0], l);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fehler bei Lager Try-Catch || FileNotFoundException");
            e.printStackTrace();
        }

        return new ArrayList<>(lagerTable.values());
    }

    public Lager getArticle(String articleNumber) {
        Hashtable<String, Lager> lagerTable = new Hashtable<>();
        File lagerFile = new File(DATASET_LAGER);
        Lager l;

        try {
            Scanner lagerScanner = new Scanner(lagerFile);
            lagerScanner.next(); // Ignoriert die erste Zeile, da das ja nur die Bezeichner und keine Daten sind
            while (lagerScanner.hasNext()) {
                String row = lagerScanner.next(); // Speichert die komplette nächste Zeile als String
                String[] data = row.split(";"); //Trennt den String anhand der ; in einzelne Datensätze innerhalb eines Arrays

                l = new Lager();
                l.setArtikelnummer(data[0]);
                l.setArtikelbezeichnung(data[1]);
                l.setBestand(Integer.parseInt(data[2]));
                l.setKosten(Float.parseFloat(data[3]));
                lagerTable.put(data[0], l);
                if (l.getArtikelnummer().equals(articleNumber)) {
                    return l;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fehler bei Lager Try-Catch || FileNotFoundException");
            e.printStackTrace();
        }

        return null;
    }
}
