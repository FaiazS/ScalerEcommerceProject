package ProductRepository;

import ProductModels.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<ProductCategory, Long> {

     ProductCategory findByName(String name);

}
