package team.mediasoft.study.reactive.flights.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table("flights")
public class Flight {

    @Id
    private Integer id;

    @Column("aircraft")
    private String aircraft;

    @Column("departure_airport")
    private String departureAirport;

    @Column("arrival_airport")
    private String arrivalAirport;
}
