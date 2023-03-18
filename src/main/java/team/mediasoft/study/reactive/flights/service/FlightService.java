package team.mediasoft.study.reactive.flights.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.mediasoft.study.reactive.flights.dto.Flight;
import team.mediasoft.study.reactive.flights.repository.FlightRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    public Flight findById(Integer id) {
        return flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Flight not found"));
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
}
