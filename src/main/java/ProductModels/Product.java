package ProductModels;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;




@Entity
public class Product extends ProductBaseModel{


    private String name;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    private String description;

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    private double price;

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    private String imageURL;

    public String getImageURL() {

        return imageURL;
    }

    public void setImageURL(String imageURL) {

        this.imageURL = imageURL;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    private ProductCategory productCategory;

    public ProductCategory getProductCategory() {

        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {

        this.productCategory = productCategory;
    }
}
