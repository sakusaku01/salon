package kg.megacom.Salon.repository;

import kg.megacom.Salon.model.BookingTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingTimeRepository extends JpaRepository<BookingTime,Long> {
}
