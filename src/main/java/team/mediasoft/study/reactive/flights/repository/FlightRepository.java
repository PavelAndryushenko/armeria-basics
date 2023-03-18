package team.mediasoft.study.reactive.flights.repository;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import team.mediasoft.study.reactive.flights.dto.Flight;

import java.util.Set;

@Component
public class FlightRepository {

    private final static Set<Flight> FLIGHTS = Set.of(
            new Flight(1, "Boeing 777-300ER", "SVO", "LAX"),
            new Flight(2, "Boeing 737-800", "KUF", "LED"),
            new Flight(3, "Airbus A350-1000", "CDG", "HKG")
    );

    public Mono<Flight> findById(Integer id) {
        return Flux.fromIterable(FLIGHTS).filter(f -> f.getId().equals(id)).next();
    }

    public Flux<Flight> findAll() {
        return Flux.fromIterable(FLIGHTS);
    }
}
