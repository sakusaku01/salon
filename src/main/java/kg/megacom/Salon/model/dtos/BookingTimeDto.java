package kg.megacom.Salon.model.dtos;

import kg.megacom.Salon.model.Client;
import kg.megacom.Salon.model.WorkDays;
import kg.megacom.Salon.model.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class BookingTimeDto {
    Long id;
    Date startDate;
    Date endDate;
    Date addDate;
    Date updateDate;
    Status bookingStatus;
    List<WorkDaysDto> workDaysId;
    ClientDto clientId;
}
