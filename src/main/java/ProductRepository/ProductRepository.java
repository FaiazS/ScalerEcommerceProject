package ProductRepository;

import ProductModels.Product;
import ProductModels.ProductCategory;
import com.scaler.ECommerceApplication.ProductProjections.GetProductWithIdAndPriceProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override

    List<Product>findAll();

    Product save(Product product);

    @Override
    Optional<Product> findById(Long id);

    List<Product> findAllProductByProductCategory(ProductCategory productCategory);

    List<Product> findAllProductsByProductCategoryName(String name);

    List<Product> findAllProductsByProductCategoryID(Long id);

    List<Product> findByProductNameStartingWithAndIDEqualsAndPriceMoreThan(String productName, Long idEquals, Double priceMoreThan);

    @Query("SELECT p.id, p.price FROM Product p WHERE p.productCategory.name = :productCategoryName")

    List<GetProductWithIdAndPriceProjection> getProductWithIdAndPriceProjectionOnGivenCategoryName(@Param("productCategoryName") String productCategoryName);


    @Query(value = "SELECT p.id, p.price FROM Product p where givenTitle = :givenTitle ", nativeQuery = true)

    List<GetProductWithIdAndPriceProjection> getIdAndPricesOfAllProductsWithGivenTitle(@Param("givenTitle") String givenTitle);
}
