package kg.megacom.Salon.repository;

import kg.megacom.Salon.model.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonRepository extends JpaRepository<Salon,Long> {
}
