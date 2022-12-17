package kg.megacom.Salon.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.megacom.Salon.model.Account;
import kg.megacom.Salon.model.Master;
import kg.megacom.Salon.model.Salon;
import kg.megacom.Salon.model.dtos.AccountDto;
import kg.megacom.Salon.model.dtos.MasterDto;
import kg.megacom.Salon.model.dtos.SalonDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-17T22:53:53+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.16 (Oracle Corporation)"
)
public class MasterMapperImpl implements MasterMapper {

    @Override
    public Master toEntity(MasterDto d) {
        if ( d == null ) {
            return null;
        }

        Master master = new Master();

        master.setId( d.getId() );
        master.setName( d.getName() );
        master.setExperience( d.getExperience() );
        master.setAccountId( accountDtoToAccount( d.getAccountId() ) );
        master.setSalonId( salonDtoToSalon( d.getSalonId() ) );

        return master;
    }

    @Override
    public MasterDto toDto(Master e) {
        if ( e == null ) {
            return null;
        }

        MasterDto masterDto = new MasterDto();

        masterDto.setId( e.getId() );
        masterDto.setName( e.getName() );
        masterDto.setExperience( e.getExperience() );
        masterDto.setAccountId( accountToAccountDto( e.getAccountId() ) );
        masterDto.setSalonId( salonToSalonDto( e.getSalonId() ) );

        return masterDto;
    }

    @Override
    public List<Master> toEntities(List<MasterDto> d) {
        if ( d == null ) {
            return null;
        }

        List<Master> list = new ArrayList<Master>( d.size() );
        for ( MasterDto masterDto : d ) {
            list.add( toEntity( masterDto ) );
        }

        return list;
    }

    @Override
    public List<MasterDto> toDtos(List<Master> e) {
        if ( e == null ) {
            return null;
        }

        List<MasterDto> list = new ArrayList<MasterDto>( e.size() );
        for ( Master master : e ) {
            list.add( toDto( master ) );
        }

        return list;
    }

    protected Account accountDtoToAccount(AccountDto accountDto) {
        if ( accountDto == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( accountDto.getId() );
        account.setLogin( accountDto.getLogin() );
        account.setPassword( accountDto.getPassword() );

        return account;
    }

    protected Salon salonDtoToSalon(SalonDto salonDto) {
        if ( salonDto == null ) {
            return null;
        }

        Salon salon = new Salon();

        salon.setId( salonDto.getId() );
        salon.setName( salonDto.getName() );
        salon.setAddress( salonDto.getAddress() );

        return salon;
    }

    protected AccountDto accountToAccountDto(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountDto accountDto = new AccountDto();

        accountDto.setId( account.getId() );
        accountDto.setLogin( account.getLogin() );
        accountDto.setPassword( account.getPassword() );

        return accountDto;
    }

    protected SalonDto salonToSalonDto(Salon salon) {
        if ( salon == null ) {
            return null;
        }

        SalonDto salonDto = new SalonDto();

        salonDto.setId( salon.getId() );
        salonDto.setName( salon.getName() );
        salonDto.setAddress( salon.getAddress() );

        return salonDto;
    }
}
