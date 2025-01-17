package ProductServices;

import ProductModels.Product;
import ProductModels.ProductCategory;
import ProductRepository.ProductRepository;
import ProductRepository.CategoryRepository;
import com.scaler.ECommerceApplication.Exceptions.ProductNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class SelfProductService implements ProductService {

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {

        this.productRepository = productRepository;

        this.categoryRepository = categoryRepository;

    }
    @Override

    public Product getProductById (long id) throws ProductNotFoundException{

        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){

            throw new ProductNotFoundException("Product not found");
        }

        else{

            return optionalProduct.get();
        }
    }

    @Override

    public List<Product> getAllProducts(){

        List<Product> products = productRepository.findAll();

        return products;
    }

    public Page<Product> getPaginatedProducts(int pageNumber, int pageSize) { //ProductController Class will provide page number and page size.

           return productRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("name").ascending().and(Sort.by("price").descending())));

    }

    @Override
    public Product addProduct(String title, String description, String image, String category,double price){

        Product product1 = new Product();

        product1.setName(title);

        product1.setDescription(description);

        product1.setImageURL(image);

        product1.setPrice(price);

        ProductCategory existingCategory = categoryRepository.findByName(category);

        if(existingCategory == null) {

            ProductCategory productCategory = new ProductCategory();

            productCategory.setName(category);

            product1.setProductCategory(productCategory);
        }
        else {

            product1.setProductCategory(existingCategory);

        }

        Product recentlyAddedProduct = productRepository.save(product1);

        return recentlyAddedProduct;

    }
}
