package kg.megacom.Salon.model.dtos;


import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ClientDto {
    Long id;
    String name;
    String email;
    String phone;
    AccountDto accountId;

}
