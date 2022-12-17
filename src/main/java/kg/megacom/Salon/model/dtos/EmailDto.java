package kg.megacom.Salon.model.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmailDto {

    Long id;
    String code;
    Date sendDate;
    Date bringDate;

}
