package kg.megacom.Salon.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import kg.megacom.Salon.model.Email;
import kg.megacom.Salon.model.dtos.EmailDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-17T22:53:48+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.16 (Oracle Corporation)"
)
public class EmailMapperImpl implements EmailMapper {

    @Override
    public Email toEntity(EmailDto d) {
        if ( d == null ) {
            return null;
        }

        Email email = new Email();

        email.setId( d.getId() );
        email.setCode( d.getCode() );
        email.setSendDate( d.getSendDate() );
        email.setBringDate( d.getBringDate() );

        return email;
    }

    @Override
    public EmailDto toDto(Email e) {
        if ( e == null ) {
            return null;
        }

        EmailDto emailDto = new EmailDto();

        emailDto.setId( e.getId() );
        emailDto.setCode( e.getCode() );
        emailDto.setSendDate( e.getSendDate() );
        emailDto.setBringDate( e.getBringDate() );

        return emailDto;
    }

    @Override
    public List<Email> toEntities(List<EmailDto> d) {
        if ( d == null ) {
            return null;
        }

        List<Email> list = new ArrayList<Email>( d.size() );
        for ( EmailDto emailDto : d ) {
            list.add( toEntity( emailDto ) );
        }

        return list;
    }

    @Override
    public List<EmailDto> toDtos(List<Email> e) {
        if ( e == null ) {
            return null;
        }

        List<EmailDto> list = new ArrayList<EmailDto>( e.size() );
        for ( Email email : e ) {
            list.add( toDto( email ) );
        }

        return list;
    }
}
