package kg.megacom.Salon.repository;

import kg.megacom.Salon.model.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MasterRepository extends JpaRepository<Master,Long> {
    @Query("select m from Master m where m.salonId.id=:salonId")
    List<Master> findBySalon(Long salonId);
}
