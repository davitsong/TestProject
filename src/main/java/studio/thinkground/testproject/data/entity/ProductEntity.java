package studio.thinkground.testproject.data.entity;


import lombok.*;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import studio.thinkground.testproject.data.dto.ProductDTO;
import javax.persistence.*;

@Entity //Entity로 사용
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid",strategy="uuid")
    String productId;
    String productName;
    Integer productPrice;
    Integer productStock;

}
