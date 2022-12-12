package kg.megacom.Salon.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.megacom.Salon.model.Account;
import kg.megacom.Salon.model.BookingTime;
import kg.megacom.Salon.model.Client;
import kg.megacom.Salon.model.Master;
import kg.megacom.Salon.model.WorkDays;
import kg.megacom.Salon.model.dtos.AccountDto;
import kg.megacom.Salon.model.dtos.BookingTimeDto;
import kg.megacom.Salon.model.dtos.ClientDto;
import kg.megacom.Salon.model.dtos.WorkDaysDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-12T14:49:45+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.16 (Oracle Corporation)"
)
public class BookingTimeMapperImpl implements BookingTimeMapper {

    @Override
    public BookingTime toEntity(BookingTimeDto d) {
        if ( d == null ) {
            return null;
        }

        BookingTime bookingTime = new BookingTime();

        bookingTime.setId( d.getId() );
        bookingTime.setStartDate( d.getStartDate() );
        bookingTime.setEndDate( d.getEndDate() );
        bookingTime.setAddDate( d.getAddDate() );
        bookingTime.setUpdateDate( d.getUpdateDate() );
        bookingTime.setBookingStatus( d.getBookingStatus() );
        bookingTime.setWorkDaysId( workDaysDtoListToWorkDaysList( d.getWorkDaysId() ) );
        bookingTime.setClientId( clientDtoToClient( d.getClientId() ) );

        return bookingTime;
    }

    @Override
    public BookingTimeDto toDto(BookingTime e) {
        if ( e == null ) {
            return null;
        }

        BookingTimeDto bookingTimeDto = new BookingTimeDto();

        bookingTimeDto.setId( e.getId() );
        bookingTimeDto.setStartDate( e.getStartDate() );
        bookingTimeDto.setEndDate( e.getEndDate() );
        bookingTimeDto.setAddDate( e.getAddDate() );
        bookingTimeDto.setUpdateDate( e.getUpdateDate() );
        bookingTimeDto.setBookingStatus( e.getBookingStatus() );
        bookingTimeDto.setWorkDaysId( workDaysListToWorkDaysDtoList( e.getWorkDaysId() ) );
        bookingTimeDto.setClientId( clientToClientDto( e.getClientId() ) );

        return bookingTimeDto;
    }

    @Override
    public List<BookingTime> toEntities(List<BookingTimeDto> d) {
        if ( d == null ) {
            return null;
        }

        List<BookingTime> list = new ArrayList<BookingTime>( d.size() );
        for ( BookingTimeDto bookingTimeDto : d ) {
            list.add( toEntity( bookingTimeDto ) );
        }

        return list;
    }

    @Override
    public List<BookingTimeDto> toDtos(List<BookingTime> e) {
        if ( e == null ) {
            return null;
        }

        List<BookingTimeDto> list = new ArrayList<BookingTimeDto>( e.size() );
        for ( BookingTime bookingTime : e ) {
            list.add( toDto( bookingTime ) );
        }

        return list;
    }

    protected WorkDays workDaysDtoToWorkDays(WorkDaysDto workDaysDto) {
        if ( workDaysDto == null ) {
            return null;
        }

        WorkDays workDays = new WorkDays();

        workDays.setId( workDaysDto.getId() );
        workDays.setAddDate( workDaysDto.getAddDate() );
        workDays.setDays( workDaysDto.getDays() );
        workDays.setStartDate( workDaysDto.getStartDate() );
        workDays.setEndDate( workDaysDto.getEndDate() );
        List<Master> list = workDaysDto.getMasterId();
        if ( list != null ) {
            workDays.setMasterId( new ArrayList<Master>( list ) );
        }

        return workDays;
    }

    protected List<WorkDays> workDaysDtoListToWorkDaysList(List<WorkDaysDto> list) {
        if ( list == null ) {
            return null;
        }

        List<WorkDays> list1 = new ArrayList<WorkDays>( list.size() );
        for ( WorkDaysDto workDaysDto : list ) {
            list1.add( workDaysDtoToWorkDays( workDaysDto ) );
        }

        return list1;
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

    protected Client clientDtoToClient(ClientDto clientDto) {
        if ( clientDto == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( clientDto.getId() );
        client.setName( clientDto.getName() );
        client.setEmail( clientDto.getEmail() );
        client.setPhone( clientDto.getPhone() );
        client.setAccountId( accountDtoToAccount( clientDto.getAccountId() ) );

        return client;
    }

    protected WorkDaysDto workDaysToWorkDaysDto(WorkDays workDays) {
        if ( workDays == null ) {
            return null;
        }

        WorkDaysDto workDaysDto = new WorkDaysDto();

        workDaysDto.setId( workDays.getId() );
        workDaysDto.setDays( workDays.getDays() );
        workDaysDto.setAddDate( workDays.getAddDate() );
        workDaysDto.setStartDate( workDays.getStartDate() );
        workDaysDto.setEndDate( workDays.getEndDate() );
        List<Master> list = workDays.getMasterId();
        if ( list != null ) {
            workDaysDto.setMasterId( new ArrayList<Master>( list ) );
        }

        return workDaysDto;
    }

    protected List<WorkDaysDto> workDaysListToWorkDaysDtoList(List<WorkDays> list) {
        if ( list == null ) {
            return null;
        }

        List<WorkDaysDto> list1 = new ArrayList<WorkDaysDto>( list.size() );
        for ( WorkDays workDays : list ) {
            list1.add( workDaysToWorkDaysDto( workDays ) );
        }

        return list1;
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

    protected ClientDto clientToClientDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDto clientDto = new ClientDto();

        clientDto.setId( client.getId() );
        clientDto.setName( client.getName() );
        clientDto.setEmail( client.getEmail() );
        clientDto.setPhone( client.getPhone() );
        clientDto.setAccountId( accountToAccountDto( client.getAccountId() ) );

        return clientDto;
    }
}
