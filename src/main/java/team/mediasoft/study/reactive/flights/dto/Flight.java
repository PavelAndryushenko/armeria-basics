package team.mediasoft.study.reactive.flights.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class Flight {

    private final Integer id;
    private final String aircraft;
    private final String departureAirport;
    private final String arrivalAirport;
}
