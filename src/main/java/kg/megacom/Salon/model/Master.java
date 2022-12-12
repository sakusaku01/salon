package kg.megacom.Salon.model;

import kg.megacom.Salon.model.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_master")
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String experience;
    @OneToOne
    @JoinColumn(name = "tb_accountId", referencedColumnName = "id")
    Account accountId;
    @ManyToOne
    @JoinColumn(name = "tb_salonId", referencedColumnName = "id")
    Salon salonId;

}
