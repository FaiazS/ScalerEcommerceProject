package services;

import ProductDataTransferObject.AddProductDTO;
import ProductModels.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(long id);

    void addProduct(AddProductDTO addProductDTO);

}
