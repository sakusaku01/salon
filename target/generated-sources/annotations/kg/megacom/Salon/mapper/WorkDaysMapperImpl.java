package kg.megacom.Salon.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.megacom.Salon.model.Master;
import kg.megacom.Salon.model.WorkDays;
import kg.megacom.Salon.model.dtos.WorkDaysDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-17T22:54:03+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.16 (Oracle Corporation)"
)
public class WorkDaysMapperImpl implements WorkDaysMapper {

    @Override
    public WorkDays toEntity(WorkDaysDto d) {
        if ( d == null ) {
            return null;
        }

        WorkDays workDays = new WorkDays();

        workDays.setId( d.getId() );
        workDays.setAddDate( d.getAddDate() );
        workDays.setDays( d.getDays() );
        workDays.setStartDate( d.getStartDate() );
        workDays.setEndDate( d.getEndDate() );
        List<Master> list = d.getMasterId();
        if ( list != null ) {
            workDays.setMasterId( new ArrayList<Master>( list ) );
        }

        return workDays;
    }

    @Override
    public WorkDaysDto toDto(WorkDays e) {
        if ( e == null ) {
            return null;
        }

        WorkDaysDto workDaysDto = new WorkDaysDto();

        workDaysDto.setId( e.getId() );
        workDaysDto.setDays( e.getDays() );
        workDaysDto.setAddDate( e.getAddDate() );
        workDaysDto.setStartDate( e.getStartDate() );
        workDaysDto.setEndDate( e.getEndDate() );
        List<Master> list = e.getMasterId();
        if ( list != null ) {
            workDaysDto.setMasterId( new ArrayList<Master>( list ) );
        }

        return workDaysDto;
    }

    @Override
    public List<WorkDays> toEntities(List<WorkDaysDto> d) {
        if ( d == null ) {
            return null;
        }

        List<WorkDays> list = new ArrayList<WorkDays>( d.size() );
        for ( WorkDaysDto workDaysDto : d ) {
            list.add( toEntity( workDaysDto ) );
        }

        return list;
    }

    @Override
    public List<WorkDaysDto> toDtos(List<WorkDays> e) {
        if ( e == null ) {
            return null;
        }

        List<WorkDaysDto> list = new ArrayList<WorkDaysDto>( e.size() );
        for ( WorkDays workDays : e ) {
            list.add( toDto( workDays ) );
        }

        return list;
    }
}
