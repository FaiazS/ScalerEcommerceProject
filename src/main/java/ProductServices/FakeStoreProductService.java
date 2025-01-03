package ProductServices;

import ProductDataTransferObject.FakeStoreProductDTO;
import ProductModels.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service

public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    @Override

    // Retrieving the list of all Products in Catalogue

    public List<Product> getAllProducts(){

        FakeStoreProductDTO fakeStoreProductDTOtoArray [] = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDTO[].class);

        List<Product> Products = new ArrayList<>();

        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOtoArray){

            Product product = fakeStoreProductDTO.toProduct();

            Products.add(product);
        }
        return Products;
    }

    // Retrieving a Single Product from the Catalogue
    @Override
    public Product getProductById(long id){

        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class);

        return fakeStoreProductDTO.toProduct();
    }

    @Override

    //Adding a New Product in Catalogue

    public Product addProduct(String title,String description, String image, String category, double price){


        return null;
    }
}
