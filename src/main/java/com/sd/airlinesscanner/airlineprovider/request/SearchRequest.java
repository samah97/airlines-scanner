package com.sd.airlinesscanner.airlineprovider.request;

import com.sd.airlinesscanner.airlineprovider.enums.FlightType;
import com.sd.airlinesscanner.model.Airport;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class SearchRequest {

    FlightType flightType;
    FlightInfo outBoundaryFlight;
    FlightInfo inBoundaryFlight;

    @Getter
    @Setter
    public static class FlightInfo{
        private LocalDate departureDate;
        private Airport fromAirport;
        private Airport toAirport;
    }

}
