package ProductModels;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass


@Entity
public class ProductCategory extends ProductBaseModel{

    private String name;

    @OneToMany(mappedBy = "productCategory", cascade = CascadeType.REMOVE)
    private List<Product> allProducts;

}

