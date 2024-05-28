package com.sd.airlinesscanner.airlineprovider.providers.klm.converters;

import com.sd.airlinesscanner.airlineprovider.enums.FlightType;
import com.sd.airlinesscanner.airlineprovider.providers.klm.client.request.KLMSearchFlightRequest;
import com.sd.airlinesscanner.airlineprovider.request.SearchRequest;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class KLMClientConverter {

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public KLMSearchFlightRequest searchRequestToClientRequest(SearchRequest request){
        KLMSearchFlightRequest.SearchContextPassengersRequest searchContextPassengersRequest = createSearchContextRequest(request);
        return new KLMSearchFlightRequest(
                new KLMSearchFlightRequest.Variables(searchContextPassengersRequest)
        );
    }

    private KLMSearchFlightRequest.SearchContextPassengersRequest createSearchContextRequest(SearchRequest request) {
        return new KLMSearchFlightRequest.SearchContextPassengersRequest()
                .setRequestedConnections(createConnectionList(request));
    }

    private List<KLMSearchFlightRequest.Passenger> createPassengers() {
        ArrayList<KLMSearchFlightRequest.Passenger> passengers = new ArrayList<>();
        passengers.add(
                new KLMSearchFlightRequest.Passenger()
        );
        return passengers;
    }

    List<KLMSearchFlightRequest.Connection> createConnectionList(SearchRequest request){
        List<KLMSearchFlightRequest.Connection> connectionList= new ArrayList<>();
        connectionList.add(createConnection(request.getOutBoundaryFlight()));
        if(FlightType.ROUND_TRIP.equals(request.getFlightType())){
            connectionList.add(createConnection(request.getInBoundaryFlight()));
        }
        return connectionList;
    }

    private KLMSearchFlightRequest.Connection createConnection(SearchRequest.FlightInfo flightInfo) {
        return new KLMSearchFlightRequest.Connection(
                dateFormat.format(flightInfo.getDepartureDate()),
                createAirport(flightInfo.getFromAirport().getCode()),
                createAirport(flightInfo.getToAirport().getCode())
        );
    }

    private KLMSearchFlightRequest.KLMAirport createAirport(String code) {
        return new KLMSearchFlightRequest.KLMAirport(
                new KLMSearchFlightRequest.Code(code)
        );
    }
}
