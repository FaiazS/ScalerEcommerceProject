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

}
