package at.ta.restaurant.booking.web;


import at.ta.restaurant.booking.model.Table;
import at.ta.restaurant.booking.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("/table")
public class TableController {

    @Autowired
    private TableRepository tableRepository;

    //holt sich das objekt tisch
    @GetMapping("/table")
    public String tableController(Model model){
        Table table = new Table();
        model.addAttribute("table",table);
        return "table";
    }

    //speichert in die Datenbank
    @PostMapping("/table")
    public String tableSubmit(@ModelAttribute Table table, Model model){
        tableRepository.save(table);
        model.addAttribute("table", table);
        return "result";
    }

    //einzelne tische anzeigen
    @GetMapping("/table/view")
    public String viewOneTable(@RequestParam("table_number") Integer tableNumber, Model model){
        Table table = tableRepository.getOne(tableNumber);
        model.addAttribute("table", table);
        return "result";
    }
}
