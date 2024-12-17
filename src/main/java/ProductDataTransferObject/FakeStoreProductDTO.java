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

        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);

        ProductCategory category = new ProductCategory();

        category.setTitle(title);
        product.setProductCategory(category);

        product.setImageURL(image);

        return product;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public void setImage(String image) {

        this.image = image;
    }
    public void setCategory(String category) {

        this.category = category;

    }
    public void setPrice(double price) {

        this.price = price;
    }

    public String getTitle(){

        return this.title;
    }

    public String getDescription(){

        return this.description;
    }

    public String getImage(){

        return this.image;
    }
    public String getCategory(){

        return this.category;
    }

    public double getPrice(){

        return this.price;
    }
}
