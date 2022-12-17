package kg.megacom.Salon.repository;

import kg.megacom.Salon.model.BookingTime;
import kg.megacom.Salon.model.dtos.BookingTimeDto;
import kg.megacom.Salon.model.request.BookingRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookingTimeRepository extends JpaRepository<BookingTime,Long> {
    @Modifying
    @Transactional
    @Query(value = "select * from tb_booking_time b " +
            "join tb_work_day_booking twdb on b.id = twdb.booking_id join tb_work_day_master twdm on twdb.work_day_id = twdm.work_day_id where twdm.master_id=?1",nativeQuery = true)
    List<BookingTime> findBookingTimeByMaster(Long masterId);
}
