package team.mediasoft.study.reactive.flights.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import team.mediasoft.study.reactive.flights.entity.Flight;

@Repository
public interface FlightRepository extends ReactiveCrudRepository<Flight, Integer> {
}
