package team.mediasoft.study.reactive.flights.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import team.mediasoft.study.reactive.flights.dto.Flight;
import team.mediasoft.study.reactive.flights.service.FlightService;

@RestController
@RequestMapping("/flight")
@RequiredArgsConstructor
public class FlightsController {

    private final FlightService flightService;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Flight>> getById(@PathVariable Integer id) {
        return flightService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public Flux<Flight> getAll() {
        return flightService.getAllFlights();
    }
}
