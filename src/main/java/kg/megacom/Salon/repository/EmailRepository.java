package kg.megacom.Salon.repository;


import kg.megacom.Salon.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailRepository extends JpaRepository<Email,Long> {

    @Query("select m from Email m where m.code=:code")
    Optional<Email> findCode(String code);
}
