package kg.megacom.Salon.repository;

import kg.megacom.Salon.model.WorkDays;
import kg.megacom.Salon.model.dtos.WorkDaysDto;
import kg.megacom.Salon.repository.response.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface WorkDaysRepository extends JpaRepository<WorkDays,Long> {

    @Modifying
    @Transactional
    @Query(value = "insert into tb_work_day_master(work_day_id,master_id) VALUES(?1,?2)",nativeQuery = true)
    int create(Long workDayId,Long masterId);
    @Modifying
    @Transactional
    @Query(value ="select * from tb_work_days da join tb_work_day_master twdb on da.id = twdb.work_day_id where twdb.master_id = ?1",nativeQuery = true)
    List<WorkDays> findWorkDaysByMasterIds(Long id);



}
