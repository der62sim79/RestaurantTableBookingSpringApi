package at.ta.restaurant.booking.repository;

import at.ta.restaurant.booking.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TableRepository extends JpaRepository<Table,Integer> {

    // JPQL
    @Query("SELECT t FROM t_table t WHERE t.tableNumber=?1")
    public List<Table> searchByTableNumber(int number);


}
