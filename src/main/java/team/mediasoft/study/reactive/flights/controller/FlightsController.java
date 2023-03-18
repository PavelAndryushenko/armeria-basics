package team.mediasoft.study.reactive.flights.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.mediasoft.study.reactive.flights.dto.Flight;
import team.mediasoft.study.reactive.flights.service.FlightService;

import java.util.List;

@RestController
@RequestMapping("/flight")
@RequiredArgsConstructor
public class FlightsController {

    private final FlightService flightService;

    @GetMapping("/{id}")
    public Flight getById(@PathVariable Integer id) {
        return flightService.findById(id);
    }

    @GetMapping("/all")
    public List<Flight> getAll() {
        return flightService.getAllFlights();
    }
}
