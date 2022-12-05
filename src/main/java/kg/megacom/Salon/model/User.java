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
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    int age;
    String experience;
    @Temporal(TemporalType.TIME)
    Date firstgraph;
    @Enumerated(EnumType.STRING)
    Status status;
    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    Account accountId;

}
