package kg.megacom.Salon.model.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto {
    Long id;
    String login;
    String password;
}
