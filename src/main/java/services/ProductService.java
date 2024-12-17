package services;

import ProductDataTransferObject.AddProductDTO;
import ProductModels.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getAllProducts();

    Product getSingleProduct(long id);

    Product addProduct(AddProductDTO addProductDTO);

}
