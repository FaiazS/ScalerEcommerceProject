package ProductController;

import ProductDataTransferObject.CreateProductDTO;
import ProductModels.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import services.ProductService;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;
    }

      //Getting all products

    @GetMapping("/products")

    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    // Getting ID of a Single Product
    @GetMapping("/products/{id}")

    public Product getSingleProduct(@PathVariable("id") long id){

        return productService.getSingleProduct(id);
    }

    // Create a new Product
    @PostMapping("/products/")

    public void createProduct(CreateProductDTO createProductDTO){

        productService.createProduct(createProductDTO);

    }
}
