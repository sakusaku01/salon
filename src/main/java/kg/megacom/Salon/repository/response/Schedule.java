package kg.megacom.Salon.repository.response;

import kg.megacom.Salon.model.enums.Days;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@FieldDefaults(level = AccessLevel.PRIVATE)

public interface Schedule {
  Date getStartDate();
  Date getEndDate();
  Days getDays();




}
