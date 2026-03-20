package pl.coderslab.model;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProductDao {
    private final List<Product> products = Arrays.asList(
            new Product(1, "Kawa", 30.1),
            new Product(2, "Chleb", 8.5),
            new Product(3, "Mleko", 3.59),
            new Product(4, "Ser", 11.99),
            new Product(5, "Jajka", 15.29),
            new Product(6, "Wino", 49.9),
            new Product(7, "Makaron", 11.99)
    );

    public List<Product> getList() {
        return products;
    }
}
