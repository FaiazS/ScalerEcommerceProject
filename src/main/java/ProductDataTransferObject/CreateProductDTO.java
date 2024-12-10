package ProductDataTransferObject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class CreateProductDTO {

    private String title;
    private String description;
    private String category;
    private String image;
    private double price;

}
