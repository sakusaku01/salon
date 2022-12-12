package kg.megacom.Salon.services.impl;

import kg.megacom.Salon.mapper.WorkDaysMapper;
import kg.megacom.Salon.model.dtos.WorkDaysDto;
import kg.megacom.Salon.model.request.ScheduleRequest;
import kg.megacom.Salon.repository.WorkDaysRepository;
import kg.megacom.Salon.services.WorkDaysServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkDaysServicesImpl implements WorkDaysServices {

    @Autowired
    private WorkDaysRepository workDaysRepository;

    @Override
    public WorkDaysDto save(WorkDaysDto workDaysDto) {
        return WorkDaysMapper.INSTANCE.toDto(workDaysRepository.save(WorkDaysMapper.INSTANCE.toEntity(workDaysDto)));
    }

    @Override
    public WorkDaysDto findById(Long id) {
        return WorkDaysMapper.INSTANCE.toDto(workDaysRepository.findById(id).orElseThrow
                (()->new RuntimeException("Не найден день с таким id")));
    }

    @Override
    public List<WorkDaysDto> findAll() {
        return WorkDaysMapper.INSTANCE.toDtos(workDaysRepository.findAll());
    }


    @Override
    public String createSchedule(ScheduleRequest scheduleRequest) {
        WorkDaysDto dto=new WorkDaysDto();
        dto.setDays(scheduleRequest.getDays());
        dto.setStartDate(scheduleRequest.getStartDate());
        dto.setEndDate(scheduleRequest.getEndDate());
        save(dto);
        return "Success";
    }

    @Override
    public List<WorkDaysDto> getList() {
        List<WorkDaysDto> dayDtos=findAll();
        System.out.println(dayDtos);
        return dayDtos;
    }

    @Override
    public List<WorkDaysDto> findGraph(Long id) {
        return WorkDaysMapper.INSTANCE.toDtos(workDaysRepository.findWorkDaysByMasterIds(id));
    }


    @Override
    public String setSchedule(Long workDayId, Long masterId) {
        int result=workDaysRepository.create(workDayId,masterId);
        System.out.println(result);
        return "Success";
    }
}
