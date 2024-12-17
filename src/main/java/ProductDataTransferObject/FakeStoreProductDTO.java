package ProductDataTransferObject;

import ProductModels.Product;
import ProductModels.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FakeStoreProductDTO {

    private String title;
    private String description;
    private String image;
    private String category;
    private double price;

    public Product toProduct(){

        Product product = new Product();

        product.setName(title);
        product.setDescription(description);
        product.setPrice(price);

        ProductCategory category = new ProductCategory();

        category.setName(this.category);
        product.setProductCategory(category);

        product.setImageURL(image);

        return product;
    }
}
