package team.mediasoft.study.reactive.flights.controller;

import lombok.RequiredArgsConstructor;
import org.apache.thrift.async.AsyncMethodCallback;
import team.mediasoft.study.reactive.flights.annotation.ThriftController;
import team.mediasoft.study.reactive.flights.mapper.FlightMapper;
import team.mediasoft.study.reactive.flights.service.FlightService;
import team.mediasoft.study.reactive.flights.thrift.FlightsThriftService;
import team.mediasoft.study.reactive.flights.thrift.TGetFlightByAircraftResponse;

@ThriftController(path = "/tapi/flights")
@RequiredArgsConstructor
public class FlightsThriftController implements FlightsThriftService.AsyncIface {

    private final FlightService flightService;
    private final FlightMapper flightMapper;

    @Override
    public void getFlightByAircraft(String aircraft, AsyncMethodCallback<TGetFlightByAircraftResponse> resultHandler) {
        flightService.getByAircraft(aircraft)
                .map(flightMapper::toThriftFlight)
                .collectList()
                .map(flights -> new TGetFlightByAircraftResponse().setFlights(flights))
                .subscribe(resultHandler::onComplete);
    }
}
