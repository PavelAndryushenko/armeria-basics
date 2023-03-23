package team.mediasoft.study.reactive.flights.mapper;

import org.mapstruct.Mapper;
import team.mediasoft.study.reactive.flights.dto.FlightDto;
import team.mediasoft.study.reactive.flights.entity.Flight;
import team.mediasoft.study.reactive.flights.thrift.TFlight;

@Mapper(config = MapStructConfig.class)
public interface FlightMapper {

    FlightDto toDto(Flight flight);

    TFlight toThriftFlight(Flight flight);
}
