package com.sd.airlinesscanner.airlineprovider.providers.turkish.client.converters;

import com.sd.airlinesscanner.airlineprovider.providers.turkish.client.request.TurkishSearchFlightRequest;
import com.sd.airlinesscanner.airlineprovider.request.SearchRequest;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class TurkishClientRequestConverter {


    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMM");


    public TurkishSearchFlightRequest searchRequestToClientRequest(SearchRequest request){

        return TurkishSearchFlightRequest.builder()
                .passengerTypeQuantity(passengers())
                .originDestinationInformation(originDestinationInformations(request))
                .build();
    }

    List<TurkishSearchFlightRequest.PassengerTypeQuantity> passengers(){
        return List.of(
                TurkishSearchFlightRequest
                        .PassengerTypeQuantity.builder()
                        .code("adult")
                        .quantity(1)
                        .build()
        );
    }

    List<TurkishSearchFlightRequest.OriginDestinationInformation> originDestinationInformations(SearchRequest request){

        TurkishSearchFlightRequest.OriginDestinationInformation outBoundDestinationInformation =
                createOriginDestinationInformation(request);



        return List.of(
                outBoundDestinationInformation

        );
    }

    private TurkishSearchFlightRequest.OriginDestinationInformation createOriginDestinationInformation(SearchRequest request) {
        return TurkishSearchFlightRequest.OriginDestinationInformation.builder()
                .departureDateTime(
                        TurkishSearchFlightRequest.DepartureDateTime
                                .builder()
                                .date(request.getOutBoundaryFlight().getDepartureDate().format(dateTimeFormatter).toUpperCase())
                                .build()
                )
                .originLocation(
                        TurkishSearchFlightRequest.Location.builder().locationCode("AMS").build()
                )
                .destinationLocation(TurkishSearchFlightRequest.Location.builder().locationCode("IST").build())
                .cabinPreferences(
                        List.of(
                                TurkishSearchFlightRequest.CabinPreference.builder().cabin("ECONOMY").build(),
                                TurkishSearchFlightRequest.CabinPreference.builder().cabin("BUSINESS").build()
                        )
                )
                .build();
    }


}
