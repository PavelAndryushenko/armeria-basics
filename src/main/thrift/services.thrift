include "./entities.thrift"

namespace java team.mediasoft.study.reactive.flights.thrift

service FlightsThriftService {
    entities.TGetFlightByAircraftResponse getFlightByAircraft (
        1: required string  aircraft
    )
}