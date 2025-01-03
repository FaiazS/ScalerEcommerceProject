package services;

import ProductModels.Product;
import com.scaler.ECommerceApplication.Exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById (long id) throws ProductNotFoundException;

    Product addProduct(String title, String description, String image, String category, double price);

}
