package kg.megacom.Salon.model;

import kg.megacom.Salon.model.enums.Days;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_workDays", uniqueConstraints = {@UniqueConstraint(columnNames = {"end_date", "start_date"})})
public class WorkDays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Temporal(TemporalType.TIME)
    Date addDate;
    @Enumerated(EnumType.STRING)
    Days days;
    @Temporal(TemporalType.TIME)
    @Column(name = "start_date")
    Date startDate;
    @Temporal(TemporalType.TIME)
    @Column(name = "end_date")
    Date endDate;
    @ManyToMany
    @JoinTable(
            name = "tb_work_day_master",
            joinColumns = {@JoinColumn(name = "work_day_id")},
            inverseJoinColumns = {@JoinColumn(name = "master_id")})
    List<Master> masterId;



}
