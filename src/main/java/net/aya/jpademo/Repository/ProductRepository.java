package net.aya.jpademo.Repository;

import net.aya.jpademo.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
//public List<Product> findByNameContains("m");
List<Product> findByNameContainsIgnoreCase(String kw);
//public List<Product> findByNameContainsIgnoreCaseAndPriceGreaterThan(String kw, double price); or
    @Query("select p from Product p where p.name like %:nc% and p.price>:price")
    public List<Product> search(@Param("mc") String kw,@Param("p") double price);
}

