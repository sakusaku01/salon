package kg.megacom.Salon.mapper;

import kg.megacom.Salon.model.Master;
import kg.megacom.Salon.model.dtos.MasterDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MasterMapper extends BaseMapper<Master, MasterDto>{


    MasterMapper INSTANCE = Mappers.getMapper(MasterMapper.class);
}
