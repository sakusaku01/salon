package kg.megacom.Salon.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.megacom.Salon.model.Account;
import kg.megacom.Salon.model.Client;
import kg.megacom.Salon.model.dtos.AccountDto;
import kg.megacom.Salon.model.dtos.ClientDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-17T22:53:44+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.16 (Oracle Corporation)"
)
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client toEntity(ClientDto d) {
        if ( d == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( d.getId() );
        client.setName( d.getName() );
        client.setEmail( d.getEmail() );
        client.setPhone( d.getPhone() );
        client.setAccountId( accountDtoToAccount( d.getAccountId() ) );

        return client;
    }

    @Override
    public ClientDto toDto(Client e) {
        if ( e == null ) {
            return null;
        }

        ClientDto clientDto = new ClientDto();

        clientDto.setId( e.getId() );
        clientDto.setName( e.getName() );
        clientDto.setEmail( e.getEmail() );
        clientDto.setPhone( e.getPhone() );
        clientDto.setAccountId( accountToAccountDto( e.getAccountId() ) );

        return clientDto;
    }

    @Override
    public List<Client> toEntities(List<ClientDto> d) {
        if ( d == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( d.size() );
        for ( ClientDto clientDto : d ) {
            list.add( toEntity( clientDto ) );
        }

        return list;
    }

    @Override
    public List<ClientDto> toDtos(List<Client> e) {
        if ( e == null ) {
            return null;
        }

        List<ClientDto> list = new ArrayList<ClientDto>( e.size() );
        for ( Client client : e ) {
            list.add( toDto( client ) );
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
}
