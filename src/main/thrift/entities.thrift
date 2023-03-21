namespace java team.mediasoft.study.reactive.flights.thrift

struct TFlight {
    1: i32  id
    2: string   aircraft
    3: string   departureAirport
    4: string   arrivalAirport
}

struct TGetFlightByAircraftResponse {
    1: list<TFlight>    flights
}