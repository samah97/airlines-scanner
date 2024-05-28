package com.sd.airlinesscanner.airlineprovider.providers.turkish.client.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Builder
public class TurkishSearchFlightRequest {
    @JsonProperty("requestHeader")
    private final RequestHeader requestHeader= new RequestHeader();
    private final boolean reducedDataIndicator;
    private final String routingType="O";
    private final String targetSource="PREMIUM";
    private List<PassengerTypeQuantity> passengerTypeQuantity;
    private List<OriginDestinationInformation> originDestinationInformation;

    @Getter
    @Setter
    public static class RequestHeader {
        @JsonProperty("clientUsername")
        private final String clientUsername = "OPENAPI";
        @JsonProperty("clientTransactionId")
        private final String clientTransactionId = "CLIENT_TEST_1";
        @JsonProperty("channel")
        private final String channel = "WEB";
    }

    @Getter
    @Setter
    @Builder
    public static class PassengerTypeQuantity {
        private String code;
        private int quantity;
    }

    @Getter
    @Setter
    @Builder
    public static class OriginDestinationInformation {
//        @JsonProperty("DepartureDateTime")
        private DepartureDateTime departureDateTime;
//        @JsonProperty("OriginLocation")
        private Location originLocation;
//        @JsonProperty("DestinationLocation")
        private Location destinationLocation;
//        @JsonProperty("FlightTypePref")
        private final FlightTypePref flightTypePref = new FlightTypePref();
//        @JsonProperty("CabinPreferences")
        private List<CabinPreference> cabinPreferences;
    }

    @Getter
    @Setter
    @Builder
    public static class DepartureDateTime {
        private final String windowAfter = "P0D";
        private final String windowBefore = "P0D";
        private String date;
    }

    @Getter
    @Setter
    @Builder
    public static class Location {
        private String locationCode;
        private boolean multiAirportCityInd;
    }

    @Getter
    @Setter
    public static class FlightTypePref {
        private final String maxConnections = "1";
    }

    @Getter
    @Setter
    @Builder
    public static class CabinPreference {
        private String cabin;
    }

}


