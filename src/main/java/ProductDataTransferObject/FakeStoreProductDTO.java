package ProductDataTransferObject;

import ProductModels.Product;
import ProductModels.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class FakeStoreProductDTO {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

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
