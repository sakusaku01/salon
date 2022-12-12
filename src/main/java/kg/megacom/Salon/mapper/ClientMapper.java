package kg.megacom.Salon.mapper;

import kg.megacom.Salon.model.Client;
import kg.megacom.Salon.model.dtos.ClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper extends BaseMapper<Client, ClientDto>{


    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);


}
