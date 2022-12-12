package kg.megacom.Salon.model.dtos;

import kg.megacom.Salon.model.Account;
import kg.megacom.Salon.model.Salon;
import kg.megacom.Salon.model.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
@Getter
@Setter
public class MasterDto {
    Long id;
    String name;
    String experience;
    AccountDto accountId;
    SalonDto salonId;
}
