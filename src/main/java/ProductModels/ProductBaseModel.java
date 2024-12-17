package ProductModels;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@MappedSuperclass

@Entity
public class ProductBaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    private Date createdAt;

    private Date lastUpdatedAt;

    private boolean isDeleted;

}


