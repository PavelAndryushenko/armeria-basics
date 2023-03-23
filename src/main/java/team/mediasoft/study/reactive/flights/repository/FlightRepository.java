package team.mediasoft.study.reactive.flights.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import team.mediasoft.study.reactive.flights.entity.Flight;

@Repository
public interface FlightRepository extends ReactiveCrudRepository<Flight, Integer> {

    Flux<Flight> findByAircraft(String aircraft);
}