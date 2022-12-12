package kg.megacom.Salon.services.impl;

import kg.megacom.Salon.mapper.AccountMapper;
import kg.megacom.Salon.model.Account;
import kg.megacom.Salon.model.dtos.AccountDto;
import kg.megacom.Salon.repository.AccountRepository;
import kg.megacom.Salon.services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServicesImpl implements AccountServices {

    @Autowired
    private AccountRepository accountRep;

    @Override
    public AccountDto save(AccountDto dto) {
        return AccountMapper.INSTANCE.toDto(accountRep.save(AccountMapper.INSTANCE.toEntity(dto)));
    }

    @Override
    public AccountDto findById(Long id) {
        return AccountMapper.INSTANCE.toDto(accountRep.findById
                (id).orElseThrow(()->new RuntimeException("Не найден аккаунт с таким id")));
    }

    @Override
    public List<AccountDto> findAll() {
        return AccountMapper.INSTANCE.toDtos(accountRep.findAll());
    }
}
