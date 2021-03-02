package eu.wittgruppe.bestellsystem.service;

import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;
import eu.wittgruppe.bestellsystem.entity.Bestellung;
import eu.wittgruppe.bestellsystem.entity.Kunde;
import eu.wittgruppe.bestellsystem.entity.Lager;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

@Service
public class LagerService {

    private static final String DATASET_LAGER = "D:/SWE/Git/bestellsystem-rest/Lager.csv";
    private static final String DATASET_KUNDE = "D:/SWE/Git/bestellsystem-rest/Kunden.csv";

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

    public List<Bestellung> newOrder(List<Bestellung> newOrder) {
        Hashtable<String, Lager> lagerTable = new Hashtable<>();
        File lagerFile = new File(DATASET_LAGER);
        Lager l;

        Hashtable<String, Kunde> kundeTable = new Hashtable<>();
        File kundeFile = new File(DATASET_KUNDE);
        Kunde k = null;

        try {
            Scanner kundeScanner = new Scanner(kundeFile);
            kundeScanner.next(); // Ignoriert die erste Zeile, da das ja nur die Bezeichner und keine Daten sind
            while (kundeScanner.hasNext()) {
                String row = kundeScanner.next(); // Speichert die komplette nächste Zeile als String
                String[] data = row.split(";"); //Trennt den String anhand der ; in einzelne Datensätze innerhalb eines Arrays

                double price = 0;

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
                if (newOrder.get(0).getEmail().equals(k.getEmail())) {
                    for (int i = 0; i <= newOrder.size() - 1; i++) {
                        price += newOrder.get(i).getKosten();
                    }
//                    k.setKontostand(CsvWriter.replace(k.getKontostand(), price));
                }
            }

            System.out.println(k);

        } catch (FileNotFoundException e) {
            System.out.println("Fehler bei Lager Try-Catch || FileNotFoundException");
            e.printStackTrace();
        }

        return newOrder;
    }
}
