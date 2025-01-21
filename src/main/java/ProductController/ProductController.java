package ProductController;

import ProductDataTransferObject.AddProductDTO;
import ProductModels.Product;
import com.scaler.ECommerceApplication.Exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ProductServices.ProductService;
import java.util.List;


@RestController
@RequestMapping("/products")
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

    @GetMapping("products/paginatedProducts")
    Page<Product> getPaginatedProducts(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize){

        return productService.getPaginatedProducts(pageNumber, pageSize);
    }

    // Getting ID of A Single Product

    @GetMapping("/products/{id}")

    public Product getProductById(@PathVariable("id") long id) throws ProductNotFoundException {

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

