package kg.megacom.Salon.model.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.megacom.Salon.model.Master;
import kg.megacom.Salon.model.enums.Days;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class WorkDaysDto {
    Long id;
    Days days;
    @JsonIgnore
    Date addDate;
    Date startDate;
    Date endDate;
    @JsonIgnore
    List<Master> masterId;
}
