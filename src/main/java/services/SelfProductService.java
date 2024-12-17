package services;

import ProductModels.Product;
import ProductRepository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfProductService implements ProductService {

    private ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository){

        this.productRepository = productRepository;
    }

    @Override

    public Product getSingleProduct(long id){

    }

    @Override

    public List<Product> getAllProducts(){

        List<Product> products = productRepository.findAll();

        return products;
    }

}
