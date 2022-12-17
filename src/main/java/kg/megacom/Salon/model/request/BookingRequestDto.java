package kg.megacom.Salon.model.request;

import kg.megacom.Salon.model.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingRequestDto {
    Date startDate;
    Date endDate;
    Status status;
}
