package  com.ecom.inventory.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.inventory.entity.InventoryEntity;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity,UUID>{

    InventoryEntity findByProductId(UUID productId);
    Boolean existsByProductId(UUID productId);
    
}
