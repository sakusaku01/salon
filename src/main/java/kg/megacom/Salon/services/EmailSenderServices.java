package kg.megacom.Salon.services;

import kg.megacom.Salon.model.dtos.EmailDto;
import kg.megacom.Salon.model.request.EmailRequest;

public interface EmailSenderServices extends BaseServices<EmailDto>{
    void sendEmail(String toEmail,String subject,String body);

    String codeCheck(EmailRequest request);
}
