package kg.megacom.Salon.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.megacom.Salon.model.Salon;
import kg.megacom.Salon.model.dtos.SalonDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-17T22:53:58+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.16 (Oracle Corporation)"
)
public class SalonMapperImpl implements SalonMapper {

    @Override
    public Salon toEntity(SalonDto d) {
        if ( d == null ) {
            return null;
        }

        Salon salon = new Salon();

        salon.setId( d.getId() );
        salon.setName( d.getName() );
        salon.setAddress( d.getAddress() );

        return salon;
    }

    @Override
    public SalonDto toDto(Salon e) {
        if ( e == null ) {
            return null;
        }

        SalonDto salonDto = new SalonDto();

        salonDto.setId( e.getId() );
        salonDto.setName( e.getName() );
        salonDto.setAddress( e.getAddress() );

        return salonDto;
    }

    @Override
    public List<Salon> toEntities(List<SalonDto> d) {
        if ( d == null ) {
            return null;
        }

        List<Salon> list = new ArrayList<Salon>( d.size() );
        for ( SalonDto salonDto : d ) {
            list.add( toEntity( salonDto ) );
        }

        return list;
    }

    @Override
    public List<SalonDto> toDtos(List<Salon> e) {
        if ( e == null ) {
            return null;
        }

        List<SalonDto> list = new ArrayList<SalonDto>( e.size() );
        for ( Salon salon : e ) {
            list.add( toDto( salon ) );
        }

        return list;
    }
}
