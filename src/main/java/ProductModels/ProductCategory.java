package ProductModels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductCategory {

    private long id;
    private String title;

    public ProductCategory(long id, String title){

        this.id = id;
        this.title = title;
    }

    public ProductCategory(){

    }
    public void setId(long id){

        this.id = id;
    }
    public void setTitle(String title){

        this.title = title;
    }

    public long getId(){

        return this.id;
    }

    public String getTitle(){

        return this.title;
    }
}
