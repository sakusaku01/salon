package kg.megacom.Salon.mapper;

import kg.megacom.Salon.model.WorkDays;
import kg.megacom.Salon.model.dtos.WorkDaysDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WorkDaysMapper extends BaseMapper<WorkDays, WorkDaysDto>{

    WorkDaysMapper INSTANCE = Mappers.getMapper(WorkDaysMapper.class);

}
