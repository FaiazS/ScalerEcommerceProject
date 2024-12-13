package ProductController;

import ProductDataTransferObject.CreateProductDTO;
import ProductModels.Product;
import org.springframework.web.bind.annotation.*;
import services.ProductService;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;
    }

      //Getting All products

    @GetMapping("/products")

    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    // Getting ID of A Single Product

    @GetMapping("/products/{id}")

    public Product getSingleProduct(@PathVariable("id") long id){

        return productService.getSingleProduct(id);
    }

    // Creating or Adding  a new Product

    // All Create Product methods should be void ,

    //however we are giving return type Product for Testing purposes  to

    // see if the method is working as intended

    @PostMapping("/products/")

    public Product createProduct(@RequestBody()CreateProductDTO createProductDTO){

        return productService.createProduct(createProductDTO);

    }
}
