package ProductController;

import ProductDataTransferObject.AddProductDTO;
import ProductModels.Product;
import com.scaler.ECommerceApplication.Exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import services.ProductService;
import java.util.List;


@RestController
public class ProductController {

    private ProductService productService;

    private ProductController(@Qualifier("SelfProductService") ProductService productService) {

        this.productService = productService;
    }

      //Getting All products

    @GetMapping("/products")

    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    // Getting ID of A Single Product

    @GetMapping("/products/{id}")

    public Product getSingleProduct(@PathVariable("id") long id) throws ProductNotFoundException {

        return productService.getProductById(id);
    }

    // Adding a new Product

    // All Create Product methods should be void ,

    //however we are giving return type Product for Testing purposes  to

    // see if the method is working as intended

    @PostMapping("/products")

    public Product addProduct(@RequestBody AddProductDTO addProductDTO){

        Product product = productService.addProduct(addProductDTO.getTitle(),
                                                    addProductDTO.getDescription(),
                                                    addProductDTO.getImage(),
                                                    addProductDTO.getCategory(),
                                                    addProductDTO.getPrice());


        return product;
    }
    }

