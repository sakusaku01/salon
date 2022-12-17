package kg.megacom.Salon.mapper;

import kg.megacom.Salon.model.BookingTime;
import kg.megacom.Salon.model.request.BookingRequestDto;
import org.mapstruct.factory.Mappers;

public interface BookingRequestMapper extends BaseMapper<BookingTime, BookingRequestDto>{
    BookingTimeMapper INSTANCE = Mappers.getMapper(BookingTimeMapper.class);

}
