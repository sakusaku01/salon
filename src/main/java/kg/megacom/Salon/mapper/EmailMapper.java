package kg.megacom.Salon.mapper;

import kg.megacom.Salon.model.Email;

import kg.megacom.Salon.model.dtos.EmailDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmailMapper extends BaseMapper<Email, EmailDto>{

    EmailMapper INSTANCE = Mappers.getMapper(EmailMapper.class);
}
