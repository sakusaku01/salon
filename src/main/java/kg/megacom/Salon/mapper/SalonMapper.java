package kg.megacom.Salon.mapper;

import kg.megacom.Salon.model.Salon;
import kg.megacom.Salon.model.dtos.SalonDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SalonMapper extends BaseMapper<Salon, SalonDto>{

    SalonMapper INSTANCE = Mappers.getMapper(SalonMapper.class);

}
