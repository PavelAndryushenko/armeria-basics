package team.mediasoft.study.reactive.flights.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import team.mediasoft.study.reactive.flights.dto.FlightDto;
import team.mediasoft.study.reactive.flights.entity.Flight;
import team.mediasoft.study.reactive.flights.mapper.FlightMapper;
import team.mediasoft.study.reactive.flights.repository.FlightRepository;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    public Mono<FlightDto> findById(Integer id) {
        return flightRepository.findById(id).map(flightMapper::toDto);
    }

    public Flux<FlightDto> getAllFlights() {
        return flightRepository.findAll().map(flightMapper::toDto);
    }

    public Flux<Flight> getByAircraft(String aircraft) {
        return flightRepository.findByAircraft(aircraft);
    }
}
