package kg.megacom.Salon.services.impl;

import kg.megacom.Salon.mapper.EmailMapper;
import kg.megacom.Salon.model.Email;
import kg.megacom.Salon.model.dtos.EmailDto;
import kg.megacom.Salon.model.request.EmailRequest;
import kg.megacom.Salon.repository.EmailRepository;
import kg.megacom.Salon.services.EmailSenderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class EmailSenderServicesImpl implements EmailSenderServices {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailRepository rep;


    @Override
    public void sendEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("tatybaev2@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
        EmailDto dto = new EmailDto();
        dto.setCode(body);
        dto.setSendDate(new Date());
        dto.setBringDate(new Date());
        save(dto);

        System.out.println("Успешно отправлен и сохранен");

    }

    @Override
    public String codeCheck(EmailRequest request) {

        Email email = rep.findCode(request.getCode()).orElse(null);
        if (!checkDate(email.getSendDate())){
            return "Срок истек";
        }
        return "Код верный";
    }

    @Override
    public EmailDto save(EmailDto emailDto) {
        return EmailMapper.INSTANCE.toDto(rep.save(EmailMapper.INSTANCE.toEntity(emailDto)));
    }

    @Override
    public EmailDto findById(Long id) {
        return EmailMapper.INSTANCE.toDto(rep.findById
                (id).orElseThrow(()->new RuntimeException("Не найден  с таким id")));
    }

    @Override
    public List<EmailDto> findAll() {
        return EmailMapper.INSTANCE.toDtos(rep.findAll());
    }

    private Boolean  checkDate(Date sendDate) {
        Calendar checkDate=Calendar.getInstance();
        checkDate.setTime(sendDate);
        checkDate.add(Calendar.MINUTE,2);
        return new Date().before(checkDate.getTime());

    }
}
