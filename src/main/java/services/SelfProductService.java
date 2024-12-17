package services;

import ProductModels.Product;
import ProductRepository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class SelfProductService implements ProductService {

    private ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository){

        this.productRepository = productRepository;
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

}
