package kg.megacom.Salon.services;

import kg.megacom.Salon.model.dtos.BookingTimeDto;
import kg.megacom.Salon.model.request.BookingRequestDto;
import kg.megacom.Salon.model.request.RequestDto;

import java.util.Date;
import java.util.List;

public interface BookingTimeServices extends BaseServices<BookingTimeDto>{
    String saveCheck(RequestDto requestDto);

    boolean checkStart(Date startDate, Date masterStartDate);

    Boolean checkEnd(Date endDate, Date masterEndDate);

    List<BookingTimeDto> masterBookingCheck(Long masterId);

}
