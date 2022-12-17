package kg.megacom.Salon;

import kg.megacom.Salon.services.EmailSenderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SalonApplication {
	public static void main(String[] args) {
		SpringApplication.run(SalonApplication.class, args);
	}



}
