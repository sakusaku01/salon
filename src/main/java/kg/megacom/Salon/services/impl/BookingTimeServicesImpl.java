package kg.megacom.Salon.services.impl;

import kg.megacom.Salon.mapper.BookingTimeMapper;
import kg.megacom.Salon.mapper.ClientMapper;
import kg.megacom.Salon.mapper.WorkDaysMapper;
import kg.megacom.Salon.model.dtos.BookingTimeDto;
import kg.megacom.Salon.model.dtos.WorkDaysDto;
import kg.megacom.Salon.model.enums.Status;
import kg.megacom.Salon.model.request.RequestDto;
import kg.megacom.Salon.repository.BookingTimeRepository;

import kg.megacom.Salon.services.BookingTimeServices;
import kg.megacom.Salon.services.EmailSenderServices;
import kg.megacom.Salon.services.WorkDaysServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingTimeServicesImpl implements BookingTimeServices {

    @Autowired
    private EmailSenderServices mail;
    private final BookingTimeRepository rep;
    private final WorkDaysServices workDaysServices;


    @Autowired
    public BookingTimeServicesImpl(BookingTimeRepository rep, WorkDaysServices workDaysServices) {
        this.rep = rep;
        this.workDaysServices = workDaysServices;
    }


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



    @Override
    public String saveCheck(RequestDto requestDto) {
        List<WorkDaysDto> workDaysDto =workDaysServices.findGraph(requestDto.getMasterId().getId());

        if(!checkStart(requestDto.getStartDate(),workDaysDto.get(requestDto.getIndex()).getStartDate())) {
            return "Мастер не начал еще работу";
        }
        if(!checkEnd(requestDto.getEndDate(),workDaysDto.get(requestDto.getIndex()).getEndDate())) {
            return "Мастер уже закончил работу";
        }

        if(!checkBooking(requestDto)){
            throw  new RuntimeException("Окошко занята");
        }else if(checkBooking(requestDto)){
            BookingTimeDto bookingTimeDto = new BookingTimeDto();
            bookingTimeDto.setBookingStatus(Status.SUSPEND);
            bookingTimeDto.setStartDate(requestDto.getStartDate());
            bookingTimeDto.setEndDate(requestDto.getEndDate());
            bookingTimeDto.setAddDate(new Date());
            bookingTimeDto.setClientId(ClientMapper.INSTANCE.toDto(requestDto.getClientId()));
            bookingTimeDto.setUpdateDate(new Date());
            bookingTimeDto.setWorkDaysId(WorkDaysMapper.INSTANCE.toDtos(requestDto.getWorkDaysId()));
            save(bookingTimeDto);
            mail.sendEmail(requestDto.getClientId().getEmail(),"Подтвердите код","Mars20");
            return "Вы записались.Подтвердите код!";

        }

        return "Код отправлен вам на почту";
    }

    @Override
    public boolean checkStart(Date startDate, Date masterStartDate){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String formatted = sdf.format(startDate);
        Date parse;
        try {
            parse = sdf.parse(formatted);
            System.out.println(parse);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        if(parse.before(masterStartDate)){
            return false;
        }else if(parse.after(masterStartDate)){

        } return true;
    }
    @Override
    public Boolean checkEnd(Date endDate, Date masterEndDate ){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String formatted = sdf.format(endDate);
        Date parse;
        try {
            parse = sdf.parse(formatted);
            System.out.println(parse);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        if(parse.after(masterEndDate)){
            return false;
        }else if(parse.before(masterEndDate)){

        } return true;
    }

    @Override
    public List<BookingTimeDto> masterBookingCheck(Long masterId) {
        return BookingTimeMapper.INSTANCE.toDtos(rep.findBookingTimeByMaster(masterId));
    }



    public Boolean checkBooking(RequestDto requestDto){
        List<BookingTimeDto> timeDtos = masterBookingCheck(requestDto.getMasterId().getId());
        List<BookingTimeDto> timeDtos1 = new ArrayList<>();
        timeDtos1 = timeDtos.stream().filter(e->e.getEndDate().after(requestDto.getStartDate())).collect(Collectors.toList());
        if(timeDtos1.size()==0)
            return true;
        else
            return false;
    }

}
