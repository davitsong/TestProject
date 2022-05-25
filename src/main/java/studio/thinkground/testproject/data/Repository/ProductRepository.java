package studio.thinkground.testproject.data.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studio.thinkground.testproject.data.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
}
