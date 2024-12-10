package services;

import ProductDataTransferObject.CreateProductDTO;
import ProductDataTransferObject.FakeStoreProductDTO;
import ProductModels.Product;
import org.springframework.stereotype.Service;
import RESTConfigurations.RESTTemplates;
import org.springframework.web.client.RestTemplate;

import java.security.PublicKey;
import java.util.List;

@Service

public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    @Override

    public List<Product> getAllProducts(){

        return List.of();

    }

    // Calling Third Party API

    public Product getProductById(long id){

        FakeStoreProductDTO fakeStoreProductDTO = RestTemplate.getForObject("https://fakestoreapi.com/products/", FakeStoreProductDTO.class);

        return fakeStoreProductDTO.toProduct();
    }

    @Override

    // Default Constructor

    public void CreateProduct(CreateProductDTO createProductDTO){


    }
}
