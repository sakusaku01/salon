package kg.megacom.Salon.services.impl;

import kg.megacom.Salon.mapper.BookingTimeMapper;
import kg.megacom.Salon.model.dtos.BookingTimeDto;
import kg.megacom.Salon.repository.BookingTimeRepository;
import kg.megacom.Salon.services.BookingTimeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingTimeServicesImpl implements BookingTimeServices {

    @Autowired
    private BookingTimeRepository rep;

    @Override
    public BookingTimeDto save(BookingTimeDto bookingTimeDto) {
        return BookingTimeMapper.INSTANCE.toDto(rep.save(BookingTimeMapper.INSTANCE.toEntity(bookingTimeDto)));
    }

    @Override
    public BookingTimeDto findById(Long id) {
        return BookingTimeMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(()->new RuntimeException("Не найден booking с таким id")));
    }

    @Override
    public List<BookingTimeDto> findAll() {
        return BookingTimeMapper.INSTANCE.toDtos(rep.findAll());
    }
}
