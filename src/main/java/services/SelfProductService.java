package services;

import ProductDataTransferObject.AddProductDTO;
import ProductModels.Product;
import ProductModels.ProductCategory;
import ProductRepository.ProductRepository;
import ProductRepository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Product getProductById(long id){

        return productRepository.findById(id).get();

    }

    @Override

    public List<Product> getAllProducts(){

        List<Product> products = productRepository.findAll();

        return products;
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
