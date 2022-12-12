package kg.megacom.Salon.model;

import kg.megacom.Salon.model.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_bookingTime")
public class BookingTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Temporal(TemporalType.TIME)
    Date startDate;
    @Temporal(TemporalType.TIME)
    Date endDate;
    @Temporal(TemporalType.TIME)
    Date addDate;
    @Temporal(TemporalType.TIME)
    Date updateDate;
    Status bookingStatus;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tb_work_day_booking",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "work_day_id"))
    List<WorkDays> workDaysId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tb_clientId")
    Client clientId;
}
