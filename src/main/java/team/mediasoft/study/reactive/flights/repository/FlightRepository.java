package team.mediasoft.study.reactive.flights.repository;

import org.springframework.stereotype.Component;
import team.mediasoft.study.reactive.flights.dto.Flight;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FlightRepository {

    private final static Set<Flight> FLIGHTS = Set.of(
            new Flight(1, "Boeing 777-300ER", "SVO", "LAX"),
            new Flight(2, "Boeing 737-800", "KUF", "LED"),
            new Flight(3, "Airbus A350-1000", "CDG", "HKG")
    );

    public Optional<Flight> findById(Integer id) {
        return  FLIGHTS.stream().filter(f -> f.getId().equals(id)).findFirst();
    }

    public List<Flight> findAll() {
        return FLIGHTS.stream().collect(Collectors.toList());
    }
}
