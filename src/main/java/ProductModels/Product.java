package ProductModels;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
public class Product extends ProductBaseModel {


    private String name;
    private String description;
    private double price;
    private String imageURL;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private ProductCategory productCategory;

}
