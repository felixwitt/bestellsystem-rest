package eu.wittgruppe.bestellsystem.service;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import eu.wittgruppe.bestellsystem.entity.Bestellung;
import eu.wittgruppe.bestellsystem.entity.Kunde;
import eu.wittgruppe.bestellsystem.entity.Lager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import org.springframework.stereotype.Service;

@Service
public class BestellungService {

  private static final String DATASET_LAGER = "Lager.csv";
  private static final String DATASET_KUNDE = "Kunden.csv";

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

          // Read existing file
//          CSVReader reader = new CSVReader(new FileReader(kundeFile), ';');
//          List<String[]> csvBody = reader.readAll();
//          // get CSV row column  and replace with by using row and column
//          csvBody.get(3)[0].split(";")[8] = String.valueOf(k.getKontostand() - price);
//          reader.close();
//
//          // Write to CSV file which is open
//          CSVWriter writer = new CSVWriter(new FileWriter(kundeFile));
//          writer.writeAll(csvBody);
//          writer.flush();
//          writer.close();
//          return null;
        }
      }
    } catch (IOException csvException) {
      csvException.printStackTrace();
    }

    return newOrder;
  }
}
