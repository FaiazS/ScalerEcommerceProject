package services;

import ProductDataTransferObject.AddProductDTO;
import ProductModels.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(long id);

    Product addProduct(String title, String description, String image, String category, double price);

}
