package ProductModels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Product {

    private long id;
    private String title;
    private String description;
    private double price;
    private String imageURL;

    private ProductCategory productCategory;

    public Product(long id, String title, String description, double price, String imageURL, ProductCategory productCategory) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.imageURL = imageURL;
        this.productCategory = productCategory;

    }
    public Product(){


    }
    public long getId() {

        return this.id;
    }

    public String getTitle() {

        return this.title;
    }
    public String getDescription() {

        return this.description;
    }

    public double getPrice() {

        return this.price;
    }
    public String getImageURL() {

        return this.imageURL;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public void setPrice(double price){

        this.price = price;
    }

    public void setImageURL(String imageURL){

        this.imageURL = imageURL;
    }

    public void setProductCategory(ProductCategory productcategory){

        this.productCategory = productcategory;
    }

    public ProductCategory getProductCategory(){

        return this.productCategory;
    }
}
