package eu.wittgruppe.bestellsystem.controller;

import eu.wittgruppe.bestellsystem.entity.Bestellung;
import eu.wittgruppe.bestellsystem.entity.Kunde;
import eu.wittgruppe.bestellsystem.entity.Lager;
import eu.wittgruppe.bestellsystem.service.KundeService;
import eu.wittgruppe.bestellsystem.service.LagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class BestellsystemController {

    @Autowired
    private KundeService kundeService;

    @Autowired
    private LagerService lagerService;

    @RequestMapping("/test")
    public String kunde() {
        return "Angemeldet";
    }

    @GetMapping("/customer/")
    public Kunde kunde(@RequestParam("email") String email) {
        return kundeService.getKunde(email);
    }

    @PostMapping("/customer/neworder/")
    public List<Bestellung> newOrder(@RequestBody List<Bestellung> orderList) {
        return lagerService.newOrder(orderList);
    }

    @GetMapping("/article/")
    public List<Lager> getArticles() {
        return lagerService.getArticles();
    }

    @GetMapping("/article/{articleNumber}")
    public Lager getArticle(@PathVariable("articleNumber") String articleNumber) {
        return lagerService.getArticle(articleNumber);
    }

}
