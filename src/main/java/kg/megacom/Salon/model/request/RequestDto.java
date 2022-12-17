package kg.megacom.Salon.model.request;

import kg.megacom.Salon.model.Client;
import kg.megacom.Salon.model.Master;
import kg.megacom.Salon.model.WorkDays;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestDto {
    Date startDate;
    Date endDate;
    Master masterId;
    Client clientId;
    int index;
    List<WorkDays> workDaysId;
}
