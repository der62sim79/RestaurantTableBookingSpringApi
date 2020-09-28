package at.ta.restaurant.booking.api;

import at.ta.restaurant.booking.model.Table;
import at.ta.restaurant.booking.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TablelApiController {
    @Autowired
    private TableRepository tableRepository;

    @GetMapping("/api/table")
    public List<Table> getTable(@RequestParam("table_number") Integer tableNumber){
        return tableRepository.searchByTableNumber(tableNumber);

    }
}
