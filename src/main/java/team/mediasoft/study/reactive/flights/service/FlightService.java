package team.mediasoft.study.reactive.flights.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import team.mediasoft.study.reactive.flights.dto.Flight;
import team.mediasoft.study.reactive.flights.repository.FlightRepository;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    public Mono<Flight> findById(Integer id) {
        return flightRepository.findById(id);
    }

    public Flux<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
}
