package kg.megacom.Salon.mapper;

import kg.megacom.Salon.model.Account;
import kg.megacom.Salon.model.dtos.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper extends BaseMapper<Account, AccountDto>{

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

}
