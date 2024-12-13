package services;

import ProductDataTransferObject.CreateProductDTO;
import ProductModels.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getSingleProduct(long id);

    Product createProduct(CreateProductDTO createProductDTO);
}
