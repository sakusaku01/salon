package kg.megacom.Salon.model.request;

import kg.megacom.Salon.model.enums.Days;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScheduleRequest {
    Date startDate;
    Date endDate;
    Days days;
}
