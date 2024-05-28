package com.sd.airlinesscanner.airlineprovider.providers.klm.client.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.logging.log4j.util.Strings;

import java.util.List;

public class KLMSearchFlightRequest{
    @JsonProperty("operationName")
    private final String operationName = "SearchContextPassengersForSearchQuery";

    private Variables variables;
    private Extensions extensions;

    public KLMSearchFlightRequest(Variables variables) {
        this.variables = variables;
        this.extensions = new Extensions();
    }

    public static class Variables {

        public Variables(SearchContextPassengersRequest searchContextPassengersRequest){
            this.searchContextPassengersRequest = searchContextPassengersRequest;
        }
        @JsonProperty("searchContextPassengersRequest")
        private SearchContextPassengersRequest searchContextPassengersRequest;

        @JsonProperty("searchStateUuid")
        private String searchStateUuid= Strings.EMPTY;

    }

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class SearchContextPassengersRequest {
        private final List<String> commercialCabins = List.of("ECONOMY");
        private final String bookingFlow = "LEISURE";
        private final List<Passenger> passengers = List.of(new Passenger());
        private List<Connection> requestedConnections;

        // Constructor, getters, and setters
        // ...
    }

    public static class Passenger {
        private final String type = "ADT";
        private final int id = 1;
    }

    @Accessors(chain = true)
    @AllArgsConstructor
    public static class Connection {
        private String departureDate;
        private KLMAirport origin;
        private KLMAirport destination;

    }


    @Getter
    @AllArgsConstructor
    public static class KLMAirport {
        private Code airport;
    }

    @Getter
    @AllArgsConstructor
    public static class Code {
        private String code;
    }

    public static class Extensions {
        @JsonProperty("persistedQuery")
        private PersistedQuery persistedQuery;

        public Extensions() {
            this.persistedQuery = new PersistedQuery(); // Assuming persistedQuery is fixed and known
        }

        @Getter
        private static final class PersistedQuery {
            private  final  int version = 1;
            private  final String sha256Hash = Strings.EMPTY;
        }
    }

    // Method to convert this object to JSON string
//    public String toJson() throws Exception {
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.writeValueAsString(this);
//    }
}
