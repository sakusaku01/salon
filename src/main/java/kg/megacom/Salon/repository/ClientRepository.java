package kg.megacom.Salon.repository;

import kg.megacom.Salon.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
