package ProductServices;

import ProductDataTransferObject.FakeStoreProductDTO;
import ProductModels.Product;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service

public abstract class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;
    private RedisTemplate<String, Object> redisTemplate;

    public FakeStoreProductService(RestTemplate restTemplate, RedisTemplate<String, Object> redisTemplate) {

        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
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

        Product cachedProduct = (Product) redisTemplate.opsForHash().get("Products","Products_" + id);

        if(!cachedProduct.equals(null)){

            return cachedProduct;

        }

        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class);

        Product retrievedProduct = fakeStoreProductDTO.toProduct();

        redisTemplate.opsForHash().put("Products","Products" + id, retrievedProduct);

        return retrievedProduct;

    }

    @Override

    //Adding a New Product in Catalogue

    public Product addProduct(String title,String description, String image, String category, double price){


        return null;
    }
}
