package kg.megacom.Salon.services;


import kg.megacom.Salon.model.dtos.WorkDaysDto;
import kg.megacom.Salon.model.request.ScheduleRequest;

import java.util.List;

public interface WorkDaysServices extends BaseServices<WorkDaysDto>{
    String createSchedule(ScheduleRequest scheduleRequest);
    List<WorkDaysDto> getList();

    List<WorkDaysDto> findGraph(Long id);

    String setSchedule(Long workDayId, Long masterId);

}
