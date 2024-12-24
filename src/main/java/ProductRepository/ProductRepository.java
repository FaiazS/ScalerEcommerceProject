package ProductRepository;

import ProductModels.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override

   public List<Product>findAll();

    Product save(Product p);
}
