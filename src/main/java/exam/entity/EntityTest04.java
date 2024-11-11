package exam.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class EntityTest04 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIME) // DB타입이 time
	private Date utilTime;

	@Temporal(TemporalType.DATE) // DB타입이 date
	private Date utilDate;

	@Temporal(TemporalType.TIMESTAMP) // DB타입이 datetime
	private Date utilTimeStamp;

	private Date utilPlainDate; // DB타입이 datetime
	private java.sql.Date sqlPlainDate; // DB타입이 date

	@Column(columnDefinition = "TIME")
	private LocalTime localTime1; // DB타입이 TIME 객체로 들어옴

	// @Column이 없는 경우
	private LocalTime localTime2; // DB타입이 time(6)

	@Column(columnDefinition = "DATE")
	private LocalDate localDate1; // DB타입이 DATE 객체로 들어옴

	// @Column이 없는 경우
	private LocalDate localDate2; // DB타입이 date(6)

	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime localDateTime1; // DB타입이 TIMESTAMP

	// @Column이 없는 경우
	private LocalDateTime localDateTime2; // DB타입이 datetime(6)
}