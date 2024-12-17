package ProductDataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class AddProductDTO {

    private String title;
    private String description;
    private String category;
    private String image;
    private double price;

}
