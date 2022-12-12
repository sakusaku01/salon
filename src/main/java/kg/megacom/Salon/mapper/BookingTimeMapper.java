package kg.megacom.Salon.mapper;

import kg.megacom.Salon.model.BookingTime;
import kg.megacom.Salon.model.dtos.BookingTimeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface BookingTimeMapper extends BaseMapper<BookingTime, BookingTimeDto>{

    BookingTimeMapper INSTANCE = Mappers.getMapper(BookingTimeMapper.class);
}
