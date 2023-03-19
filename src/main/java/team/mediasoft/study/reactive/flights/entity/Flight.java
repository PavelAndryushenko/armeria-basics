package team.mediasoft.study.reactive.flights.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Flight {

    private Integer id;
    private String aircraft;
    private String departureAirport;
    private String arrivalAirport;
}
